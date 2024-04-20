package com.uet.service;

import java.util.List;

import com.uet.dto.BiddingDTO;

public interface IBiddingService {
	BiddingDTO create(BiddingDTO biddingDTO);
	BiddingDTO findLastBiddingOfAnAuctionSession(String id);
	List<BiddingDTO> findAll();
	List<BiddingDTO> findAllBiddingsOfAnAuctionSession(String id);
	BiddingDTO deleteOneById(int id);
}
