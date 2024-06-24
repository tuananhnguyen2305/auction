package com.uet.auction.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String contactNumber;
    private String address;
    private String identityNumber;
    private String email;
    private int balance;
    private RoleDTO role;
}
