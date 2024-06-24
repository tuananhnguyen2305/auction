package com.uet.auction.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uet.auction.entity.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
