package com.uet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uet.entity.AuctionSession;

@Repository
public interface AuctionSessionRepo extends JpaRepository<AuctionSession, String>{

}
