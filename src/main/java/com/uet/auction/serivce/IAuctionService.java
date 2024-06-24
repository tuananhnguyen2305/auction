package com.uet.auction.serivce;

import com.uet.auction.dto.AuctionDTO;

public interface IAuctionService {
    boolean createAuction(String beginningTime, String endingTime, int startingPrice, int licenseId);
    AuctionDTO getDetailAuction(int id);
    AuctionDTO approveAuction(int id);
    boolean denyAuction(int id);

}
