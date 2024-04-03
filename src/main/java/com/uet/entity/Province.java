package com.uet.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Province {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany(mappedBy = "province")
	private List<LicensePlate> licensePlates;
	
	@Column 
	private String provinceName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<LicensePlate> getLicensePlates() {
		return licensePlates;
	}

	public void setLicensePlates(List<LicensePlate> licensePlates) {
		this.licensePlates = licensePlates;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
}
