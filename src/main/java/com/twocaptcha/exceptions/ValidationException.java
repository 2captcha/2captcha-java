package com.twocaptcha.exceptions;

public class ValidationException extends Exception {

    public ValidationException(String errorMessage) {
        super(errorMessage);
    }

}
