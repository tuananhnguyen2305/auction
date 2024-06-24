package com.uet.auction.serivce.impl;

import com.uet.auction.converter.UserConverter;
import com.uet.auction.dto.request.SignUpRequest;
import com.uet.auction.entity.Role;
import com.uet.auction.entity.User;
import com.uet.auction.dto.UserDTO;
import com.uet.auction.entity.enums.RoleName;
import com.uet.auction.repository.IUserRepository;
import com.uet.auction.serivce.IRoleService;
import com.uet.auction.serivce.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public boolean signUp(SignUpRequest signUpRequest) {
        try {
            User user = userConverter.toEntity(signUpRequest);

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
    public boolean createEmployee(UserDTO userDTO) {
        try {
            User user = new User();
            user = userConverter.toEntity(userDTO);

            Role role = Role.builder()
                    .id(2)
                    .roleName(RoleName.EMPLOYEE)
                    .build();

            user.setRole(role);

            userRepository.save(user);
            return true;
        } catch (Exception e) {
            System.out.println("Error in saving employee: " + e.getMessage());
        }
        return false;
    }

    @Override
    public UserDTO getMyInfo() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername(username);

        return userConverter.toDTO(user.get());
    }


}
