package com.uet.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "auction_id")
	private AuctionSession auctionSession;
	
	@Column
	private String ownerId;
	
	@Column
	private String winerId;
	
	@Column
	private int amount;
	
	@Column
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AuctionSession getAuctionSession() {
		return auctionSession;
	}

	public void setAuctionSession(AuctionSession auctionSession) {
		this.auctionSession = auctionSession;
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
