package com.prokhure.erp.domain.exception;

import com.prokhure.erp.service.model.Error;

import java.util.List;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final List<Error> error;

    public NotFoundException(List<Error> error) {
        this.error = error;
    }

    public List<Error> getError() {
        return error;
    }
}
