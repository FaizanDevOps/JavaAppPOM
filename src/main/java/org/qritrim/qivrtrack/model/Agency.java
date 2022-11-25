package org.qritrim.qivrtrack.model;

import java.io.InputStream;

import lombok.Data;

@Data
public class Agency {
	private int agencyId;
	private InputStream is;
	private String agencyName;
	private String agencyEmail;
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getAgencyEmail() {
		return agencyEmail;
	}
	public void setAgencyEmail(String agencyEmail) {
		this.agencyEmail = agencyEmail;
	}
	
}
