package com.uet.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uet.dto.UserDTO;
import com.uet.service.IUserService;

@RestController
public class UserAPI {
	@Autowired
	private IUserService userService;
	
	@DeleteMapping("/user/{id}")
	public UserDTO deleteOneById(@PathVariable String id) {
		if (userService.findOneById(id) == null) {
			return null;
		}
		return userService.deleleOneById(id);
	}
	
	@PutMapping("/user/{id}")
	public UserDTO updateOneById(@PathVariable String id, @RequestBody UserDTO userDTO) {
		if (userService.findOneById(id) == null) {
			return null;
		}
		return userService.updateOneById(id, userDTO);
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
