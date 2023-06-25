package com.example.loginsignupjwt.exception;

public class UserIsDisabledException extends Exception {
    public UserIsDisabledException(String userIsDisabled) {
        super(userIsDisabled);
    }
}
