package com.uet.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uet.dto.LoginDTO;
import com.uet.dto.UserDTO;
import com.uet.entity.User;
import com.uet.service.IUserService;

@RestController
public class UserAPI {
	@Autowired
	private IUserService userService;
	
	@PostMapping("/user")
	public UserDTO createOne(@RequestBody UserDTO userDTO) {
		return userService.save(userDTO);
	}
	
	@GetMapping("/user/{username}")
	public UserDTO findOneById(@PathVariable String username) {
		return userService.findOneById(username);
	}
	
	@GetMapping("/user")
	public List<UserDTO> findAll() {
		return userService.findAll();
	}
	
}
