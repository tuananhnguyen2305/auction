package com.uet.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uet.dto.LicensePlateDTO;
import com.uet.service.ILicensePlateService;

@RestController
public class LicensePlateAPI {
	@Autowired
	private ILicensePlateService licensePlateService;
	
	@PostMapping("/license_plate")
	public ResponseEntity<?> createOne(@RequestBody LicensePlateDTO licensePlateDTO) {
		try {
			return new ResponseEntity<>(licensePlateService.save(licensePlateDTO), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Tạo biển số xe không thành công", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/license_plate/{id}") 
	public ResponseEntity<?> findOneById(@PathVariable String id) {
		try {
			return new ResponseEntity<>(licensePlateService.findOneById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Không tồn tại", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/license_plate")
	public ResponseEntity<?> findAll() {
		try {
			return new ResponseEntity<>(licensePlateService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Không tồn tại", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/license_plate/{id}")
	public ResponseEntity<?> deleteOneById(@PathVariable String id) {
		try {
			return new ResponseEntity<>(licensePlateService.deleteOneById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Xóa biển số xe không thành công", HttpStatus.BAD_REQUEST);
		}
	}
}
