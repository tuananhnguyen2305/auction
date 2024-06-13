package com.uet.auction.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "license")
public class License {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "license_id")
	private String licenseId;

	@ManyToOne
	@JoinColumn(name = "transport_id")
	private Transport transport;

	@ManyToOne
	@JoinColumn(name = "province_id")
	private Province province;
	
	@OneToMany(mappedBy = "license")
	private List<Auction> auctionList;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public List<Auction> getAuctionList() {
		return auctionList;
	}

	public void setAuctionList(List<Auction> auctionList) {
		this.auctionList = auctionList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
