package com.example.loginsignupjwt.service;

import com.example.loginsignupjwt.dto.requestDto.SignupDTO;
import com.example.loginsignupjwt.dto.responseDto.UserDTO;
import com.example.loginsignupjwt.exception.UserAlreadyPresentException;

public interface AuthService {
    UserDTO createUser(SignupDTO signUpDto) throws UserAlreadyPresentException;
}
