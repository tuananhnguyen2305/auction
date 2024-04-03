package com.uet.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity
public class LicensePlate {
	@Id
	private String licensePlateId;
	
	@Column
	private String meanOfTransport;
	
	@Column
	private String userName;
	
	@ManyToOne
	@JoinColumn(name = "province_id")
	private Province province;
	
	@OneToMany(mappedBy = "licensePlate")
	private List<AuctionSession> auctionSessions;

	public String getMeanOfTransport() {
		return meanOfTransport;
	}

	public void setMeanOfTransport(String meanOfTransport) {
		this.meanOfTransport = meanOfTransport;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public List<AuctionSession> getAuctionSessions() {
		return auctionSessions;
	}

	public void setAuctionSessions(List<AuctionSession> auctionSessions) {
		this.auctionSessions = auctionSessions;
	}

	public String getLicensePlateId() {
		return licensePlateId;
	}

	public void setLicensePlateId(String licensePlateId) {
		this.licensePlateId = licensePlateId;
	}
	
}
