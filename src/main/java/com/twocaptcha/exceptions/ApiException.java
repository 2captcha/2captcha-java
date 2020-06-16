package com.twocaptcha.exceptions;

public class ApiException extends Exception {

    public ApiException(String errorMessage) {
        super(errorMessage);
    }

}
