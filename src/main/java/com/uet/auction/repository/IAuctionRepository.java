package com.uet.auction.repository;

import com.uet.auction.entity.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuctionRepository extends JpaRepository<Auction, Integer> {
}
