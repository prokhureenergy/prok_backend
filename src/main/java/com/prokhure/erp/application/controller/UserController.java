package com.prokhure.erp.application.controller;

import com.prokhure.erp.domain.exception.NotFoundException;
import com.prokhure.erp.domain.ports.api.UserServicePort;
import com.prokhure.erp.domain.service.JwtUtilityService;
import com.prokhure.erp.service.api.UsersApi;
import com.prokhure.erp.service.model.*;
import com.prokhure.erp.service.model.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
public class UserController implements UsersApi {

    private final UserServicePort userServicePort;

    @Autowired
    private AuthenticationManager authenticationManager;

    public UserController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return UsersApi.super.getRequest();
    }

    @Override
    public ResponseEntity<ResponseDto> registerUser(Registration registration) {
        var response = userServicePort.processUserRegistration(registration);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> resetOrProcessToken(ProcessToken processToken) {
        var response = userServicePort.validateToken(processToken);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> resetPassword(AuthUserResetPasswordRequest authUserResetPasswordRequest) {
        var response = userServicePort.processPasswordReset(authUserResetPasswordRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> resetPasswordByEmail(ResetPasswordByEmailRequest resetPasswordByEmailRequest) {
        var response = userServicePort.processPasswordResetViaEmail(resetPasswordByEmailRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AuthenticationResponse> userLogin(Authentication authentication) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentication.getEmail(), authentication.getPassword()));
            var response = userServicePort.processAuthentication(authentication);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception exception) {
            List<Error> errors = new ArrayList<>();
            Error error = new Error();
            error.setCode("404");
            error.setMessage("incorrect credentials");
            errors.add(error);
            throw new NotFoundException(errors);
        }
    }

    @Override
    public ResponseEntity<UsersListResponse> listUsers(Integer page, Integer pageSize, String role, Date dateCreated) {
        var response = userServicePort.listUsers(page,pageSize,role,dateCreated);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
