package com.uet.auction.serivce.impl;

import com.uet.auction.converter.BiddingConverter;
import com.uet.auction.converter.DateStringConverter;
import com.uet.auction.dto.BiddingDTO;
import com.uet.auction.entity.Bidding;
import com.uet.auction.repository.IAuctionRepository;
import com.uet.auction.repository.IBiddingRepository;
import com.uet.auction.repository.IUserRepository;
import com.uet.auction.serivce.IBiddingService;
import com.uet.auction.serivce.IUserAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BiddingService implements IBiddingService {
    @Autowired
    IBiddingRepository biddingRepository;

    @Autowired
    BiddingConverter biddingConverter;

    @Autowired
    IUserAuctionService userAuctionService;

    @Autowired
    IAuctionRepository auctionRepository;

    @Autowired
    DateStringConverter dateStringConverter;

    @Autowired
    IUserRepository userRepository;

    @Override
    public boolean createBidding(int amount, int auctionId, String username) {
        try {
            Bidding bidding = new Bidding();
            bidding.setAmount(amount);
            bidding.setCreateDate(new Date());
            bidding.setAuction(auctionRepository.findById(auctionId).get());
            bidding.setUser(userRepository.findByUsername(username).get());

            biddingRepository.save(bidding);
            return true;
        } catch (Exception e) {
            System.out.println("Error in creating bidding: " + e.getMessage());
        }
        return false;
    }

    @Override
    public BiddingDTO getLatestBidding(int auctionId) {
        try {
            return biddingConverter
                    .toDTO(biddingRepository
                        .findFirstByAuctionIdOrderByAmountDesc(auctionId)
                        .get());
        } catch (Exception e) {
            System.out.println("Error in getting lastest bidding: " + e.getMessage());
        }
        return null;
    }

    public boolean checkValidBidding(int amount, int auctionId, String username) {
        return userAuctionService.isAttended(username, auctionId)
                && getLatestBidding(auctionId).getAmount() < amount;

    }
}
