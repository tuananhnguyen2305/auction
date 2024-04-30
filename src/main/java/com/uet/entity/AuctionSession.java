package com.uet.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uet.enums.Status;

@Table
@Entity
public class AuctionSession {
	@Id
	private String auctionId;
	
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
	
	@OneToMany(mappedBy = "auctionSession")
	private List<Bidding> biddings;
	
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "license_plate_id")
	private LicensePlate licensePlate;
	
	@OneToOne(mappedBy = "auctionSession")
	@PrimaryKeyJoinColumn
	private Transaction transaction;
	
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

	public List<Bidding> getBiddings() {
		return biddings;
	}

	public void setBiddings(List<Bidding> biddings) {
		this.biddings = biddings;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LicensePlate getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(LicensePlate licensePlate) {
		this.licensePlate = licensePlate;
	}
}
