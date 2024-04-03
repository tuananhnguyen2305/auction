package com.uet.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uet.dto.LoginDTO;
import com.uet.dto.UserDTO;
import com.uet.service.impl.UserService;

@RestController
public class LoginAPI {
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDTO loginDTO) {
		UserDTO userDTO = userService.findOneById(loginDTO.getUsername());
		if (userDTO == null) {
			return "Tài khoản không tồn tại";
		}
		String password = userDTO.getPassword();
		if (!password.equals(loginDTO.getPassword())) {
			return "Sai mật khẩu";
		}
		return "Đăng nhập thành công";
	}
	
	@PostMapping("/registration")
	public String login(@RequestBody UserDTO userDTO) {
		String id = userDTO.getUsername();
		UserDTO oldDTO = userService.findOneById(id);
		if (oldDTO != null) {
			userService.save(userDTO);
			return "Đăng ký thành công";
		}
		return "Tài khoản đã tồn tại";
	}
}
