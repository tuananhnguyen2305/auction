package com.uet.auction.controller;

import com.uet.auction.dto.UserDTO;
import com.uet.auction.payload.ResponseData;
import com.uet.auction.serivce.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserAPI {
    @Autowired
    IUserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        ResponseData responseData = new ResponseData();
        responseData.setData(userService.getAllUsers());
        responseData.setStatus(200);
        responseData.setSuccess(true);

        var authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        System.out.println(authentication.getAuthorities());
        authentication.getAuthorities().forEach(t -> System.out.println(t.getAuthority()));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/myInfo")
    public ResponseEntity<?> getMyInfo() {
        ResponseData responseData = new ResponseData();

        responseData.setData(userService.getMyInfo());
        responseData.setStatus(200);
        responseData.setSuccess(true);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(@RequestBody UserDTO userDTO) {
        ResponseData responseData = new ResponseData();
        responseData.setData(userService.createEmployee(userDTO));
        responseData.setSuccess(true);
        responseData.setStatus(200);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
