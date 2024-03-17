package com.prokhure.erp.application.exception;

import com.prokhure.erp.domain.exception.ConflictException;
import com.prokhure.erp.domain.exception.NotFoundException;
import com.prokhure.erp.domain.exception.ValidationException;
import com.prokhure.erp.infrastructure.exception.ConnectionException;
import com.prokhure.erp.service.model.Error;
import com.prokhure.erp.service.model.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Errors handleValidationException(ValidationException ex, WebRequest request) {

        Errors errorMessage = new Errors();
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTimestamp(new Date());
        errorMessage.setMessage("Request data validation fail");
        errorMessage.setDescription(request.getDescription(false));
        errorMessage.setErrorDetails(ex.getError());
        return errorMessage;
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Errors handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest request) {

        Errors errorMessage = new Errors();
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTimestamp(new Date());
        errorMessage.setMessage("User detail error");
        errorMessage.setDescription(request.getDescription(false));
        List<Error> errors = new ArrayList<>();
        errors.add(new Error("404", "User details not found"));
        errorMessage.setErrorDetails(errors);
        return errorMessage;
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public Errors handleConflictException(ConflictException ex, WebRequest request) {

        Errors errorMessage = new Errors();
        errorMessage.setStatus(HttpStatus.CONFLICT.value());
        errorMessage.setTimestamp(new Date());
        errorMessage.setMessage("Request data validation fail");
        errorMessage.setDescription(request.getDescription(false));
        errorMessage.setErrorDetails(ex.getError());
        return errorMessage;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Errors handleNotFpundException(NotFoundException ex, WebRequest request) {
        Errors errorMessage = new Errors();
        errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
        errorMessage.setTimestamp(new Date());
        errorMessage.setMessage("Request data validation fail");
        errorMessage.setDescription(request.getDescription(false));
        errorMessage.setErrorDetails(ex.getError());
        return errorMessage;
    }

    @ExceptionHandler(ConnectionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Errors handleConnectionException(ConnectionException ex, WebRequest request) {

        Errors errorMessage = new Errors();
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTimestamp(new Date());
        errorMessage.setMessage("Request data validation fail");
        errorMessage.setDescription(request.getDescription(false));
        errorMessage.setErrorDetails(ex.getErrors());
        return errorMessage;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Errors handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {

        BindingResult result = ex.getBindingResult();
        Errors errorMessage = new Errors();
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTimestamp(new Date());
        errorMessage.setMessage("Request data validation fail");
        errorMessage.setDescription(request.getDescription(false));
        List<Error> errorDetails = result.getFieldErrors().stream()
                .map(x -> new Error(x.getField(), x.getDefaultMessage()))
                .toList();
        errorMessage.setErrorDetails(errorDetails);
        return errorMessage;
    }
}
