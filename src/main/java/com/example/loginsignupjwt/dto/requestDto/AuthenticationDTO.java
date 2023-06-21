package com.example.loginsignupjwt.dto.requestDto;

import lombok.Data;

@Data
public class AuthenticationDTO {

    private String email;

    private String password;

}
