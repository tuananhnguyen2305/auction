package com.uet.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uet.converter.AuctionSessionConverter;
import com.uet.converter.DateStringConverter;
import com.uet.dto.AuctionSessionDTO;
import com.uet.dto.BiddingDTO;
import com.uet.entity.AuctionSession;
import com.uet.enums.Status;
import com.uet.repository.AuctionSessionRepo;
import com.uet.service.IAuctionSessionService;
import com.uet.service.IBiddingService;
import com.uet.service.ITransactionService;

@Service
public class AuctionSessionService implements IAuctionSessionService{
	@Autowired
	private AuctionSessionRepo auctionSessionRepo;
	
	@Autowired
	private AuctionSessionConverter auctionSessionConverter;
	
	@Autowired
	private IBiddingService biddingService;
	
	@Autowired
	private ITransactionService transactionService;
	
	@Override
	public AuctionSessionDTO save(AuctionSessionDTO auctionSessionDTO) {
		if (new Date().after(DateStringConverter.convertToDate(auctionSessionDTO.getBeginningTime()))) {
			return null;
		}
		AuctionSession auctionSession = auctionSessionConverter.toEntity(auctionSessionDTO);
		auctionSessionRepo.save(auctionSession);
		return auctionSessionConverter.toDTO(auctionSession);
	}

	@Override
	public AuctionSessionDTO findOneById(String id) {
		AuctionSession auctionSession = auctionSessionRepo.findOne(id);
		if (auctionSession == null) {
			return null;
		}
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

	@Override
	public boolean isAuctionFinished(AuctionSessionDTO auction) {
		if (auction.getEndingTime() == null) {
			return false;
		}
		Date currentDate = new Date();
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return currentDate.after(DateStringConverter.convertToDate(auction.getEndingTime()));
	}

	@Override
	@Transactional
	public void finishAuction(AuctionSessionDTO auction) {
		auction.setStatus(Status.COMPLETE);
		auctionSessionRepo.save(auctionSessionConverter.toEntity(auction));
		BiddingDTO biddingDTO = biddingService.findLastBiddingOfAnAuctionSession(auction.getAuctionId());
		if (biddingDTO != null) {
			transactionService.create(auction, biddingDTO);
		}
	}

}
