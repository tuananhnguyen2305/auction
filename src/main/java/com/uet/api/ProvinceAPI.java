package com.uet.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uet.service.IProvinceService;

@RestController
public class ProvinceAPI {
	@Autowired
	private IProvinceService provinceService;
	
	@GetMapping("/province/{id}")
	public ResponseEntity<?> findOneById(@PathVariable int id) {
		try {
			return new ResponseEntity<>(provinceService.findOneById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Không tồn tại", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/province")
	public ResponseEntity<?> findAll() {
		try {
			return new ResponseEntity<>(provinceService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Không tồn tại", HttpStatus.BAD_REQUEST);
		}
	}
}
