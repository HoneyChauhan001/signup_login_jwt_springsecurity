package com.example.loginsignupjwt.service.impl;

import com.example.loginsignupjwt.dto.requestDto.SignupDTO;
import com.example.loginsignupjwt.dto.responseDto.UserDTO;
import com.example.loginsignupjwt.exception.UserAlreadyPresentException;
import com.example.loginsignupjwt.model.User;
import com.example.loginsignupjwt.repository.UserRepository;
import com.example.loginsignupjwt.service.AuthService;
import com.example.loginsignupjwt.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDTO createUser(SignupDTO signupDTO) throws UserAlreadyPresentException {
        //check if user already present
        Optional<User> userOpt = userRepository.findByEmail(signupDTO.getEmail());
        if(userOpt.isPresent()){
            throw new UserAlreadyPresentException("User already present with this Email Id");
        }
        User user = UserTransformer.signUpDtoToUser(signupDTO);
        User createdUser = userRepository.save(user);
        UserDTO userDto = UserTransformer.userToUserDto(createdUser);
        return userDto;
//        User user = new User();
//        user.setName(signupDTO.getName());
//        user.setEmail(signupDTO.getEmail());
//        user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
//        User createdUser = userRepository.save(user);
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(createdUser.getId());
//        userDTO.setEmail(createdUser.getEmail());
//        userDTO.setName(createdUser.getName());
//        return userDTO;
    }

}
