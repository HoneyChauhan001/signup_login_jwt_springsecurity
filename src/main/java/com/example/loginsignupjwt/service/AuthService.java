package com.example.loginsignupjwt.service;

import com.example.loginsignupjwt.dto.requestDto.SignupDTO;
import com.example.loginsignupjwt.dto.responseDto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupDTO signUpDto);
}
