package com.twocaptcha.v2;

public class TimeoutException extends Exception {

    public TimeoutException(String errorMessage) {
        super(errorMessage);
    }

}
