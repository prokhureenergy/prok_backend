package com.prokhure.erp.infrastructure.mapper;

import com.prokhure.erp.infrastructure.dto.AuthenticationDto;
import com.prokhure.erp.infrastructure.dto.TokenDto;
import com.prokhure.erp.infrastructure.entity.users.*;
import com.prokhure.erp.service.model.BankRegistration;
import com.prokhure.erp.service.model.Registration;

public class UserRegAuthDto {
    public Vendor fromModelToVendorEntity(Registration model) {
        Vendor vendor = new Vendor();
        vendor.setVendorName(model.getBusinessName());
        vendor.setVendorRegistrationNumber(model.getBusinessRegistrationNumber());
        vendor.setPhoneCountryCode(model.getPhoneCountryCode());
        vendor.setPhoneNumber(model.getPhoneNumber());
        vendor.setEmail(model.getEmail());
        vendor.setVendorType(model.getRoleType());
        vendor.setFirstName(model.getFirstName());
        vendor.setLastName(model.getLastName());
        return vendor;
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
}
