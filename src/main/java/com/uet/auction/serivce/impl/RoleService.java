package com.uet.auction.serivce.impl;

import com.uet.auction.converter.RoleConverter;
import com.uet.auction.dto.RoleDTO;
import com.uet.auction.entity.Role;
import com.uet.auction.repository.IRoleRepository;
import com.uet.auction.serivce.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    RoleConverter roleConverter;

    @Override
    public boolean addRole(RoleDTO roleDTO) {
        try {
            Role role = roleConverter.toEntity(roleDTO);
            roleRepository.save(role);
            return true;
        } catch (Exception e) {
            System.out.println("error in adding role: " + e.getMessage());
        }
        return false;
    }

    @Override
    public RoleDTO getRoleById(int id) {
        Optional<Role> role = roleRepository.findById(id);
        return roleConverter.toDTO(role);
    }
}
