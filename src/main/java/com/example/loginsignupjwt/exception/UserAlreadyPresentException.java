package com.example.loginsignupjwt.exception;

import com.example.loginsignupjwt.dto.responseDto.UserDTO;

public class UserAlreadyPresentException extends Exception {
    public UserAlreadyPresentException(String s) {
        super(s);
    }
}
