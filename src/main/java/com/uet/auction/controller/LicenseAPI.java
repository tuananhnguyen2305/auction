package com.uet.auction.controller;

import com.uet.auction.payload.ResponseData;
import com.uet.auction.serivce.ILicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/license")
public class LicenseAPI {
    @Autowired
    ILicenseService licenseService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getLicenseById(@PathVariable String id) {
        ResponseData responseData = new ResponseData();
        try {
            responseData.setData(licenseService.getLicenceById(id));
            responseData.setSuccess(true);
        } catch (Exception e) {
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createLicense(
            @RequestParam String licenseId,
            @RequestParam int provinceId,
            @RequestParam int transportId,
            @RequestParam int userId) {
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(licenseService.createLicense(licenseId, provinceId, transportId, userId));

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
