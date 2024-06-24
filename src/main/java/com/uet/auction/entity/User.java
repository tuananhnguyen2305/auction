package com.uet.auction.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String username;
	String password;
	String fullname;
	String contactNumber;
	String address;
	String identityNumber;
	String email;
	int balance;
	@OneToMany(mappedBy = "user")
	List<Bidding> biddings;

	@ManyToOne
	@JoinColumn(name = "role_id")
	Role role;

	@OneToMany(mappedBy = "user")
	Set<License> licenseSet;

	@OneToMany(mappedBy = "user")
	Set<UserAuction> userAuctionSet;
}
