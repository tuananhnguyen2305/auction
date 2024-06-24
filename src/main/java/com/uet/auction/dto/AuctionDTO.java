package com.uet.auction.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuctionDTO {
    private int id;
    private String beginningTime;
    private String endingTime;
    private int startingPrice;
    private String stt;
    private int licenseId;

}
