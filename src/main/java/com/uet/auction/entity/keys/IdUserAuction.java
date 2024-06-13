package com.uet.auction.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class IdUserAuction implements Serializable {
    @Column(name = "user_id")
    private int userId;

    @Column(name = "auction_id")
    private int auctionId;

    public IdUserAuction() {

    }

    public IdUserAuction(int userId, int auctionId) {
        this.userId = userId;
        this.auctionId = auctionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
        this.auctionId = auctionId;
    }
}
