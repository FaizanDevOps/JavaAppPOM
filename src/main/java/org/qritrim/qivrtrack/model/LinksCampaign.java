package org.qritrim.qivrtrack.model;

import java.util.Map;

public class LinksCampaign {
	private String campaignName;
	private int brandId;
	private int companyId;
	private int campaignId;
	private int objectiveId;
//	private Map<Integer,String> links;
	private String kpi;
	private int agencyId;
	private String timeLine;
	private Integer[] influencers;
	private String links;
	private String brands;
	private String brandName;
	
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrands() {
		return brands;
	}
	public void setBrands(String brands) {
		this.brands = brands;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public int getObjectiveId() {
		return objectiveId;
	}
	public void setObjectiveId(int objectiveId) {
		this.objectiveId = objectiveId;
	}
	public String getKpi() {
		return kpi;
	}
	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	public String getTimeLine() {
		return timeLine;
	}
	public void setTimeLine(String timeLine) {
		this.timeLine = timeLine;
	}
	public Integer[] getInfluencers() {
		return influencers;
	}
	public void setInfluencers(Integer[] influencers) {
		this.influencers = influencers;
	}
	public String getLinks() {
		return links;
	}
	public void setLinks(String links) {
		this.links = links;
	}
		
}
