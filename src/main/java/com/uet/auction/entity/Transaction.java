package com.uet.auction.entity;

import java.util.Date;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "auction_id")
	private Auction auction;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}
}
