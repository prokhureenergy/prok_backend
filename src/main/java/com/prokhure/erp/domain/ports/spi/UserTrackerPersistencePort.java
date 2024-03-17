package com.prokhure.erp.domain.ports.spi;

import com.prokhure.erp.infrastructure.dto.AuthenticationDto;
import com.prokhure.erp.infrastructure.dto.TokenDto;
import com.prokhure.erp.infrastructure.entity.users.*;
import com.prokhure.erp.infrastructure.entity.views.UsersView;
import com.prokhure.erp.service.model.BankRegistration;
import com.prokhure.erp.service.model.ProcessToken;
import com.prokhure.erp.service.model.Registration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserTrackerPersistencePort {
    Authentication checkUserByEmailAndUserRole(String email, String userRole);
    BusinessUser saveVendor(Registration model);
    User saveUser (Registration model);
    Authentication saveAuthenticationDetails(AuthenticationDto vendor);
    Optional<Authentication> findByUserId(String userId);
    Optional<Authentication> findByEmail(String email);
    Authentication updateAuthentication(Authentication entity);
    Token getActiveToken(String token);
    Token getActiveToken(ProcessToken token);
    List<Token> getAllActiveTokenPerUser(String userId);
    Token saveToken(TokenDto tokenDto);
    Token updateToken(Token token);
    Bank getBank(String bankId);
    List<Bank> getBanks();
    List<UserBankDetail> getBanksPerUser(String userId);
    UserBankDetail getBankPerUser(String userBankId);
    UserBankDetail updateUserBankDetail(UserBankDetail bankDetail);
    BusinessUser getVendorByVendorId(String vendorId);

    User getUserByUserId(String userId);
    void deleteUserBankDetail(UserBankDetail bankDetail);

    UserBankDetail saveUserBankDetail(BankRegistration bank);

    Page<UsersView>  findUsersByRolePaginated(String userRole, Pageable pageable);
    Page<UsersView> findUsersByDateCreatedPaginated(LocalDateTime dateCreated, Pageable pageable);
    Page<UsersView> findUsersByDateAndRolePaginated(LocalDateTime dateCreated, String userRole, Pageable pageable);
    Page<UsersView> findAllUsers(Pageable pageable);

}
