package com.uet.auction.controller;

import com.uet.auction.entity.UserAuction;
import com.uet.auction.entity.keys.IdUserAuction;
import com.uet.auction.payload.ResponseData;
import com.uet.auction.serivce.IUserAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-auction")
public class UserAuctionAPI {
    @Autowired
    IUserAuctionService userAuctionService;

    @PostMapping("/{id}")
    public ResponseEntity<?> attendToAuction(@PathVariable int id) {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        ResponseData responseData = new ResponseData();
        responseData.setSuccess(userAuctionService.attendToAuction(userId, id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
