package com.uet.service;

import java.util.List;

import com.uet.dto.ProvinceDTO;

public interface IProvinceService {
	ProvinceDTO findOneById(int id);
	List<ProvinceDTO> findAll();
}
