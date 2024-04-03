package com.uet.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uet.dto.LicensePlateDTO;
import com.uet.entity.LicensePlate;
import com.uet.entity.Province;
import com.uet.repository.ProvinceRepo;

@Component
public class LicensePlateConverter {
	@Autowired
	private ProvinceRepo provinceRepo;
	
	public LicensePlate toEntity(LicensePlateDTO DTO) {
		LicensePlate entity = new LicensePlate();
		entity.setUserName(DTO.getUserName());
		entity.setMeanOfTransport(DTO.getMeanOfTransport());
		Province province = provinceRepo.findOne(DTO.getProvince_id());
		entity.setProvince(province);
		entity.setLicensePlateId(DTO.getLicensePlateId());
		return entity;
	}
	
	public LicensePlateDTO toDTO(LicensePlate entity) {
		LicensePlateDTO DTO = new LicensePlateDTO();
		DTO.setUserName(entity.getUserName());
		DTO.setMeanOfTransport(entity.getMeanOfTransport());
		DTO.setProvince_id(entity.getProvince().getId());
		DTO.setLicensePlateId(entity.getLicensePlateId());
		return DTO;
	}
}
