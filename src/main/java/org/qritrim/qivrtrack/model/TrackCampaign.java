package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class TrackCampaign {
	
	private String campaignName;
	private int brandId;
	private int companyId;
	private int campaignId;
	private int objectiveId;
	private String links;
	private String kpi;
	private int agencyId;
	private String timeLine;
	private Integer[] influencersInvited;
	private Integer[] network;
	private Integer[] savedList;
	private Integer[] influencers;
	private String brandCompetitors;
	private int status;
	private String companyName;
	private String brandName;
	
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Integer[] getInfluencers() {
		return influencers;
	}
	public void setInfluencers(Integer[] influencers) {
		this.influencers = influencers;
	}
	public String getBrandCompetitors() {
		return brandCompetitors;
	}
	public void setBrandCompetitors(String brandCompetitors) {
		this.brandCompetitors = brandCompetitors;
	}
	public Integer[] getSavedList() {
		return savedList;
	}
	public void setSavedList(Integer[] savedList) {
		this.savedList = savedList;
	}
	public Integer[] getInfluencersInvited() {
		return influencersInvited;
	}
	public void setInfluencersInvited(Integer[] influencersInvited) {
		this.influencersInvited = influencersInvited;
	}
	public Integer[] getNetwork() {
		return network;
	}
	public void setNetwork(Integer[] network) {
		this.network = network;
	}
	public String getTimeLine() {
		return timeLine;
	}
	public void setTimeLine(String timeLine) {
		this.timeLine = timeLine;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	public String getCampaignName() {
		return campaignName;
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
	public String getLinks() {
		return links;
	}
	public void setLinks(String links) {
		this.links = links;
	}
	public String getKpi() {
		return kpi;
	}
	public void setKpi(String kpi) {
		this.kpi = kpi;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	

}
