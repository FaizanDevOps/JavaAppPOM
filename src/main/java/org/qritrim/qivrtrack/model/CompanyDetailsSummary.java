package org.qritrim.qivrtrack.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class CompanyDetailsSummary {
	private int companyId;
	private ArrayList<String> brandsList;
    private String companyLogoUrl;
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUploaded() {
		return uploaded;
	}

	public void setUploaded(String uploaded) {
		this.uploaded = uploaded;
	}

	public int getBrandsCount() {
		return brandsCount;
	}

	public void setBrandsCount(int brandsCount) {
		this.brandsCount = brandsCount;
	}

	public String getBrands() {
		return brands;
	}

	public void setBrands(String brands) {
		this.brands = brands;
	}

	private String company;
	private String uploaded;
	private int brandsCount;
	private String brands;
	private int campaignCount;
	public ArrayList<String> getBrandsList() {
		return brandsList;
	}

	public void setBrandsList(ArrayList<String> brandsList) {
		this.brandsList = brandsList;
	}

	public String getCompanyLogoUrl() {
		return companyLogoUrl;
	}

	public void setCompanyLogoUrl(String companyLogoUrl) {
		this.companyLogoUrl = companyLogoUrl;
	}

	public int getCampaignCount() {
		return campaignCount;
	}

	public void setCampaignCount(int campaignCount) {
		this.campaignCount = campaignCount;
	}
	
}
