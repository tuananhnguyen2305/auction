package com.uet.dto;

public class LicensePlateDTO {
	private String licensePlateId;
	
	private String meanOfTransport;
	
	private String userName;
	
	private int province_id;

	public String getLicensePlateId() {
		return licensePlateId;
	}

	public void setLicensePlateId(String licensePlateId) {
		this.licensePlateId = licensePlateId;
	}

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

	public int getProvince_id() {
		return province_id;
	}

	public void setProvince_id(int province_id) {
		this.province_id = province_id;
	}

}
