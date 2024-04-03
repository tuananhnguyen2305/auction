package com.uet.converter;

import org.springframework.stereotype.Component;

import com.uet.dto.ProvinceDTO;
import com.uet.entity.Province;

@Component
public class ProvinceConverter {
	public ProvinceDTO toDTO(Province entity) {
		ProvinceDTO DTO = new ProvinceDTO();
		DTO.setId(entity.getId());
		DTO.setProvinceName(entity.getProvinceName());
		return DTO;
	}
}
