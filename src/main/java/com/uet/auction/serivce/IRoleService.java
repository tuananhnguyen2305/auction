package com.uet.auction.serivce;

import com.uet.auction.dto.RoleDTO;

public interface IRoleService {
    boolean addRole(RoleDTO role);
    RoleDTO getRoleById(int id);
}
