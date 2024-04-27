package com.uet.service;

import java.util.List;

import com.uet.dto.AuctionSessionDTO;
import com.uet.entity.AuctionSession;

public interface IAuctionSessionService {
	AuctionSessionDTO save(AuctionSessionDTO auctionSessionDTO);
	AuctionSessionDTO findOneById(String id);
	List<AuctionSessionDTO> findAll();
	AuctionSessionDTO deleteOneById(String id);
	boolean isAuctionFinished(AuctionSessionDTO auction);
	void finishAuction(AuctionSessionDTO auction);
}

