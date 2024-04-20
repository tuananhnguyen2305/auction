package com.uet.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uet.enums.Status;

public class AuctionSessionDTO {
	private String auctionId;
	
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private Date beginningTime;
	
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private Date endingTime;
	
	private Status status;
	
	private int startingPrice;
	
	private String userId;
	
	private String licensePlateId;
	
	public String getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}

	public Date getBeginningTime() {
		return beginningTime;
	}

	public void setBeginningTime(Date beginningTime) {
		this.beginningTime = beginningTime;
	}

	public Date getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(Date endingTime) {
		this.endingTime = endingTime;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(int startingPrice) {
		this.startingPrice = startingPrice;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLicensePlateId() {
		return licensePlateId;
	}

	public void setLicensePlateId(String licensePlateId) {
		this.licensePlateId = licensePlateId;
	}

}
