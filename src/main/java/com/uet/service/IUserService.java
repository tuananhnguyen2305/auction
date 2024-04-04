package com.uet.service;

import java.util.List;

import com.uet.dto.UserDTO;

public interface IUserService {
	UserDTO save(UserDTO userDTO);
	UserDTO findOneById(String id);
	UserDTO deleleOneById(String id);
	UserDTO updateOneById(String id, UserDTO userDTO);
	List<UserDTO> findAll();
}
