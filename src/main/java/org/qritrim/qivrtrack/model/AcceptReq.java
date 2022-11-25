package org.qritrim.qivrtrack.model;

import java.sql.Date;

import lombok.Data;

@Data
public class AcceptReq {
	private int infCampaignClauseId;
	private int clauseId;
	private int campaignId;
	private int userId;
	private int sourceInfId;
	private int qritrimInfId;
	private String property;
	private String clauseDescription;
	private int agencyId;
	private int brandId;
	private Boolean isUserAccepted;
	private Boolean isInfAccepted;
	private String userAcceptedDate;
	private String influencerAcceptedDate;
	private Date proposedDate;
	private String influencerSolution;
	private int campaignClauseTypeId;
	private int clauseBudget;
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
	public String getInfluencerAcceptedDate() {
		return influencerAcceptedDate;
	}
	public void setInfluencerAcceptedDate(String influencerAcceptedDate) {
		this.influencerAcceptedDate = influencerAcceptedDate;
	}
	public String getUserAcceptedDate() {
		return userAcceptedDate;
	}
	public void setUserAcceptedDate(String userAcceptedDate) {
		this.userAcceptedDate = userAcceptedDate;
	}
	
	public int getCampaignClauseTypeId() {
		return campaignClauseTypeId;
	}
	public void setCampaignClauseTypeId(int campaignClauseTypeId) {
		this.campaignClauseTypeId = campaignClauseTypeId;
	}

	public int getClauseBudget() {
		return clauseBudget;
	}
	public void setClauseBudget(int clauseBudget) {
		this.clauseBudget = clauseBudget;
	}
	public Date getProposedDate() {
		return proposedDate;
	}
	public void setProposedDate(Date proposedDate) {
		this.proposedDate = proposedDate;
	}
	public String getInfluencerSolution() {
		return influencerSolution;
	}
	public void setInfluencerSolution(String influencerSolution) {
		this.influencerSolution = influencerSolution;
	}
	public int getInfCampaignClauseId() {
		return infCampaignClauseId;
	}
	public void setInfCampaignClauseId(int infCampaignClauseId) {
		this.infCampaignClauseId = infCampaignClauseId;
	}
	public int getClauseId() {
		return clauseId;
	}
	public void setClauseId(int clauseId) {
		this.clauseId = clauseId;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSourceInfId() {
		return sourceInfId;
	}
	public void setSourceInfId(int sourceInfId) {
		this.sourceInfId = sourceInfId;
	}
	public int getQritrimInfId() {
		return qritrimInfId;
	}
	public void setQritrimInfId(int qritrimInfId) {
		this.qritrimInfId = qritrimInfId;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
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
	public String getClauseDescription() {
		return clauseDescription;
	}
	public void setClauseDescription(String clauseDescription) {
		this.clauseDescription = clauseDescription;
	}

}


