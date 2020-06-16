package com.twocaptcha.exceptions;

public class TimeoutException extends Exception {

    public TimeoutException(String errorMessage) {
        super(errorMessage);
    }

}
