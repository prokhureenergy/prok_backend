package com.prokhure.erp.application.controller;

import com.prokhure.erp.domain.ports.api.UserServicePort;
import com.prokhure.erp.service.api.BankApi;
import com.prokhure.erp.service.model.BankDetailResponse;
import com.prokhure.erp.service.model.BankDetails;
import com.prokhure.erp.service.model.BankRegistration;
import com.prokhure.erp.service.model.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class BankController implements BankApi {

    private final UserServicePort userServicePort;

    public BankController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }
    @Override
    public ResponseEntity<BankDetailResponse> addBank(BankRegistration bankRegistration) {
        var response =  userServicePort.addBankDetails(bankRegistration);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> deleteBankInformation(UUID userBankId) {
        var response =  userServicePort.deleteBankInformation(userBankId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BankDetails> getBanks() {
        var response =  userServicePort.getAllBanks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BankDetails> getBanksPerUser(UUID userBankId) {
        var response =  userServicePort.getUserBankDetail(userBankId.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BankDetailResponse> updateBank(BankRegistration bankRegistration) {
        var response =  userServicePort.updateBank(bankRegistration);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
