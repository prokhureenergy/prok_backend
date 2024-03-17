package com.prokhure.erp.domain.service;

import com.prokhure.erp.domain.constants.TokenConst;
import com.prokhure.erp.domain.exception.ConflictException;
import com.prokhure.erp.domain.exception.NotFoundException;
import com.prokhure.erp.domain.ports.api.UserServicePort;
import com.prokhure.erp.domain.ports.spi.UserTrackerPersistencePort;
import com.prokhure.erp.infrastructure.dto.AuthenticationDto;
import com.prokhure.erp.infrastructure.dto.TokenDto;
import com.prokhure.erp.infrastructure.entity.users.Bank;
import com.prokhure.erp.infrastructure.entity.views.UsersView;
import com.prokhure.erp.infrastructure.mapper.UserRegAuthDto;
import com.prokhure.erp.service.model.*;
import com.prokhure.erp.service.model.Error;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class UserServiceImpl implements UserServicePort {
    private  final String CHARACTERS = "0123456789";
    private  final int TOKEN_LENGTH = 6;
    private final UserTrackerPersistencePort userTrackerPersistencePort;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserTrackerPersistencePort userTrackerPersistencePort,
                           PasswordEncoder passwordEncoder) {
        this.userTrackerPersistencePort = userTrackerPersistencePort;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public ResponseDto processUserRegistration(Registration model) {
        checkIfuserExistByRoleAndEmailReg(model.getEmail(), model.getRole().name());
        String userUuid = processUserPerType(model);
        AuthenticationDto authenticationDto = new AuthenticationDto(
                userUuid,
                model.getEmail(),
                passwordEncoder.encode(model.getPassword()),
                "hash",
                model.getRole().name()
        );
        userTrackerPersistencePort.saveAuthenticationDetails(authenticationDto);
        generateToken(userUuid,model.getRole().name(), model.getEmail(), TokenConst.EMAIL_VALIDATION);
        return new ResponseDto().status("00")
            .description("successful")
            .data(new ResponseDtoData().partyId(UUID.fromString(userUuid)).message(String.format(
                    "account created for %s and token sent, kindly verify your email", model.getEmail()
            )));
    }

    @Override
    public AuthenticationResponse processAuthentication(Authentication model) {
        var userAuth = getUserByRoleAndEmailReg(model.getEmail(), model.getRole().name());
        String name = null;
        if(model.getRole().equals(Authentication.RoleEnum.VENDOR)) {
            var user = userTrackerPersistencePort.getVendorByVendorId(userAuth.getUserUuid());
            if ("individual".equals(user.getBusinessType())){
                name = String.format("%s %s", user.getFirstName(), user.getLastName());
            }else {
                name = user.getBusinessName();
            }
        } else if(model.getRole().equals(Authentication.RoleEnum.ORGANIZATION)) {
            name = "name";
        } else {
            var user = userTrackerPersistencePort.getUserByUserId(userAuth.getUserUuid());
            name = String.format("%s %s", user.getFirstName(), user.getLastName());
        }
        AuthenticationResponseDataUserDetail userDetails = new AuthenticationResponseDataUserDetail()
                .userId(userAuth.getUserUuid())
                .name(name)
                .email(userAuth.getEmail())
                .role(userAuth.getUserRole());
        AuthenticationResponseDataTokenDetail tokenDetail = new AuthenticationResponseDataTokenDetail()
                .token(JwtUtilityService.generateAccessToken(userAuth.getEmail(),userAuth.getUserRole(),userAuth.getUserUuid()))
                .refreshToken(JwtUtilityService.generateRefreshToken(userAuth.getEmail(),userAuth.getUserRole(),userAuth.getUserUuid()))
                .expirationTime(new BigDecimal(18293773L)); //todo change
        AuthenticationResponseData data = new AuthenticationResponseData()
                .userDetail(userDetails)
                .tokenDetail(tokenDetail);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse()
                .status("00")
                .description("successful")
                .data(data);
        return authenticationResponse;
    }

    @Override
    public ResponseDto processPasswordReset(AuthUserResetPasswordRequest model) {
      var userOptional =  userTrackerPersistencePort.findByUserId(model.getPartyId().toString());
      if(!userOptional.isPresent()) {
          throwNotException("404", "user not found");
      }
        var authentication = userOptional.get();
        authentication.setPassword(model.getPassword());
        authentication.setPasswordHash("hash");
        userTrackerPersistencePort.updateAuthentication(authentication);
        return new ResponseDto().status("00")
            .description("successful")
            .data(new ResponseDtoData().partyId(model.getPartyId()).message(String.format(
                    "password updated for %s ", authentication.getEmail()
            )));
    }

    @Override
    public ResponseDto processPasswordResetViaEmail(ResetPasswordByEmailRequest model) {
        checkIfuserExistByRoleAndEmail(model.getEmail(), model.getRole().name());
        var user = getUserByRoleAndEmailReg(model.getEmail(), model.getRole().name());
        generateToken(user.getUserUuid(),model.getRole().name(), model.getEmail(), TokenConst.PASSWORD_VALIDATION);
        return new ResponseDto().status("00")
                .description("successful")
                .data(new ResponseDtoData().partyId(UUID.fromString(user.getUserUuid())).message(String.format(
                        "Email validated for %s and token sent, kindly verify your email", model.getEmail()
                )));
    }

    @Override
    public BankDetailResponse addBankDetails(BankRegistration model) {
        var bank = userTrackerPersistencePort.getBank(model.getBankId().toString());
        validateBankAndUser(model, bank, false);
        model.setBankName(bank.getBankName());
       var userBank = userTrackerPersistencePort.saveUserBankDetail(model);
       return new BankDetailResponse()
               .status("00")
               .description("successful")
               .data(new BankDetail()
                       .bankName(userBank.getBankName()).userBankId(UUID.fromString(userBank.getUserBankUuid()))
                       .bankId(UUID.fromString(userBank.getBankUuid())).partyId(UUID.fromString(userBank.getUserUuid())));
    }

    private void validateBankAndUser(BankRegistration model, Bank bank, boolean isUpdate) {
        if(bank == null) {
            throwNotException("404", "Invalid bank");
        }
        var bankDetails =  userTrackerPersistencePort.getBanksPerUser(model.getPartyId().toString());
        if(!bankDetails.isEmpty() && !isUpdate) {
            throwNotException("409", "Bank detail exist for user");
        }
        var userOptional =  userTrackerPersistencePort.findByUserId(model.getPartyId().toString());
        if(!userOptional.isPresent()) {
            throwNotException("404", "user not found");
        }
    }

    @Override
    public BankDetails getUserBankDetail(String userPartyId) {
        var bankPerUser = userTrackerPersistencePort.getBanksPerUser(userPartyId);
        if(bankPerUser == null) {
            throwNotException("404", "No bank assigned to user");
        }
        List<BankDetail> bankDetails = bankPerUser.stream()
                .map(x -> new BankDetail().bankId(UUID.fromString(x.getBankUuid()))
                        .bankName(x.getBankName()).userBankId(UUID.fromString(x.getUserBankUuid()))
                        .partyId(UUID.fromString(x.getUserUuid()))).toList();
        return new BankDetails().status("00")
                .description("successful")
                .data(bankDetails);
    }

    @Override
    public BankDetails getAllBanks() {
      var banks =  userTrackerPersistencePort.getBanks();
      List<BankDetail> bankDetails = banks.stream()
              .map(x -> new BankDetail().bankId(UUID.fromString(x.getBankUUID()))
                      .bankName(x.getBankName())).toList();
        return new BankDetails().status("00")
                .description("successful")
                .data(bankDetails);
    }

    @Override
    public BankDetailResponse updateBank(BankRegistration bankRegistration) {
        var bank = userTrackerPersistencePort.getBank(bankRegistration.getBankId().toString());
        validateBankAndUser(bankRegistration, bank, true);
      var bankDetails =  userTrackerPersistencePort.getBanksPerUser(bankRegistration.getPartyId().toString());
      if(bankDetails == null) {
          throwNotException("404", "Invalid bank detail supplied");
      }
        var bankDetail =  bankDetails.getFirst();
        bankDetail.setAccountNumber(bankRegistration.getAccountNumber() !=null
                        ? bankRegistration.getAccountNumber()
                :bankDetail.getAccountNumber()
                );
        bankDetail.setBankUuid(bank.getBankUUID());
        bankDetail.setBankName(bank.getBankName());
      var userBank =  userTrackerPersistencePort.updateUserBankDetail(bankDetail);
        return new BankDetailResponse()
                .status("00")
                .description("successful")
                .data(new BankDetail()
                        .bankName(userBank.getBankName()).userBankId(UUID.fromString(userBank.getUserBankUuid()))
                        .bankId(UUID.fromString(userBank.getBankUuid())).partyId(UUID.fromString(userBank.getUserUuid())));
    }

    @Override
    public ResponseDto deleteBankInformation(UUID userBankId) {
        var bankDetail = userTrackerPersistencePort.getBankPerUser(userBankId.toString());
        if(bankDetail == null) {
            throwNotException("404", "Invalid bank detail supplied");
        }
       var data = new ResponseDtoData().partyId(UUID.fromString(bankDetail.getUserUuid())).message(String.format(
                "password updated for user"
        ));
        userTrackerPersistencePort.deleteUserBankDetail(bankDetail);
        return new ResponseDto().status("00")
                .description("successful")
                .data(data);
    }


    //validate resend
    @Override
    public ResponseDto validateToken(ProcessToken token) {
        ResponseDto responseDto = null;
        switch (token.getAction()) {
            case  VALIDATE:
                responseDto = processTokenValidation(token);
                break;
            case RESEND:
                responseDto = processTokenResend(token);
                break;
            default:
                throwNotException("404", "Validation action not specified");
        }
        return responseDto;
    }

    @Override
    public UsersListResponse listUsers(int page, int pageSize, String role, Date dateCreated) {
        pageSize = pageSize <= 0 ? 20 : pageSize;
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<UsersView> usersPage;
        if(role != null && dateCreated != null){
            usersPage = userTrackerPersistencePort.findUsersByDateAndRolePaginated(convertToLocalDateTime(dateCreated),role,pageable);
        } else if(role != null && dateCreated == null) {
            usersPage = userTrackerPersistencePort.findUsersByRolePaginated(role,pageable);
        } else if((dateCreated != null) && (role == null)) {
            usersPage = userTrackerPersistencePort.findUsersByDateCreatedPaginated(convertToLocalDateTime(dateCreated),pageable);
        }else{
            usersPage = userTrackerPersistencePort.findAllUsers(pageable);
        }
        PageInfo pageInfo = new PageInfo()
                .totalItems((int)usersPage.getTotalElements())
                .totalPages((int)usersPage.getTotalElements());
        List<AppUsers> appUsers = usersPage.getContent().stream()
                        .map(x -> new UserRegAuthDto().fromEntityToAppUserModel(x))
                                .toList();
        return new UsersListResponse()
                .data(new UsersListResponseData().users(appUsers).pageInfo(pageInfo))
                .status("00")
                .description("successful");
    }

    public static LocalDateTime convertToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private ResponseDto processTokenResend(ProcessToken token) {
        var activeTokens = userTrackerPersistencePort.getAllActiveTokenPerUser(token.getPartyId().toString());
        if(activeTokens == null) {
            throwNotException("404", "No previous token found");
        }
        var activeToken = activeTokens.getLast();
        if(!token.getPartyId().equals(activeToken.getPartyId())){
            if(activeToken == null) {
                throwNotException("404", "Invalid token");
            }
        }
        activeToken.setExpirationTime(LocalDateTime.now().plusMinutes(10));
        activeToken =  userTrackerPersistencePort.updateToken(activeToken);
        //todo send mail
        return new ResponseDto().status("00")
                .description("successful")
                .data(new ResponseDtoData().partyId(UUID.fromString(activeToken.getPartyId())).message(String.format(
                        "token updated and sent for %s, kindly proceed", activeToken.getEmail()
                )));
    }

    private  void throwNotException(String number, String No_previous_token_found) {
        List<Error> errors = new ArrayList<>();
        Error error = new Error();
        error.setCode(number);
        error.setMessage(No_previous_token_found);
        errors.add(error);
        throw new NotFoundException(errors);
    }

    private ResponseDto processTokenValidation(ProcessToken token) {
        var activeToken = userTrackerPersistencePort.getActiveToken(token);
        if(activeToken == null) {
            throwNotException("404", "Invalid or expired token");
        }
        //todo if vendor or customer or company, update isEmailVerified column
        activeToken.setUsed(true);
        activeToken =  userTrackerPersistencePort.updateToken(activeToken);
        return new ResponseDto().status("00")
                .description("successful")
                .data(new ResponseDtoData().partyId(UUID.fromString(activeToken.getPartyId())).message(String.format(
                        "token validated for %s, kindly proceed", activeToken.getEmail()
                )));
    }

    public  void generateToken(String partyId, String userRole, String email, String purpose) {
        String token;
        do {
            token = generateRandomToken();
        } while (!isUnique(token));
        TokenDto tokenDto = new TokenDto();
        tokenDto.setToken(token);
        tokenDto.setEmail(email);
        tokenDto.setPartyId(partyId);
        tokenDto.setUserRole(userRole);
        tokenDto.setPurpose(purpose);
        tokenDto.setExpirationTime(LocalDateTime.now().plusMinutes(10));
        userTrackerPersistencePort.saveToken(tokenDto);
    }
    private  String generateRandomToken() {
       Random random = new SecureRandom();
        StringBuilder tokenBuilder = new StringBuilder(TOKEN_LENGTH);
        for (int i = 0; i < TOKEN_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            tokenBuilder.append(CHARACTERS.charAt(randomIndex));
        }
        return tokenBuilder.toString();
    }

    private  boolean isUnique(String token) {
        var activeToken = userTrackerPersistencePort.getActiveToken(token);
         return  activeToken == null;
    }

    private String processUserPerType(Registration model) {
        String userUuid;
        switch (model.getRole()) {
            case VENDOR, ORGANIZATION:
                var vendor = userTrackerPersistencePort.saveVendor(model);
                userUuid = vendor.getUserUuid();
                break;
            default:
                var user = userTrackerPersistencePort.saveUser(model);
                userUuid = user.getUserUuid();
                break;
        }
        return userUuid;
    }

    private void checkIfuserExistByRoleAndEmailReg(String email, String role) {
      var response =  userTrackerPersistencePort.checkUserByEmailAndUserRole(email, role);
      if(response != null){
          List<Error> errors = new ArrayList<>();
          Error error = new Error();
          error.setCode("409");
          error.setMessage("Email already exist against role");
          errors.add(error);
          throw new ConflictException(errors);
      }
    }

    private void checkIfuserExistByRoleAndEmail(String email, String role) {
        var response =  userTrackerPersistencePort.checkUserByEmailAndUserRole(email, role);
        if(response == null){
            List<Error> errors = new ArrayList<>();
            Error error = new Error();
            error.setCode("409");
            error.setMessage("User not found");
            errors.add(error);
            throw new ConflictException(errors);
        }
    }

    private com.prokhure.erp.infrastructure.entity.users.Authentication getUserByRoleAndEmailReg(String email, String role) {
        return   userTrackerPersistencePort.checkUserByEmailAndUserRole(email, role);

    }
}
