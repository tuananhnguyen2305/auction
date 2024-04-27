package com.uet.dto;

import com.uet.enums.Status;

public class AuctionSessionDTO {
	private String auctionId;
	
	//@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private String beginningTime;
	
	//@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private String endingTime;
	
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

	public String getBeginningTime() {
		return beginningTime;
	}

	public void setBeginningTime(String beginningTime) {
		this.beginningTime = beginningTime;
	}

	public String getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(String endingTime) {
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
