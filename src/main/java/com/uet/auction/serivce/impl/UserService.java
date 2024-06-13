package com.uet.auction.serivce.impl;

import com.uet.auction.converter.UserConverter;
import com.uet.auction.dto.RoleDTO;
import com.uet.auction.dto.SignUpDTO;
import com.uet.auction.entity.Role;
import com.uet.auction.entity.User;
import com.uet.auction.dto.UserDTO;
import com.uet.auction.entity.enums.RoleName;
import com.uet.auction.repository.IUserRepository;
import com.uet.auction.serivce.IRoleService;
import com.uet.auction.serivce.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    @Autowired
    IRoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> usersList = userRepository.findAll();
        List<UserDTO> usersDTOList = new ArrayList<>();
        for (User user:
                usersList) {
            UserDTO userDTO = userConverter.toDTO(user);
            usersDTOList.add(userDTO);
        }
        return usersDTOList;
    }

    @Override
    public boolean signUp(SignUpDTO signUpDTO) {
        try {
            User user = new User();
            user.setUsername(signUpDTO.getUsername());
            user.setPassword(signUpDTO.getPassword());
            user.setFullname(signUpDTO.getFullName());
            user.setEmail(signUpDTO.getEmail());
            user.setAddress(signUpDTO.getAddress());
            user.setIdentityNumber(signUpDTO.getIdentityNumber());
            user.setContactNumber(signUpDTO.getContactNumber());

            Role role = new Role();
            role.setId(3);
            role.setRoleName(RoleName.USER);

            user.setRole(role);
            user.setBalance(0);
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            System.out.println("Error in saving user: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        User user = userRepository.findByUsername(username);
        return passwordEncoder.matches(password, user.getPassword());
    }


}
