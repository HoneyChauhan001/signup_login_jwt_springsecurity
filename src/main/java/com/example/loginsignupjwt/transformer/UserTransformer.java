package com.example.loginsignupjwt.transformer;

import com.example.loginsignupjwt.dto.requestDto.SignupDTO;
import com.example.loginsignupjwt.dto.responseDto.UserDTO;
import com.example.loginsignupjwt.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserTransformer {
    public static User signUpDtoToUser(SignupDTO signupDTO){
        return User.builder()
                .name(signupDTO.getName())
                .email(signupDTO.getEmail())
                .password(new BCryptPasswordEncoder().encode(signupDTO.getPassword()))
                .build();
    }

    public static UserDTO userToUserDto(User user){
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
