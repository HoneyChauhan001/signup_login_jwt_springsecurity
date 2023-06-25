package com.example.loginsignupjwt.controller;

import com.example.loginsignupjwt.dto.requestDto.AuthenticationDTO;
import com.example.loginsignupjwt.dto.responseDto.AuthenticationResponseDTO;
import com.example.loginsignupjwt.exception.UserIsDisabledException;
import com.example.loginsignupjwt.exception.WrongCredintialsException;
import com.example.loginsignupjwt.service.AuthenticationService;
import com.example.loginsignupjwt.service.impl.UserDetailsServiceImpl;
import com.example.loginsignupjwt.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/authenticate")
    public ResponseEntity createAuthenticationToken(@RequestBody AuthenticationDTO authenticationDTO, HttpServletResponse response) throws IOException {
        try {
            AuthenticationResponseDTO authenticationResponseDTO = authenticationService.createJWTToken(authenticationDTO);
            return new ResponseEntity<>(authenticationResponseDTO, HttpStatus.OK);
        } catch (WrongCredintialsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (UserIsDisabledException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (UsernameNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
