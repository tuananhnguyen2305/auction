package com.uet.auction.controller;

import com.uet.auction.payload.ResponseData;
import com.uet.auction.serivce.ITransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transport")
public class TransportAPI {
    @Autowired
    ITransportService transportService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransportById(@PathVariable int id) {
        ResponseData responseData = new ResponseData();
        responseData.setData(transportService.getTransportTypeById(id));
        responseData.setStatus(200);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
