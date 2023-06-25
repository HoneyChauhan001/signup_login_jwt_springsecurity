package com.example.loginsignupjwt.service.impl;

import com.example.loginsignupjwt.dto.requestDto.AuthenticationDTO;
import com.example.loginsignupjwt.dto.responseDto.AuthenticationResponseDTO;
import com.example.loginsignupjwt.exception.UserIsDisabledException;
import com.example.loginsignupjwt.exception.WrongCredintialsException;
import com.example.loginsignupjwt.service.AuthenticationService;
import com.example.loginsignupjwt.util.JwtUtil;
import io.jsonwebtoken.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public AuthenticationResponseDTO createJWTToken(AuthenticationDTO authenticationDTO) throws WrongCredintialsException, UserIsDisabledException, UsernameNotFoundException, IOException {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTO.getEmail(), authenticationDTO.getPassword()));
            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDTO.getEmail());
            final String jwt = jwtUtil.generateToken(userDetails.getUsername());
            return new AuthenticationResponseDTO(jwt);
        }
        catch (BadCredentialsException e){
            throw new WrongCredintialsException("Username or Password Incorrect");
        }
        catch (DisabledException e) {
            throw new UserIsDisabledException("User is Disabled");
        }
    }
}
