package com.uet.auction.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;

	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "contact_number")
	private String contactNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "identity_number")
	private String identityNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "balance")
	private int balance;
	
	@OneToMany(mappedBy = "user")
	private List<Bidding> biddings;

	@OneToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@OneToMany(mappedBy = "user")
	private Set<License> licenseSet;

	@OneToMany(mappedBy = "user")
	private Set<UserAuction> userAuctionSet;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public List<Bidding> getBiddings() {
		return biddings;
	}

	public void setBiddings(List<Bidding> biddings) {
		this.biddings = biddings;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<License> getLicenseSet() {
		return licenseSet;
	}

	public void setLicenseSet(Set<License> licenseSet) {
		this.licenseSet = licenseSet;
	}

	public Set<UserAuction> getUserAuctionSet() {
		return userAuctionSet;
	}

	public void setUserAuctionSet(Set<UserAuction> userAuctionSet) {
		this.userAuctionSet = userAuctionSet;
	}
}
