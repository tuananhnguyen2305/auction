package com.uet.api;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.Http;
import com.uet.dto.LoginDTO;
import com.uet.dto.UserDTO;
import com.uet.service.impl.UserService;

import javassist.expr.NewArray;

@RestController
public class LoginAPI {
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<?> signIn(@RequestBody LoginDTO loginDTO) {
		UserDTO userDTO = userService.findOneById(loginDTO.getUsername());
		if (userDTO == null) {
			return new ResponseEntity<>("Đăng nhập không thành công", org.springframework.http.HttpStatus.UNAUTHORIZED);
			
		}
		String password = userDTO.getPassword();
		if (!password.equals(loginDTO.getPassword())) {
			return new ResponseEntity<>("Đăng nhập không thành công", org.springframework.http.HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>("Đăng nhập thành công", org.springframework.http.HttpStatus.OK);
	}
	
	@PostMapping("/registration")
	public ResponseEntity<?> signUp(@RequestBody UserDTO userDTO) {
		String id = userDTO.getUsername();
		UserDTO oldDTO = userService.findOneById(id);
		if (oldDTO == null) {
			userService.save(userDTO);
			return new ResponseEntity<>("Đăng ký thành công", org.springframework.http.HttpStatus.OK);
		}
		return new ResponseEntity<>("Tài khoản đã tồn tại", org.springframework.http.HttpStatus.OK);
	}
}
