package com.uet.auction.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "province")
public class Province {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy = "province")
	private List<License> licenses;
	
	@Column 
	private String provinceName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<License> getLicensePlates() {
		return licenses;
	}

	public void setLicensePlates(List<License> licenses) {
		this.licenses = licenses;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
}
