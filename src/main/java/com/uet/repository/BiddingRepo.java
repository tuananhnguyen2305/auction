package com.uet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uet.entity.Bidding;

@Repository
public interface BiddingRepo extends JpaRepository<Bidding, Integer>{

}
