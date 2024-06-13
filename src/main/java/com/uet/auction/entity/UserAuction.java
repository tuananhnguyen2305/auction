package com.uet.auction.entity;

import com.uet.auction.entity.keys.IdUserAuction;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "user_auction")
public class UserAuction {
    @EmbeddedId
    private IdUserAuction ids;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "auction_id", insertable = false, updatable = false)
    private Auction auction;

    @Column(name = "created_date")
    private Date createdDate;

    public IdUserAuction getIds() {
        return ids;
    }

    public void setIds(IdUserAuction ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
