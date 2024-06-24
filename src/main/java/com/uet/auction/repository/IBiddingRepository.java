package com.uet.auction.repository;

import com.uet.auction.entity.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBiddingRepository extends JpaRepository<Bidding, Integer> {
    Optional<Bidding> findFirstByAuctionIdOrderByAmountDesc(int auctionId);
}
