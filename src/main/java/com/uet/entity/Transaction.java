package com.uet.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table
@Entity
public class Transaction {
	@Id
	@Column(name = "auction_id")
	private String auctionId;
	
	@Column
	private String ownerId;
	
	@Column
	private String winerId;
	
	@Column
	private int amount;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private Date date;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "auction_id")
	private AuctionSession auctionSession;

	public String getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(String id) {
		this.auctionId = id;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
