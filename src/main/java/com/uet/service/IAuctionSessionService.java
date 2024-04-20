package com.uet.service;

import java.util.List;

import com.uet.dto.AuctionSessionDTO;

public interface IAuctionSessionService {
	AuctionSessionDTO save(AuctionSessionDTO auctionSessionDTO);
	AuctionSessionDTO findOneById(String id);
	List<AuctionSessionDTO> findAll();
	AuctionSessionDTO deleteOneById(String id);
}
