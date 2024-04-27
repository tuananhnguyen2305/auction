package com.uet.dto;


public class TransactionDTO {
	
	private String auctionId;
	
	private String ownerId;
	
	private String winerId;
	
	private int amount;
	
	//@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private String date;

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getWinerId() {
		return winerId;
	}

	public void setWinerId(String winerId) {
		this.winerId = winerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
