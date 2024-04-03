package com.uet.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uet.dto.AuctionSessionDTO;
import com.uet.entity.AuctionSession;
import com.uet.entity.LicensePlate;
import com.uet.entity.User;
import com.uet.repository.LicensePlateRepo;
import com.uet.repository.UserRepo;

@Component
public class AuctionSessionConverter {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private LicensePlateRepo licensePlateRepo;
	
	public AuctionSession toEntity(AuctionSessionDTO DTO) {
		AuctionSession entity = new AuctionSession();
		entity.setAuctionId(DTO.getAuctionId());
		User user = userRepo.findOne(DTO.getUserId());
		entity.setUser(user);
		entity.setBeginningTime(DTO.getBeginningTime());
		entity.setEndingTime(DTO.getEndingTime());
		entity.setStatus(DTO.getStatus());
		entity.setStartingPrice(DTO.getStartingPrice());
		LicensePlate licensePlate = licensePlateRepo.findOne(DTO.getLicensePlateId());
		entity.setLicensePlate(licensePlate);
		return entity;
	}
	
	public AuctionSessionDTO toDTO(AuctionSession entity) {
		AuctionSessionDTO DTO = new AuctionSessionDTO();
		DTO.setAuctionId(entity.getAuctionId());
		DTO.setUserId(entity.getUser().getUsername());
		DTO.setBeginningTime(entity.getBeginningTime());
		DTO.setEndingTime(entity.getEndingTime());
		DTO.setStatus(entity.getStatus());
		DTO.setStartingPrice(entity.getStartingPrice());
		DTO.setLicensePlateId(entity.getLicensePlate().getLicensePlateId());
		return DTO;
	}
}
