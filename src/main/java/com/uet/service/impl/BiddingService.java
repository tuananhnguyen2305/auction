package com.uet.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uet.converter.BiddingConverter;
import com.uet.dto.AuctionSessionDTO;
import com.uet.dto.BiddingDTO;
import com.uet.entity.Bidding;
import com.uet.enums.Status;
import com.uet.repository.BiddingRepo;
import com.uet.service.IAuctionSessionService;
import com.uet.service.IBiddingService;

@Service
public class BiddingService implements IBiddingService{
	@Autowired
	private BiddingRepo biddingRepo;
	
	@Autowired
	private BiddingConverter biddingConverter;
	
	@Autowired
	private IAuctionSessionService auctionSessionService;
	
	@Override
	@Transactional
	public BiddingDTO create(BiddingDTO biddingDTO) {
		AuctionSessionDTO auctionSession = auctionSessionService.findOneById(biddingDTO.getAuctionSessionId());
		Bidding bidding = biddingConverter.toEntity(biddingDTO);
		if (auctionSession.getStatus().equals(Status.ACTIVE) && !auctionSessionService.isAuctionFinished(auctionSession)) {
			biddingRepo.save(bidding);
			return biddingConverter.toDTO(bidding);
		}
		return null;
	}

	@Override
	public BiddingDTO findLastBiddingOfAnAuctionSession(String id) {
		List<Bidding> biddings = biddingRepo.findAll();
		for(int i = biddings.size() - 1; i >= 0; i--) {
			if (biddings.get(i).getAuctionSession().getAuctionId().equals(id)) {
				return biddingConverter.toDTO(biddings.get(i));
			}
		}
		return null;
	}

	@Override
	public List<BiddingDTO> findAll() {
		List<BiddingDTO> biddingDTOs = new ArrayList<BiddingDTO>();
		for (Bidding bidding : biddingRepo.findAll()) {
			biddingDTOs.add(biddingConverter.toDTO(bidding));
		}
		return biddingDTOs;
	}

	@Override
	public BiddingDTO deleteOneById(int id) {
		Bidding bidding = biddingRepo.findOne(id);
		biddingRepo.delete(bidding);
		return biddingConverter.toDTO(bidding);
	}

	@Override
	public List<BiddingDTO> findAllBiddingsOfAnAuctionSession(String id) {
		List<Bidding> biddings = biddingRepo.findAll();
		List<BiddingDTO> biddingDTOs = new ArrayList<BiddingDTO>();
		for(Bidding bidding: biddings) {
			if (bidding.getAuctionSession().getAuctionId().equals(id)) {
				biddingDTOs.add(biddingConverter.toDTO(bidding));
			}
		}
		return biddingDTOs;
	}

}
