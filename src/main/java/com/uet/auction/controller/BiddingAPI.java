package com.uet.auction.controller;

import com.uet.auction.payload.ResponseData;
import com.uet.auction.serivce.IBiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bidding")
public class BiddingAPI {
    @Autowired
    IBiddingService biddingService;

    @PostMapping("/{auctionId}")
    public ResponseEntity<?> createBidding(@PathVariable int auctionId,
                                           @RequestParam int amount) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        ResponseData responseData = new ResponseData();
        responseData.setSuccess(biddingService.createBidding(amount, auctionId, username));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/{auctionId}")
    public ResponseEntity<?> getLatestBidding(@PathVariable int auctionId) {
        ResponseData responseData = new ResponseData();
        responseData.setData(biddingService.getLatestBidding(auctionId));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
