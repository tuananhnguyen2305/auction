package com.uet.auction.serivce;

import com.uet.auction.entity.keys.IdUserAuction;

public interface IUserAuctionService {
    boolean attendToAuction(String username, int auctionId);
    boolean isAttended(String username, int auctionId);
}
