package com.uet.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uet.dto.ProvinceDTO;
import com.uet.service.IProvinceService;

@RestController
public class ProvinceAPI {
	@Autowired
	private IProvinceService provinceService;
	
	@GetMapping("/province/{id}")
	public ProvinceDTO findOneById(@PathVariable int id) {
		return provinceService.findOneById(id);
	}
	
	@GetMapping("/province")
	public List<ProvinceDTO> findAll() {
		return provinceService.findAll();
	}
}
