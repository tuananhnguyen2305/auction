package com.uet.auction.controller;

import com.uet.auction.payload.ResponseData;
import com.uet.auction.serivce.IAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auction")
@RestController
public class AuctionAPI {
    @Autowired
    IAuctionService auctionService;

    @PostMapping
    public ResponseEntity<?> createAuction(
            @RequestParam String beginningTime,
            @RequestParam String endingTime,
            @RequestParam int startingPrice,
            @RequestParam int licenseId) {
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(auctionService.createAuction(beginningTime, endingTime, startingPrice, licenseId));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailAuction(@PathVariable int id) {
        ResponseData responseData = new ResponseData();
        responseData.setData(auctionService.getDetailAuction(id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> approveAuction(@PathVariable int id) {
        ResponseData responseData = new ResponseData();
        responseData.setData(auctionService.approveAuction(id));
        responseData.setSuccess(true);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> denyAuction(@PathVariable int id) {
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(auctionService.denyAuction(id));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
