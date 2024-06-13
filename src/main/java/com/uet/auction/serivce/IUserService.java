package com.uet.auction.serivce;

import com.uet.auction.dto.SignUpDTO;
import com.uet.auction.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAllUsers();
    boolean signUp(SignUpDTO signUpDTO);

    boolean checkLogin(String username, String password);
}
