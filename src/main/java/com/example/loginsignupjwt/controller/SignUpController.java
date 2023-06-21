package com.example.loginsignupjwt.controller;

import com.example.loginsignupjwt.dto.requestDto.SignupDTO;
import com.example.loginsignupjwt.dto.responseDto.UserDTO;
import com.example.loginsignupjwt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signUpDto) {
        UserDTO createdUser = authService.createUser(signUpDto);
        if (createdUser == null){
            return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
