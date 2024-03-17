package com.prokhure.erp.infrastructure.exception;

import com.prokhure.erp.service.model.Error;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConnectionException extends Exception implements
        Serializable {

    private static final long serialVersionUID = 112641863256870661L;
    private final Error error;
    public ConnectionException(){
        super("Error connecting to downstream, please try again!");
        error = new Error("4041", "Transaction Review Request Not Found");
    }

    public List<Error> getErrors() {
        List<Error> errors = new ArrayList<>();
        errors.add(error);
        return errors;
    }
}
