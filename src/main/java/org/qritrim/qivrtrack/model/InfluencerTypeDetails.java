package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class InfluencerTypeDetails {

	private int campaignTypeId;
	private int influencerTypeId;
	private Integer [] attributesId;
	private String sowPath;
	private int audienceProfileId;
	private String [] keywords;
	private String audienceProfileName;
	private Integer [] agePrefId;
	private Integer [] ethnicalPrefId;
	private int genderPrefId;
	private Integer [] brandAffId;
	private boolean canShare;
	private int agencyId;
	private int campaignId;
	private String audienceProfile;
//	private String agePrefNames;
//	private String ethnicalPrefName;
//	private String brandAffName;
//	private String genderName;
//	private String agePref;
//	private String ethnicalPref;
//	private String brandAff;
	private int campaignInfProfileId;
	private String keywordsTags;
	private String audienceProfileSummary;
	public String getAudienceProfileSummary() {
		return audienceProfileSummary;
	}
	public void setAudienceProfileSummary(String audienceProfileSummary) {
		this.audienceProfileSummary = audienceProfileSummary;
	}
	public String getKeywordsTags() {
		return keywordsTags;
	}
	public void setKeywordsTags(String keywordsTags) {
		this.keywordsTags = keywordsTags;
	}
	public int getCampaignInfProfileId() {
		return campaignInfProfileId;
	}
	public void setCampaignInfProfileId(int campaignInfProfileId) {
		this.campaignInfProfileId = campaignInfProfileId;
	}
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
//	public String getBrandAff() {
//		return brandAff;
//	}
//	public void setBrandAff(String brandAff) {
//		this.brandAff = brandAff;
//	}
//	public String getAgePrefNames() {
//		return agePrefNames;
//	}
//	public void setAgePrefNames(String agePrefNames) {
//		this.agePrefNames = agePrefNames;
//	}
//	public String getEthnicalPrefName() {
//		return ethnicalPrefName;
//	}
//	public void setEthnicalPrefName(String ethnicalPrefName) {
//		this.ethnicalPrefName = ethnicalPrefName;
//	}
//	public String getBrandAffName() {
//		return brandAffName;
//	}
//	public void setBrandAffName(String brandAffName) {
//		this.brandAffName = brandAffName;
//	}
//	public String getGenderName() {
//		return genderName;
//	}
//	public void setGenderName(String genderName) {
//		this.genderName = genderName;
//	}
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
	public Integer[] getAttributesId() {
		return attributesId;
	}
	public void setAttributesId(Integer[] attributesId) {
		this.attributesId = attributesId;
	}
	public String getSowPath() {
		return sowPath;
	}
	public void setSowPath(String sowPath) {
		this.sowPath = sowPath;
	}
	public int getAudienceProfileId() {
		return audienceProfileId;
	}
	public void setAudienceProfileId(int audienceProfileId) {
		this.audienceProfileId = audienceProfileId;
	}
	public String[] getKeywords() {
		return keywords;
	}
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	public String getAudienceProfileName() {
		return audienceProfileName;
	}
	public void setAudienceProfileName(String audienceProfileName) {
		this.audienceProfileName = audienceProfileName;
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
	public boolean isCanShare() {
		return canShare;
	}
	public void setCanShare(boolean canShare) {
		this.canShare = canShare;
	}
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public String getAudienceProfile() {
		return audienceProfile;
	}
	public void setAudienceProfile(String audienceProfile) {
		this.audienceProfile = audienceProfile;
	}
	
	
}
