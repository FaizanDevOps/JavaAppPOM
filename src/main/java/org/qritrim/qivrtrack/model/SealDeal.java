package org.qritrim.qivrtrack.model;

import java.sql.Timestamp;

import java.util.List;
import lombok.Data;

@Data
public class SealDeal {
private int campaignId;
private Timestamp campaignCreatedDate;
private Timestamp discussionStarted;
private Timestamp influencerContacted;
private Timestamp objInfluencerAgreed;
private Timestamp objAgencyConfirmed;
private Timestamp termsInfluencerAgreed;
private Timestamp termsAgencyConfirmed;
private Timestamp LastInvitedDate;
private int influencersInvited;
private List<clauses> clausesAccepted;
private int influencerEngagementId;
private String termsAccepted;
private String campaignName;
private String campaignCreated;
private boolean campaignActivated;
private String brand;
private String audienceProfile;
private String budget;
private CampaignCreate campaignSummary;

public CampaignCreate getCampaignSummary() {
	return campaignSummary;
}
public void setCampaignSummary(CampaignCreate campaignSummary) {
	this.campaignSummary = campaignSummary;
}
public boolean isCampaignActivated() {
	return campaignActivated;
}
public void setCampaignActivated(boolean campaignActivated) {
	this.campaignActivated = campaignActivated;
}
public Timestamp getCampaignCreatedDate() {
	return campaignCreatedDate;
}
public void setCampaignCreatedDate(Timestamp campaignCreatedDate) {
	this.campaignCreatedDate = campaignCreatedDate;
}
public String getCampaignName() {
	return campaignName;
}
public void setCampaignName(String campaignName) {
	this.campaignName = campaignName;
}
public String getCampaignCreated() {
	return campaignCreated;
}
public void setCampaignCreated(String campaignCreated) {
	this.campaignCreated = campaignCreated;
}
public Timestamp getDiscussionStarted() {
	return discussionStarted;
}
public void setDiscussionStarted(Timestamp discussionStarted) {
	this.discussionStarted = discussionStarted;
}
public Timestamp getLastInvitedDate() {
	return LastInvitedDate;
}
public void setLastInvitedDate(Timestamp lastInvitedDate) {
	LastInvitedDate = lastInvitedDate;
}
public int getInfluencersInvited() {
	return influencersInvited;
}
public void setInfluencersInvited(int influencersInvited) {
	this.influencersInvited = influencersInvited;
}
public int getCampaignId() {
	return campaignId;
}
public void setCampaignId(int campaignId) {
	this.campaignId = campaignId;
}

public Timestamp getInfluencerContacted() {
	return influencerContacted;
}
public void setInfluencerContacted(Timestamp influencerContacted) {
	this.influencerContacted = influencerContacted;
}
public Timestamp getObjInfluencerAgreed() {
	return objInfluencerAgreed;
}
public void setObjInfluencerAgreed(Timestamp objInfluencerAgreed) {
	this.objInfluencerAgreed = objInfluencerAgreed;
}
public Timestamp getObjAgencyConfirmed() {
	return objAgencyConfirmed;
}
public void setObjAgencyConfirmed(Timestamp objAgencyConfirmed) {
	this.objAgencyConfirmed = objAgencyConfirmed;
}
public Timestamp getTermsInfluencerAgreed() {
	return termsInfluencerAgreed;
}
public void setTermsInfluencerAgreed(Timestamp termsInfluencerAgreed) {
	this.termsInfluencerAgreed = termsInfluencerAgreed;
}
public Timestamp getTermsAgencyConfirmed() {
	return termsAgencyConfirmed;
}
public void setTermsAgencyConfirmed(Timestamp termsAgencyConfirmed) {
	this.termsAgencyConfirmed = termsAgencyConfirmed;
}
public List<clauses> getClausesAccepted() {
	return clausesAccepted;
}
public void setClausesAccepted(List<clauses> clausesAccepted) {
	this.clausesAccepted = clausesAccepted;
}
public int getInfluencerEngagementId() {
	return influencerEngagementId;
}
public void setInfluencerEngagementId(int influencerEngagementId) {
	this.influencerEngagementId = influencerEngagementId;
}
public String getTermsAccepted() {
	return termsAccepted;
}
public void setTermsAccepted(String termsAccepted) {
	this.termsAccepted = termsAccepted;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getAudienceProfile() {
	return audienceProfile;
}
public void setAudienceProfile(String audienceProfile) {
	this.audienceProfile = audienceProfile;
}
public String getBudget() {
	return budget;
}
public void setBudget(String budget) {
	this.budget = budget;
}




}
