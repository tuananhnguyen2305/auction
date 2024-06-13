package com.uet.auction.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uet.auction.entity.enums.Status;
import jakarta.persistence.*;

@Entity(name = "auction")
public class Auction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private Date beginningTime;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd' 'HH:mm:ss")
	private Date endingTime;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column
	private int startingPrice;
	
	@OneToMany(mappedBy = "auction")
	private List<Bidding> biddings;
	
	@ManyToOne
	@JoinColumn(name = "license_plate_id")
	private License license;
	
	@OneToOne(mappedBy = "auction")
	@PrimaryKeyJoinColumn
	private Transaction transaction;

	@OneToMany(mappedBy = "auction")
	private Set<UserAuction> userAuctionSet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Bidding> getBiddings() {
		return biddings;
	}

	public void setBiddings(List<Bidding> biddings) {
		this.biddings = biddings;
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Set<UserAuction> getUserAuctionSet() {
		return userAuctionSet;
	}

	public void setUserAuctionSet(Set<UserAuction> userAuctionSet) {
		this.userAuctionSet = userAuctionSet;
	}
}
