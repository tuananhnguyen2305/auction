package com.uet.auction.controller;

import com.uet.auction.dto.request.SignUpRequest;
import com.uet.auction.dto.response.AuthenticationResponse;
import com.uet.auction.payload.ResponseData;
import com.uet.auction.serivce.IAuthenticationService;
import com.uet.auction.serivce.IUserService;
import com.uet.auction.utils.JWTUtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationAPI {
    @Autowired
    IAuthenticationService authenticationService;

    @Autowired
    IUserService userService;

    @Autowired
    JWTUtilsHelper jwtUtilsHelper;
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) {
        ResponseData responseData = new ResponseData();
        responseData.setData(userService.signUp(signUpRequest));
        responseData.setStatus(200);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestParam String username,
                                    @RequestParam String password) {
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(username, password);

        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }
}
