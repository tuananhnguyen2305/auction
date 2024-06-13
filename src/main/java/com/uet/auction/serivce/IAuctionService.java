package com.uet.auction.serivce;

import com.uet.auction.dto.AuctionDTO;

public interface IAuctionService {
    boolean createAuction(String beginningTime, String endingTime, int startingPrice, int licenseId);
    AuctionDTO getDetailAuction(int id);
}
