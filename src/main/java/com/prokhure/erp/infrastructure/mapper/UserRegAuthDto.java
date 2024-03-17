package com.prokhure.erp.infrastructure.mapper;

import com.prokhure.erp.infrastructure.dto.AuthenticationDto;
import com.prokhure.erp.infrastructure.dto.TokenDto;
import com.prokhure.erp.infrastructure.entity.users.*;
import com.prokhure.erp.infrastructure.entity.views.UsersView;
import com.prokhure.erp.service.model.AppUsers;
import com.prokhure.erp.service.model.BankRegistration;
import com.prokhure.erp.service.model.Registration;

public class UserRegAuthDto {
    public BusinessUser fromModelToVendorEntity(Registration model) {
        BusinessUser businessUser = new BusinessUser();
        businessUser.setBusinessName(model.getBusinessName());
        businessUser.setBusinessRegistrationNumber(model.getBusinessRegistrationNumber());
        businessUser.setPhoneCountryCode(model.getPhoneCountryCode());
        businessUser.setPhoneNumber(model.getPhoneNumber());
        businessUser.setEmail(model.getEmail());
        businessUser.setBusinessType(model.getRoleType());
        businessUser.setFirstName(model.getFirstName());
        businessUser.setLastName(model.getLastName());
        businessUser.setUserRole(model.getRole().name());
        return businessUser;
    }

    public User fromModelToUserEntity(Registration model) {
        User user = new User();
        user.setFirstName(model.getFirstName());
        user.setLastName(model.getLastName());
        user.setEmail(model.getEmail());
        user.setPhoneCountryCode(model.getPhoneCountryCode());
        user.setPhoneNumber(model.getPhoneNumber());
        user.setUserType(model.getRole().name());
        return user;
    }

    public Authentication fromModelToAutenticationEntity(AuthenticationDto authenticationDto) {
        return new Authentication(authenticationDto.getUserUuid(),
                authenticationDto.getEmail(),authenticationDto.getPassword(),
                authenticationDto.getPasswordHash(),authenticationDto.getUserRole());
    }

    public Token fromModelToTokenEntity(TokenDto model) {
        Token token = new Token();
        token.setToken(model.getToken());
        token.setEmail(model.getEmail());
        token.setPurpose(model.getPurpose());
        token.setUserRole(model.getUserRole());
        token.setExpirationTime(model.getExpirationTime());
        token.setPartyId(model.getPartyId());
        token.setUsed(false);
        return token;
    }

    public UserBankDetail fromModelToUserBankEntity(BankRegistration bank) {
        UserBankDetail userBankDetail = new UserBankDetail();
        userBankDetail.setUserUuid(bank.getPartyId().toString());
        userBankDetail.setBankName(bank.getBankName());
        userBankDetail.setBankUuid(bank.getBankId().toString());
        userBankDetail.setAccountNumber(bank.getAccountNumber());
        return  userBankDetail;
    }
    public AppUsers fromEntityToAppUserModel(UsersView entity) {
        AppUsers appUsers = new AppUsers()
                .name(entity.getName())
                .businessCategory(entity.getBusinessCategory())
                .businessRegNumber(entity.getBusinessRegNumber())
                .businessType(entity.getBusinessType())
                .email(entity.getEmail())
                .isBusinessVerified(entity.getBusinessVerified())
                .isEmailVerified(entity.getEmailVerified())
                .businessDesc(entity.getBusinessDesc())
                .phoneCountryCode(entity.getPhoneCountryCode())
                .phoneNumber(entity.getPhoneNumber())
                .userRole(entity.getUserRole())
                .userUuid(entity.getUserUuid())
                .status(entity.getStatus())
                .verifiedById(entity.getVerifiedById());
            return appUsers;
                //.dateCreated(entity.getDateCreated())

        /***

         *     private String verifiedById;
         * private LocalDateTime dateCreated;
         *
         *
         */
    }
}
