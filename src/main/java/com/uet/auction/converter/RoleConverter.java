package com.uet.auction.converter;

import com.uet.auction.dto.RoleDTO;
import com.uet.auction.entity.Role;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleConverter {
    public RoleDTO toDTO(Optional<Role> role) {
        Role entity = role.get();
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(entity.getId());
        return roleDTO;
    }

    public RoleDTO toDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setRoleName(role.getRoleName().name());
        return roleDTO;
    }

    public Role toEntity(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        return role;
    }
}
