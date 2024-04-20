package com.uet.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransactionDTO {
	private String id;
	
	private String auctionId;
	
	private String ownerId;
	
	private String winerId;
	
	private int amount;
	
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private Date date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
