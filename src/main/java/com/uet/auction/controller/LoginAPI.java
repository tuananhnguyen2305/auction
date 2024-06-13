package com.uet.auction.controller;

import com.uet.auction.dto.SignUpDTO;
import com.uet.auction.dto.UserDTO;
import com.uet.auction.payload.ResponseData;
import com.uet.auction.serivce.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginAPI {
    @Autowired
    IUserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpDTO signUpDTO) {
        ResponseData responseData = new ResponseData();
        responseData.setData(userService.signUp(signUpDTO));
        responseData.setStatus(200);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestParam String username,
                                    @RequestParam String password) {
        ResponseData responseData = new ResponseData();
        if (userService.checkLogin(username, password)) {
            responseData.setStatus(200);
            responseData.setSuccess(true);
        } else {
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
