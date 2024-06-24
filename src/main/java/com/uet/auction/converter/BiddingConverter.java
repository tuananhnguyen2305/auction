package com.uet.auction.converter;

import com.uet.auction.dto.BiddingDTO;
import com.uet.auction.entity.Bidding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BiddingConverter {
    @Autowired
    DateStringConverter dateStringConverter;

    public BiddingDTO toDTO(Bidding bidding) {
        BiddingDTO biddingDTO = BiddingDTO.builder()
                .amount(bidding.getAmount())
                .auctionId(bidding.getAuction().getId())
                .username(bidding.getUser().getUsername())
                .createdDate(dateStringConverter.convertToString(bidding.getCreateDate()))
                .build();
        return biddingDTO;
    }
}
