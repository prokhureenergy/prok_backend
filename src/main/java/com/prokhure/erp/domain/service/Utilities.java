package com.prokhure.erp.domain.service;

import com.prokhure.erp.domain.exception.NotFoundException;
import com.prokhure.erp.service.model.Error;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utilities {
    public static   void throwNotException(String number, String No_previous_token_found) {
        List<Error> errors = new ArrayList<>();
        Error error = new Error();
        error.setCode(number);
        error.setMessage(No_previous_token_found);
        errors.add(error);
        throw new NotFoundException(errors);
    }

    public static LocalDateTime convertToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
