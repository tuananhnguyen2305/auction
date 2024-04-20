package com.uet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uet.converter.AuctionSessionConverter;
import com.uet.dto.AuctionSessionDTO;
import com.uet.entity.AuctionSession;
import com.uet.repository.AuctionSessionRepo;
import com.uet.service.IAuctionSessionService;

@Service
public class AuctionSessionService implements IAuctionSessionService{
	@Autowired
	private AuctionSessionRepo auctionSessionRepo;
	
	@Autowired
	private AuctionSessionConverter auctionSessionConverter;
	
	@Override
	public AuctionSessionDTO save(AuctionSessionDTO auctionSessionDTO) {
		AuctionSession auctionSession = auctionSessionConverter.toEntity(auctionSessionDTO);
		auctionSessionRepo.save(auctionSession);
		return auctionSessionConverter.toDTO(auctionSession);
	}

	@Override
	public AuctionSessionDTO findOneById(String id) {
		AuctionSession auctionSession = auctionSessionRepo.findOne(id);
		return auctionSessionConverter.toDTO(auctionSession);
	}

	@Override
	public List<AuctionSessionDTO> findAll() {
		List<AuctionSessionDTO> auctionSessionDTOs = new ArrayList<AuctionSessionDTO>();
		for (AuctionSession auctionSession : auctionSessionRepo.findAll()) {
			auctionSessionDTOs.add(auctionSessionConverter.toDTO(auctionSession));
		}
		return auctionSessionDTOs;
	}

	@Override
	public AuctionSessionDTO deleteOneById(String id) {
		AuctionSession acAuctionSession = auctionSessionRepo.findOne(id);
		auctionSessionRepo.delete(acAuctionSession);
		return auctionSessionConverter.toDTO(acAuctionSession);
	}

}
