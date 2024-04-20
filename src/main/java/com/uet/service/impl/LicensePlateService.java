package com.uet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uet.converter.LicensePlateConverter;
import com.uet.dto.LicensePlateDTO;
import com.uet.entity.LicensePlate;
import com.uet.repository.LicensePlateRepo;
import com.uet.service.ILicensePlateService;

@Service
public class LicensePlateService implements ILicensePlateService{
	@Autowired
	private LicensePlateConverter licensePlateConverter;
	
	@Autowired
	private LicensePlateRepo licensePlateRepo;

	@Override
	public LicensePlateDTO save(LicensePlateDTO licensePlateDTO) {
		LicensePlate licensePlate = licensePlateConverter.toEntity(licensePlateDTO);
		licensePlateRepo.save(licensePlate);
		return licensePlateConverter.toDTO(licensePlate);
	}

	@Override
	public LicensePlateDTO findOneById(String id) {
		LicensePlate licensePlate = licensePlateRepo.findOne(id);
		return licensePlateConverter.toDTO(licensePlate);
	}

	@Override
	public List<LicensePlateDTO> findAll() {
		List<LicensePlateDTO> licensePlateDTOs = new ArrayList<LicensePlateDTO>();
		for (LicensePlate licensePlate : licensePlateRepo.findAll()) {
			licensePlateDTOs.add(licensePlateConverter.toDTO(licensePlate));
		}
		return licensePlateDTOs;
	}

	@Override
	public LicensePlateDTO deleteOneById(String id) {
		LicensePlate licensePlate = licensePlateRepo.findOne(id);
		licensePlateRepo.delete(licensePlate);
		return licensePlateConverter.toDTO(licensePlate);
	}
	
}
