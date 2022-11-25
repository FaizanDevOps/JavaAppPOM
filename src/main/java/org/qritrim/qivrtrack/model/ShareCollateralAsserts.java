package org.qritrim.qivrtrack.model;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class ShareCollateralAsserts {
  private int shareCollateralId;
  private int campaignId;
  private int sourceInfId;
 // private List<Integer> influencerId;
  private int userId;
  private String uploadedBy;
  private String assertName;
  private String assertId;
  private String assertUrl;
  private String assertType;
  private int statusId;
 private Timestamp assertCreatedAt;
 private int agencyId;
 private String property;
 private String notes;
 

 
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
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
public int getShareCollateralId() {
	return shareCollateralId;
}
public void setShareCollateralId(int shareCollateralId) {
	this.shareCollateralId = shareCollateralId;
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
public String getUploadedBy() {
	return uploadedBy;
}
public void setUploadedBy(String uploadedBy) {
	this.uploadedBy = uploadedBy;
}
public String getAssertName() {
	return assertName;
}
public void setAssertName(String assertName) {
	this.assertName = assertName;
}
public String getAssertId() {
	return assertId;
}
public void setAssertId(String assertId) {
	this.assertId = assertId;
}
public String getAssertUrl() {
	return assertUrl;
}
public void setAssertUrl(String assertUrl) {
	this.assertUrl = assertUrl;
}
public String getAssertType() {
	return assertType;
}
public void setAssertType(String assertType) {
	this.assertType = assertType;
}
public int getStatusId() {
	return statusId;
}
public void setStatusId(int statusId) {
	this.statusId = statusId;
}
public Timestamp getAssertCreatedAt() {
	return assertCreatedAt;
}
public void setAssertCreatedAt(Timestamp assertCreatedAt) {
	this.assertCreatedAt = assertCreatedAt;
}
public int getSourceInfId() {
	return sourceInfId;
}
public void setSourceInfId(int sourceInfId) {
	this.sourceInfId = sourceInfId;
}
//public List<Integer> getInfluencerId() {
//	return influencerId;
//}
//public void setInfluencerId(List<Integer> influencerId) {
//	this.influencerId = influencerId;
//}


}
