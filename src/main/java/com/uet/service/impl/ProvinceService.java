package com.uet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uet.converter.ProvinceConverter;
import com.uet.dto.ProvinceDTO;
import com.uet.entity.Province;
import com.uet.repository.ProvinceRepo;
import com.uet.service.IProvinceService;

@Service
public class ProvinceService implements IProvinceService{
	@Autowired
	private ProvinceRepo provinceRepo;
	
	@Autowired
	private ProvinceConverter provinceConverter;
	
	@Override
	public ProvinceDTO findOneById(int id) {
		Province province = provinceRepo.findOne(id);
		return provinceConverter.toDTO(province);
	}

	@Override
	public List<ProvinceDTO> findAll() {
		List<ProvinceDTO> provinceDTOs = new ArrayList<ProvinceDTO>();
		for (Province province : provinceRepo.findAll()) { 
			provinceDTOs.add(provinceConverter.toDTO(province));
		}
		return provinceDTOs;
	}

}
