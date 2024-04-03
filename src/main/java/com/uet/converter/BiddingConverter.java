package com.uet.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uet.dto.BiddingDTO;
import com.uet.entity.AuctionSession;
import com.uet.entity.Bidding;
import com.uet.entity.User;
import com.uet.repository.AuctionSessionRepo;
import com.uet.repository.UserRepo;

@Component
public class BiddingConverter {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AuctionSessionRepo auctionSessionRepo;
	
	public Bidding toEntity(BiddingDTO DTO) {
		Bidding entity = new Bidding();
		User user = userRepo.findOne(DTO.getUserId());
		entity.setUser(user);
		AuctionSession auctionSession = auctionSessionRepo.findOne(DTO.getAuctionSessionId());
		entity.setAuctionSession(auctionSession);
		entity.setBiddingId(DTO.getBiddingId());
		entity.setAmount(DTO.getAmount());
		return entity;
	}
	
	public BiddingDTO toDTO(Bidding entity) {
		BiddingDTO DTO = new BiddingDTO();
		DTO.setUserId(entity.getUser().getUsername());
		DTO.setAuctionSessionId(entity.getAuctionSession().getAuctionId());
		DTO.setBiddingId(entity.getBiddingId());
		DTO.setAmount(entity.getAmount());
		DTO.setBiddingTime(entity.getCreateDate());
		return DTO;
	}
}
