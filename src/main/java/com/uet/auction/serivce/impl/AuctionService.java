package com.uet.auction.serivce.impl;

import com.uet.auction.converter.AuctionConverter;
import com.uet.auction.converter.DateStringConverter;
import com.uet.auction.dto.AuctionDTO;
import com.uet.auction.entity.Auction;
import com.uet.auction.entity.License;
import com.uet.auction.entity.enums.Status;
import com.uet.auction.repository.IAuctionRepository;
import com.uet.auction.serivce.IAuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuctionService implements IAuctionService {
    @Autowired
    IAuctionRepository auctionRepository;

    @Autowired
    AuctionConverter auctionConverter;

    @Autowired
    DateStringConverter dateStringConverter;

    @Override
    public boolean createAuction(String beginningTime, String endingTime, int startingPrice, int licenseId) {
        boolean isSuccess = false;

        Auction auction = new Auction();

        Date beginning = dateStringConverter.convertToDate(beginningTime);
        Date ending = dateStringConverter.convertToDate(endingTime);

        License license = new License();
        license.setId(licenseId);

        Status stt = Status.PENDING;
        try {
            auction.setLicense(license);
            auction.setBeginningTime(beginning);
            auction.setEndingTime(ending);
            auction.setStartingPrice(startingPrice);
            auction.setStatus(stt);

            auctionRepository.save(auction);
            isSuccess = true;
        } catch (Exception e) {
            System.out.println("Error in creating auction: " + e.getMessage());
        }
        return false;
    }

    @Override
    public AuctionDTO getDetailAuction(int id) {
        Optional<Auction> auction = auctionRepository.findById(id);

        return auctionConverter.toDTO(auction);
    }

    @Override
    public AuctionDTO approveAuction(int id) {
        Auction auction = auctionRepository.findById(id).get();
        auction.setStatus(Status.ACTIVE);

        auctionRepository.save(auction);
        return auctionConverter.toDTO(auction);
    }

    @Override
    public boolean denyAuction(int id) {
        try {
            auctionRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Error in denying auction");
        }
        return false;
    }
}
