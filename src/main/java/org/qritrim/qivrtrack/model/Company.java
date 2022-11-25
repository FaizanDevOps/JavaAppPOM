package org.qritrim.qivrtrack.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Company {
	private int companyId;
	private String companyName;
//	private String logoPath;
	private ArrayList<String> brands;
    private String companyLogoUrl;
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public ArrayList<String> getBrands() {
		return brands;
	}
	public void setBrands(ArrayList<String> brands) {
		this.brands = brands;
	}
	public String getCompanyLogoUrl() {
		return companyLogoUrl;
	}
	public void setCompanyLogoUrl(String companyLogoUrl) {
		this.companyLogoUrl = companyLogoUrl;
	}
	
}
