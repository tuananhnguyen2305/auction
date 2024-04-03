package com.uet.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public LicensePlateDTO createOne(@RequestBody LicensePlateDTO licensePlateDTO) {
		return licensePlateService.save(licensePlateDTO);
	}
	
	@GetMapping("/license_plate/{id}") 
	public LicensePlateDTO findOneById(@PathVariable String id) {
		return licensePlateService.findOneById(id);
	}
	
	@GetMapping("/license_plate")
	public List<LicensePlateDTO> findAll() {
		return licensePlateService.findAll();
	}
}
