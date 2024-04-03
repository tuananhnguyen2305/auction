package com.uet.dto;

import java.util.Date;

public class BiddingDTO {
	private int biddingId;
	
	private String userId;

	private String auctionSessionId;
	
	private int amount;
	
	private Date biddingTime;

	public int getBiddingId() {
		return biddingId;
	}

	public void setBiddingId(int biddingId) {
		this.biddingId = biddingId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getBiddingTime() {
		return biddingTime;
	}

	public void setBiddingTime(Date biddingTime) {
		this.biddingTime = biddingTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAuctionSessionId() {
		return auctionSessionId;
	}

	public void setAuctionSessionId(String auctionSessionId) {
		this.auctionSessionId = auctionSessionId;
	}
}
