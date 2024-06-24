package com.uet.auction.serivce.impl;

import com.uet.auction.entity.Auction;
import com.uet.auction.entity.UserAuction;
import com.uet.auction.entity.keys.IdUserAuction;
import com.uet.auction.repository.IUserAuctionRepository;
import com.uet.auction.repository.IUserRepository;
import com.uet.auction.serivce.IUserAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserAuctionService implements IUserAuctionService {
    @Autowired
    IUserAuctionRepository userAuctionRepository;

    @Autowired
    IUserRepository userRepository;

    @Override
    public boolean attendToAuction(String username, int auctionId) {
        try {
            int userId = userRepository.findByUsername(username).get().getId();

            IdUserAuction idUserAuction = new IdUserAuction(userId, auctionId);

            if (isAttended(username, auctionId)) {
                UserAuction userAuction = new UserAuction();

                userAuction.setIds(idUserAuction);
                userAuction.setCreatedDate(new Date());

                userAuctionRepository.save(userAuction);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error in attending to an auction: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean isAttended(String username, int auctionId) {
        try {
            int userId = userRepository.findByUsername(username).get().getId();

            IdUserAuction idUserAuction = new IdUserAuction(userId, auctionId);

            Optional<UserAuction> optionalUserAuction = userAuctionRepository.findById(idUserAuction);

            if (!optionalUserAuction.isEmpty()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error in checking attended: " + e.getMessage());
        }
        return false;
    }
}
