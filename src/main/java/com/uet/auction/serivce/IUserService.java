package com.uet.auction.serivce;

import com.uet.auction.dto.request.SignUpRequest;
import com.uet.auction.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAllUsers();
    boolean signUp(SignUpRequest signUpRequest);
    boolean createEmployee(UserDTO userDTO);
    UserDTO getMyInfo();

}
