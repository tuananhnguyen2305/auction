package com.uet.auction.converter;

import com.uet.auction.dto.AuctionDTO;
import com.uet.auction.entity.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuctionConverter {
    @Autowired
    DateStringConverter dateStringConverter;

    public AuctionDTO toDTO(Optional<Auction> auction) {
        Auction entity = auction.get();
        AuctionDTO auctionDTO = new AuctionDTO();

        auctionDTO.setId(entity.getId());
        auctionDTO.setBeginningTime(dateStringConverter.convertToString(entity.getBeginningTime()));
        auctionDTO.setEndingTime(dateStringConverter.convertToString(entity.getEndingTime()));
        auctionDTO.setStartingPrice(entity.getStartingPrice());
        auctionDTO.setStt(entity.getStatus().name());
        auctionDTO.setLicenseId(entity.getLicense().getId());

        return auctionDTO;
    }
}
