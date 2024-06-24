package com.uet.auction.repository;

import com.uet.auction.entity.UserAuction;
import com.uet.auction.entity.keys.IdUserAuction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAuctionRepository extends JpaRepository<UserAuction, IdUserAuction> {
}
