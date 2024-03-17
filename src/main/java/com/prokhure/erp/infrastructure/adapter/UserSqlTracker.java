package com.prokhure.erp.infrastructure.adapter;

import com.prokhure.erp.domain.ports.spi.UserTrackerPersistencePort;
import com.prokhure.erp.infrastructure.dto.AuthenticationDto;
import com.prokhure.erp.infrastructure.dto.TokenDto;
import com.prokhure.erp.infrastructure.entity.users.*;
import com.prokhure.erp.infrastructure.entity.views.UsersView;
import com.prokhure.erp.infrastructure.mapper.UserRegAuthDto;
import com.prokhure.erp.infrastructure.repository.users.*;
import com.prokhure.erp.infrastructure.repository.views.UsersViewRepository;
import com.prokhure.erp.service.model.BankRegistration;
import com.prokhure.erp.service.model.ProcessToken;
import com.prokhure.erp.service.model.Registration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class UserSqlTracker implements UserTrackerPersistencePort {
    private final AuthenticationRepository authenticationRepository;
    private final AddressRepository addressRepository;
    private final DocumentRepository documentRepository;
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BusinessUserRepository businessUserRepository;
    private final TokenRepository tokenRepository;
    private final BankRepository bankRepository;
    private final UserBankDetailRepository userBankDetailRepository;
    private final UsersViewRepository usersViewRepository;
    private final UserRegAuthDto dtoMapper;

    public UserSqlTracker(AuthenticationRepository authenticationRepository, RoleRepository roleRepository,
                          AddressRepository addressRepository, PermissionRepository permissionRepository,
                          UserRepository userRepository,
                          DocumentRepository documentRepository, BusinessUserRepository businessUserRepository,
                          BankRepository bankRepository, UserBankDetailRepository userBankDetailRepository,
                          TokenRepository tokenRepository,UsersViewRepository UsersViewRepository,
                          UserRegAuthDto dtoMapper) {
        this.authenticationRepository = authenticationRepository;
        this.addressRepository = addressRepository;
        this.documentRepository = documentRepository;
        this.businessUserRepository = businessUserRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.bankRepository = bankRepository;
        this.userBankDetailRepository = userBankDetailRepository;
        this.tokenRepository = tokenRepository;
        this.usersViewRepository = UsersViewRepository;
        this.dtoMapper = dtoMapper;
    }
    @Override
    public Authentication checkUserByEmailAndUserRole(String email, String userRole) {
        var user = authenticationRepository.findAuthenticationByEmailAndCustomerType(email, userRole);
        return user.orElse(null);
    }

    @Override
    public BusinessUser saveVendor(Registration model) {
        return businessUserRepository.save(dtoMapper.fromModelToVendorEntity(model));
    }

    @Override
    public User saveUser(Registration model) {
        return userRepository.save(dtoMapper.fromModelToUserEntity(model));
    }

    @Override
    public Authentication saveAuthenticationDetails(AuthenticationDto model) {
        return authenticationRepository.save(dtoMapper.fromModelToAutenticationEntity(model));
    }

    @Override
    public BusinessUser getVendorByVendorId(String vendorId){
        return businessUserRepository.findBusinessUserByUserId(vendorId).orElse(null);
    }

    @Override
    public User getUserByUserId(String userId) {
       return userRepository.findUserByUserId(userId).orElse(null);
    }

    @Override
    public Optional<Authentication> findByUserId(String userId) {
        return authenticationRepository.findAuthenticationByUserId(userId);

    }

    @Override
    public Optional<Authentication> findByEmail(String email) {
        return authenticationRepository.findAuthenticationByEmail(email);

    }

    @Override
    public Authentication updateAuthentication(Authentication entity) {
       return authenticationRepository.save(entity);
    }

    @Override
    public Token getActiveToken(String token) {
        return tokenRepository.findTokenActive(token, LocalDateTime.now());
    }

    @Override
    public Token getActiveToken(ProcessToken token) {
        return tokenRepository.findTokenCurrentActive(token.getToken(),token.getPartyId().toString(),LocalDateTime.now());
    }

    @Override
    public List<Token> getAllActiveTokenPerUser(String userId) {
        return tokenRepository.findTokenByPartyIdAndActive(userId);
    }

    @Override
    public Token saveToken(TokenDto tokenDto) {
        return tokenRepository.save(dtoMapper.fromModelToTokenEntity(tokenDto));
    }

    @Override
    public Token updateToken(Token token) {
        return tokenRepository.save(token);
    }

    @Override
    public Bank getBank(String bankId) {
        return bankRepository.findBankByBankUuid(bankId).orElse(null);
    }

    @Override
    public List<Bank> getBanks() {
        return bankRepository.findAll();
    }

    @Override
    public List<UserBankDetail> getBanksPerUser(String userId) {
       return  userBankDetailRepository.getAllBankByUserId(userId).orElse(null);
    }

    @Override
    public UserBankDetail getBankPerUser(String userBankId) {
        return  userBankDetailRepository.getBankByUserBankId(userBankId).orElse(null);
    }

    @Override
    public UserBankDetail updateUserBankDetail(UserBankDetail bankDetail) {
       return userBankDetailRepository.save(bankDetail);
    }

    @Override
    public void deleteUserBankDetail(UserBankDetail bankDetail) {
        userBankDetailRepository.delete(bankDetail);
    }

    @Override
    public UserBankDetail saveUserBankDetail(BankRegistration bank) {
        return userBankDetailRepository.save(dtoMapper.fromModelToUserBankEntity(bank));
    }

    @Override
    public Page<UsersView> findUsersByRolePaginated(String userRole, Pageable pageable) {
        return usersViewRepository.findByUserRole(userRole,pageable);
    }

    @Override
    public Page<UsersView> findUsersByDateCreatedPaginated(LocalDateTime dateCreated, Pageable pageable) {
        return usersViewRepository.findByDateCreated(dateCreated,pageable);
    }

    @Override
    public Page<UsersView> findUsersByDateAndRolePaginated(LocalDateTime dateCreated, String userRole, Pageable pageable) {
        return usersViewRepository.findByDateCreatedAndUserRole(dateCreated,userRole,pageable);
    }

    @Override
    public Page<UsersView> findAllUsers(Pageable pageable) {
        return usersViewRepository.findAll(pageable);
    }
}
