package com.uet.auction.serivce;

import com.uet.auction.dto.BiddingDTO;

public interface IBiddingService {
    boolean createBidding(int amount, int auctionId, String username);

    BiddingDTO getLatestBidding(int auctionId);
}
