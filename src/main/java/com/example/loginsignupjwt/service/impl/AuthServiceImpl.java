package com.example.loginsignupjwt.service.impl;

import com.example.loginsignupjwt.dto.requestDto.SignupDTO;
import com.example.loginsignupjwt.dto.responseDto.UserDTO;
import com.example.loginsignupjwt.model.User;
import com.example.loginsignupjwt.repository.UserRepository;
import com.example.loginsignupjwt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDTO createUser(SignupDTO signUpDto) {
        User user = new User();
        user.setName(signUpDto.getName());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpDto.getPassword()));
        User createdUser = userRepository.save(user);
        UserDTO userDto = new UserDTO();
        userDto.setId(createdUser.getId());
        userDto.setEmail(createdUser.getEmail());
        userDto.setName(createdUser.getName());
        return userDto;
    }
}
