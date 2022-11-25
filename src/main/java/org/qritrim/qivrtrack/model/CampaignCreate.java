package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class CampaignCreate {
	private String campaignName;
	private int campaignId;
	private int companyId;
	private int brandId;
	private int objectiveId;
	private int type;
	private int category;
	private int region;
	private String companyName;
	private int userId;
	private int agencyId;
	private String brandName;
	private String agencyName;
	private String timeLine; // project
	private Integer[] ageGroup;
	private int gender;
	private Integer[] influencersInvited;
	private Integer[] network;
	private int statusId;
	private Integer[] savedList;
	private String created;
	private String updated;
	
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getObjectiveId() {
		return objectiveId;
	}
	public void setObjectiveId(int objectiveId) {
		this.objectiveId = objectiveId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getRegion() {
		return region;
	}
	public void setRegion(int region) {
		this.region = region;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getTimeLine() {
		return timeLine;
	}
	public void setTimeLine(String timeLine) {
		this.timeLine = timeLine;
	}
	public Integer[] getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(Integer[] ageGroup) {
		this.ageGroup = ageGroup;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
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
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public Integer[] getSavedList() {
		return savedList;
	}
	public void setSavedList(Integer[] savedList) {
		this.savedList = savedList;
	}

}
