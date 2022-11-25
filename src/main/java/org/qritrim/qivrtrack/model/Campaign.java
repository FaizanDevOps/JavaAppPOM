package org.qritrim.qivrtrack.model;

import java.util.ArrayList;

import java.util.List;

import lombok.Data;

@Data
public class Campaign {
	private int campaignId;
	private int companyId;
	private String campaignName;
	private String companyName;
	 private int userId;
	 private int agencyId;
	 private String brandName;
	 private String agencyName;
//	 private String categoryName;
//	 private String regions;
//	 private String objectiveName;
//	 private String category;
//	private String region;
	private int audienceProfileId; // audienceProfile
	private Integer[] categoryId; // project
	private int brandId;
	private int objectiveId;
	private Integer[] regionId; // project
	private String timeLine; // project
	private String budget; // project
	private Integer[] agePrefId; // audienceProf
	private Integer[] ethnicalPrefId; // ethinicalPref
	private int genderPrefId; // audienceProf
	private Integer[] brandAffId; // brandAffId
//	private String agePrefName;
//	private String ethnicalPrefName;
//	private String genderPrefName;
//	private String brandAffName;
//	private String agePref;
//	private String ethnicalPref;
//	private String brandAff;
	private String audienceProfileName;
	private String status;
	private String created;
	private int campaignTypeId;
	private int influencerTypeId;
	private Integer[] attributes;
	private String[] keywords;
	private Integer[] categoryIds;
	private int statusId;
	private ArrayList<Integer> infIds;
	private AuditRedirectParams redirectParams;
	private String url;
	private List<InfluencerStatus> infStausIds;
	private Integer[] networks;
	private int threadStatus;
	private String engaged;
	
	
public int getThreadStatus() {
		return threadStatus;
	}
	public void setThreadStatus(int threadStatus) {
		this.threadStatus = threadStatus;
	}
	
	
public String getEngaged() {
		return engaged;
	}
	public void setEngaged(String engaged) {
		this.engaged = engaged;
	}
public Integer[] getNetworks() {
		return networks;
	}
	public void setNetworks(Integer[] networks) {
		this.networks = networks;
	}
	//	private String campaignTypeName;
//	private String influencerTypeName;
	public int getCampaignTypeId() {
		return campaignTypeId;
	}
	public void setCampaignTypeId(int campaignTypeId) {
		this.campaignTypeId = campaignTypeId;
	}
	public int getInfluencerTypeId() {
		return influencerTypeId;
	}
	public void setInfluencerTypeId(int influencerTypeId) {
		this.influencerTypeId = influencerTypeId;
	}
//	public String getCampaignTypeName() {
//		return campaignTypeName;
//	}
//	public void setCampaignTypeName(String campaignTypeName) {
//		this.campaignTypeName = campaignTypeName;
//	}
//	public String getInfluencerTypeName() {
//		return influencerTypeName;
//	}
//	public void setInfluencerTypeName(String influencerTypeName) {
//		this.influencerTypeName = influencerTypeName;
//	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getAudienceProfileId() {
		return audienceProfileId;
	}
	public void setAudienceProfileId(int audienceProfileId) {
		this.audienceProfileId = audienceProfileId;
	}
	public Integer[] getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer[] categoryId) {
		this.categoryId = categoryId;
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
//	public String getCategoryName() {
//		return categoryName;
//	}
//	public void setCategoryName(String categoryName) {
//		this.categoryName = categoryName;
//	}
//	public String getRegions() {
//		return regions;
//	}
//	public void setRegions(String regions) {
//		this.regions = regions;
//	}
//	public String getObjectiveName() {
//		return objectiveName;
//	}
//	public void setObjectiveName(String objectiveName) {
//		this.objectiveName = objectiveName;
//	}
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
	public Integer[] getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer[] regionId) {
		this.regionId = regionId;
	}
	public String getTimeLine() {
		return timeLine;
	}
	public void setTimeLine(String timeLine) {
		this.timeLine = timeLine;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public Integer[] getAgePrefId() {
		return agePrefId;
	}
	public void setAgePrefId(Integer[] agePrefId) {
		this.agePrefId = agePrefId;
	}
	public Integer[] getEthnicalPrefId() {
		return ethnicalPrefId;
	}
	public void setEthnicalPrefId(Integer[] ethnicalPrefId) {
		this.ethnicalPrefId = ethnicalPrefId;
	}
	public int getGenderPrefId() {
		return genderPrefId;
	}
	public void setGenderPrefId(int genderPrefId) {
		this.genderPrefId = genderPrefId;
	}
	public Integer[] getBrandAffId() {
		return brandAffId;
	}
	public void setBrandAffId(Integer[] brandAffId) {
		this.brandAffId = brandAffId;
	}

//	 public String getCategory() {
//		return category;
//	}
//	public void setCategory(String category) {
//		this.category = category;
//	}
//	public String getRegion() {
//		return region;
//	}
//	public void setRegion(String region) {
//		this.region = region;
//	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getAudienceProfileName() {
		return audienceProfileName;
	}
	public void setAudienceProfileName(String audienceProfileName) {
		this.audienceProfileName = audienceProfileName;
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
//	public String getAgePrefName() {
//		return agePrefName;
//	}
//	public void setAgePrefName(String agePrefName) {
//		this.agePrefName = agePrefName;
//	}
//	public String getEthnicalPrefName() {
//		return ethnicalPrefName;
//	}
//	public void setEthnicalPrefName(String ethnicalPrefName) {
//		this.ethnicalPrefName = ethnicalPrefName;
//	}
//	public String getGenderPrefName() {
//		return genderPrefName;
//	}
//	public void setGenderPrefName(String genderPrefName) {
//		this.genderPrefName = genderPrefName;
//	}
//	public String getBrandAffName() {
//		return brandAffName;
//	}
//	public void setBrandAffName(String brandAffName) {
//		this.brandAffName = brandAffName;
//	}
//	public String getAgePref() {
//		return agePref;
//	}
//	public void setAgePref(String agePref) {
//		this.agePref = agePref;
//	}
//	public String getEthnicalPref() {
//		return ethnicalPref;
//	}
//	public void setEthnicalPref(String ethnicalPref) {
//		this.ethnicalPref = ethnicalPref;
//	}
//
//	public String getBrandAff() {
//		return brandAff;
//	}
//	public void setBrandAff(String brandAff) {
//		this.brandAff = brandAff;
//	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public Integer[] getAttributes() {
		return attributes;
	}
	public void setAttributes(Integer[] attributes) {
		this.attributes = attributes;
	}
	public String[] getKeywords() {
		return keywords;
	}
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	public Integer[] getCategoryIds() {
		return categoryIds;
	}
	public void setCategoryIds(Integer[] categoryIds) {
		this.categoryIds = categoryIds;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public ArrayList<Integer> getInfIds() {
		return infIds;
	}
	public void setInfIds(ArrayList<Integer> infIds) {
		this.infIds = infIds;
	}
	public AuditRedirectParams getRedirectParams() {
		return redirectParams;
	}
	public void setRedirectParams(AuditRedirectParams redirectParams) {
		this.redirectParams = redirectParams;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<InfluencerStatus> getInfStausIds() {
		return infStausIds;
	}
	public void setInfStausIds(List<InfluencerStatus> infStausIds) {
		this.infStausIds = infStausIds;
	}

	

}
