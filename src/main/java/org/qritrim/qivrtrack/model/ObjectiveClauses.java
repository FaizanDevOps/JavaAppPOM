package org.qritrim.qivrtrack.model;

import java.sql.Date;
import lombok.Data;

@Data


public class ObjectiveClauses {
private int clauseId;
private String clauseName;
private String clauseDescription;
private int campaignClauseTypeId;
private int clauseBudget;
private int agencyId;
private int brandId;
private int userId;
private Boolean reviewed;
private String property;
private String influencerSolution;
private Date proposedDate;
private Boolean isUserAccepted;
private Boolean isInfAccepted;
private String userAcceptedDate;
private String influencerAcceptedDate;
private String campaignClauseTypeName;
private int activityLogCounts;
private int infCampaignClauseid;
private int objectiveKpiId;
private int kpiTarget;
public int getObjectiveKpiId() {
	return objectiveKpiId;
}
public void setObjectiveKpiId(int objectiveKpiId) {
	this.objectiveKpiId = objectiveKpiId;
}
public int getKpiTarget() {
	return kpiTarget;
}
public void setKpiTarget(int kpiTarget) {
	this.kpiTarget = kpiTarget;
}
public String getUserAcceptedDate() {
	return userAcceptedDate;
}
public void setUserAcceptedDate(String userAcceptedDate) {
	this.userAcceptedDate = userAcceptedDate;
}
public String getInfluencerAcceptedDate() {
	return influencerAcceptedDate;
}
public void setInfluencerAcceptedDate(String influencerAcceptedDate) {
	this.influencerAcceptedDate = influencerAcceptedDate;
}
public String getInfluencerSolution() {
	return influencerSolution;
}
public void setInfluencerSolution(String influencerSolution) {
	this.influencerSolution = influencerSolution;
}
public int getInfCampaignClauseid() {
	return infCampaignClauseid;
}
public void setInfCampaignClauseid(int infCampaignClauseid) {
	this.infCampaignClauseid = infCampaignClauseid;
}
public int getActivityLogCounts() {
	return activityLogCounts;
}
public void setActivityLogCounts(int activityLogCounts) {
	this.activityLogCounts = activityLogCounts;
}
public Boolean getReviewed() {
	return reviewed;
}
public void setReviewed(Boolean reviewed) {
	this.reviewed = reviewed;
}




public Boolean getIsUserAccepted() {
	return isUserAccepted;
}
public void setIsUserAccepted(Boolean isUserAccepted) {
	this.isUserAccepted = isUserAccepted;
}
public Boolean getIsInfAccepted() {
	return isInfAccepted;
}
public void setIsInfAccepted(Boolean isInfAccepted) {
	this.isInfAccepted = isInfAccepted;
}
public Date getProposedDate() {
	return proposedDate;
}
public void setProposedDate(Date proposedDate) {
	this.proposedDate = proposedDate;
}


public String getCampaignClauseTypeName() {
	return campaignClauseTypeName;
}
public void setCampaignClauseTypeName(String campaignClauseTypeName) {
	this.campaignClauseTypeName = campaignClauseTypeName;
}
public int getAgencyId() {
	return agencyId;
}
public void setAgencyId(int agencyId) {
	this.agencyId = agencyId;
}
public int getBrandId() {
	return brandId;
}
public void setBrandId(int brandId) {
	this.brandId = brandId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getProperty() {
	return property;
}
public void setProperty(String property) {
	this.property = property;
}
public int getCampaignClauseTypeId() {
	return campaignClauseTypeId;
}
public void setCampaignClauseTypeId(int campaignClauseTypeId) {
	this.campaignClauseTypeId = campaignClauseTypeId;
}
public int getClauseId() {
	return clauseId;
}
public void setClauseId(int clauseId) {
	this.clauseId = clauseId;
}
public String getClauseName() {
	return clauseName;
}
public void setClauseName(String clauseName) {
	this.clauseName = clauseName;
}
public String getClauseDescription() {
	return clauseDescription;
}
public void setClauseDescription(String clauseDescription) {
	this.clauseDescription = clauseDescription;
}

public int getClauseBudget() {
	return clauseBudget;
}
public void setClauseBudget(int clauseBudget) {
	this.clauseBudget = clauseBudget;
}

}
