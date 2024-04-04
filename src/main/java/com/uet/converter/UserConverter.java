package com.uet.converter;

import org.springframework.stereotype.Component;

import com.uet.dto.UserDTO;
import com.uet.entity.User;

@Component
public class UserConverter {
	public User toEntity(UserDTO userDTO) {
		if (userDTO == null) {
			return null;
		}
		User user = new User();
		if (userDTO.getUsername() != null) {
			user.setUsername(userDTO.getUsername());
		}
		user.setPassword(userDTO.getPassword());
		user.setAccountType(userDTO.getAccountType());
		user.setFullname(userDTO.getFullname());
		user.setContactNumber(userDTO.getContactNumber());
		user.setEmail(userDTO.getEmail());
		user.setIdentityNumber(userDTO.getIdentityNumber());
		user.setAddress(userDTO.getAddress());
		return user;
	}
	
	public UserDTO toDTO(User user) {
		if (user == null) {
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setAccountType(user.getAccountType());
		userDTO.setFullname(user.getFullname());
		userDTO.setContactNumber(user.getContactNumber());
		userDTO.setEmail(user.getEmail());
		userDTO.setIdentityNumber(user.getIdentityNumber());
		userDTO.setAddress(user.getAddress());
		return userDTO;
	}
}
