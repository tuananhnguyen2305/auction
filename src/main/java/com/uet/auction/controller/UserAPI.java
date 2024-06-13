package com.uet.auction.controller;

import com.uet.auction.payload.ResponseData;
import com.uet.auction.serivce.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
