package com.uet.auction.repository;

import com.uet.auction.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuctionRepository extends JpaRepository<Auction, Integer> {
}
