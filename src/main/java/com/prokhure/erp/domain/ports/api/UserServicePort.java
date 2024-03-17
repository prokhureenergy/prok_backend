package com.prokhure.erp.domain.ports.api;

import com.prokhure.erp.infrastructure.dto.TokenDto;
import com.prokhure.erp.service.model.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public interface UserServicePort {
    ResponseDto processUserRegistration(Registration model);
    AuthenticationResponse processAuthentication(Authentication model);
    ResponseDto processPasswordReset(AuthUserResetPasswordRequest model);
    ResponseDto processPasswordResetViaEmail(ResetPasswordByEmailRequest model);
    //ResponseDto processVerificationToken(ProcessToken model);
    BankDetailResponse addBankDetails(BankRegistration model);
    BankDetails getUserBankDetail(String userPartyId);
    //update user bank detail
    BankDetails getAllBanks();
    BankDetailResponse updateBank(BankRegistration bankRegistration);
    ResponseDto deleteBankInformation(UUID userBankId);
    ResponseDto validateToken(ProcessToken token);
    UsersListResponse listUsers(int page, int pageSize, String role, Date dateCreated);
    //get all roles with permissions
    //add permission to role
    //add permission to user
}
