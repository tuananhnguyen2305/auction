package com.uet.auction.converter;

import com.uet.auction.dto.RoleDTO;
import com.uet.auction.dto.UserDTO;
import com.uet.auction.dto.request.SignUpRequest;
import com.uet.auction.entity.Role;
import com.uet.auction.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired
    RoleConverter roleConverter;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFullname(user.getFullname());
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());
        userDTO.setAddress(user.getAddress());
        userDTO.setBalance(user.getBalance());
        userDTO.setRole(roleConverter.toDTO(user.getRole()));
        userDTO.setContactNumber(user.getContactNumber());
        userDTO.setIdentityNumber(user.getIdentityNumber());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }



    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setAddress(userDTO.getAddress());
        user.setBalance(userDTO.getBalance());
        user.setEmail(userDTO.getEmail());
        user.setFullname(userDTO.getFullname());
        user.setContactNumber(userDTO.getContactNumber());
        user.setIdentityNumber(userDTO.getIdentityNumber());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setUsername(userDTO.getUsername());
        return user;
    }

    public User toEntity(SignUpRequest signUpRequest) {
        User user = new User();
        user.setAddress(signUpRequest.getAddress());
        user.setEmail(signUpRequest.getEmail());
        user.setUsername(signUpRequest.getUsername());
        user.setContactNumber(signUpRequest.getContactNumber());
        user.setIdentityNumber(signUpRequest.getIdentityNumber());
        user.setFullname(signUpRequest.getFullname());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

        return user;
    }

}
