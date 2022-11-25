package org.qritrim.qivrtrack.model;

import java.sql.Date;
import lombok.Data;

@Data

public class InfCampaignClause {
private int campaignId;
private int sourceInfId;
private int qritrimInfId;
private int userId;
private int agencyId;
private int brandId;
private int clauseId;
private String property;
private Date proposedDate;
private String influencerProposedSolution;
public String getInfluencerProposedSolution() {
	return influencerProposedSolution;
}
public void setInfluencerProposedSolution(String influencerProposedSolution) {
	this.influencerProposedSolution = influencerProposedSolution;
}
public Date getProposedDate() {
	return proposedDate;
}
public void setProposedDate(Date proposedDate) {
	this.proposedDate = proposedDate;
}
public int getCampaignId() {
	return campaignId;
}
public void setCampaignId(int campaignId) {
	this.campaignId = campaignId;
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
public int getBrandId() {
	return brandId;
}
public void setBrandId(int brandId) {
	this.brandId = brandId;
}
public int getClauseId() {
	return clauseId;
}
public void setClauseId(int clauseId) {
	this.clauseId = clauseId;
}
public String getProperty() {
	return property;
}
public void setProperty(String property) {
	this.property = property;
}


}
