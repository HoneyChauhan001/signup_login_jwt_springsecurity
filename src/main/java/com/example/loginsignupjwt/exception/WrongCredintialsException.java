package com.example.loginsignupjwt.exception;

public class WrongCredintialsException extends Exception {
    public WrongCredintialsException(String usernameOrPasswordIncorrect) {
        super(usernameOrPasswordIncorrect);
    }
}
