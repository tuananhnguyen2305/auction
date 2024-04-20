package com.uet.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> deleteOneById(@PathVariable String id) {
		try {
			return new ResponseEntity<>(userService.deleleOneById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Xóa người dùng không thành công", HttpStatus.BAD_REQUEST); 
		}
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateOneById(@PathVariable String id, @RequestBody UserDTO userDTO) {
		try {
			return new ResponseEntity<>(userService.updateOneById(id, userDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Cập nhật người dùng không thành công", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/user/{username}")
	public ResponseEntity<?> findOneById(@PathVariable String username) {
		try {
			return new ResponseEntity<>(userService.findOneById(username), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Không tồn tại", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> findAll() {
		try {
			return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Không tồn tại", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> createOne(@RequestBody UserDTO userDTO) {
		try {
			return new ResponseEntity<>(userService.save(userDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Tạo người dùng không thành công", HttpStatus.BAD_REQUEST);
		}
	}
	
}
