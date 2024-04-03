package com.uet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uet.converter.UserConverter;
import com.uet.dto.UserDTO;
import com.uet.entity.User;
import com.uet.repository.UserRepo;
import com.uet.service.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserConverter userConverter;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDTO save(UserDTO userDTO) {
		User user = userConverter.toEntity(userDTO);
		userRepo.save(user);
		return userConverter.toDTO(user);
	}

	@Override
	public UserDTO findOneById(String id) {
		User user = userRepo.findOne(id);
		return userConverter.toDTO(user);
	}

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for (User user : userRepo.findAll()) {
			userDTOs.add(userConverter.toDTO(user));
		}
		return userDTOs;
	}

}
