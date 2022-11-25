package org.qritrim.qivrtrack.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ManageCompanies {
	private int companyId;
   private String companyName;
   private ArrayList<String> brandList;
private String brands;
   private int totalCampaigns;
   private int activeCampaigns;
   private int draftCampaigns;
   private String companyLogoUrl;
   public ArrayList<String> getBrandList() {
	return brandList;
}
public void setBrandList(ArrayList<String> brandList) {
	this.brandList = brandList;
}
public String getCompanyLogoUrl() {
	return companyLogoUrl;
}
public void setCompanyLogoUrl(String companyLogoUrl) {
	this.companyLogoUrl = companyLogoUrl;
}
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
public String getBrands() {
	return brands;
}
public void setBrands(String string) {
	this.brands = string;
}
public int getTotalCampaigns() {
	return totalCampaigns;
}
public void setTotalCampaigns(int totalCampaigns) {
	this.totalCampaigns = totalCampaigns;
}
public int getActiveCampaigns() {
	return activeCampaigns;
}
public void setActiveCampaigns(int activeCampaigns) {
	this.activeCampaigns = activeCampaigns;
}
public int getDraftCampaigns() {
	return draftCampaigns;
}
public void setDraftCampaigns(int draftCampaigns) {
	this.draftCampaigns = draftCampaigns;
}

}
