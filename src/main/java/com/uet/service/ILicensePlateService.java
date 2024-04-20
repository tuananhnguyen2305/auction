package com.uet.service;

import java.util.List;

import com.uet.dto.LicensePlateDTO;

public interface ILicensePlateService {
	LicensePlateDTO save(LicensePlateDTO licensePlateDTO);
	LicensePlateDTO findOneById(String id);
	List<LicensePlateDTO> findAll();
	LicensePlateDTO deleteOneById(String id);
}
