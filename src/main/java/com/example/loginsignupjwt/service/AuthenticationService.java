package com.example.loginsignupjwt.service;

import com.example.loginsignupjwt.dto.requestDto.AuthenticationDTO;
import com.example.loginsignupjwt.dto.responseDto.AuthenticationResponseDTO;
import com.example.loginsignupjwt.exception.UserIsDisabledException;
import com.example.loginsignupjwt.exception.WrongCredintialsException;

public interface AuthenticationService {
    public AuthenticationResponseDTO createJWTToken(AuthenticationDTO authenticationDTO) throws WrongCredintialsException, UserIsDisabledException;
}
