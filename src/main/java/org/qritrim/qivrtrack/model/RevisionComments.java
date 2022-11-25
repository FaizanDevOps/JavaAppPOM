package org.qritrim.qivrtrack.model;

import java.sql.Timestamp;
import lombok.Data;

@Data

public class RevisionComments {
private int shareCollateralId;
private int statusId;
private int userId;
private int sourceInfId;
private String property;
private String comments;
private int agencyId;
private int brandId;
private String fromId;
private String toId;
private String approve;
private Timestamp commentCreated;
private int campaignId;
private int commentsId;

public int getCommentsId() {
	return commentsId;
}
public void setCommentsId(int commentsId) {
	this.commentsId = commentsId;
}
public int getCampaignId() {
	return campaignId;
}
public void setCampaignId(int campaignId) {
	this.campaignId = campaignId;
}
public Timestamp getCommentCreated() {
	return commentCreated;
}
public void setCommentCreated(Timestamp commentCreated) {
	this.commentCreated = commentCreated;
}
public String getApprove() {
	return approve;
}
public void setApprove(String approve) {
	this.approve = approve;
}
public String getFromId() {
	return fromId;
}
public void setFromId(String fromId) {
	this.fromId = fromId;
}
public String getToId() {
	return toId;
}
public void setToId(String toId) {
	this.toId = toId;
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
public int getShareCollateralId() {
	return shareCollateralId;
}
public void setShareCollateralId(int shareCollateralId) {
	this.shareCollateralId = shareCollateralId;
}
public int getStatusId() {
	return statusId;
}
public void setStatusId(int statusId) {
	this.statusId = statusId;
}

public String getProperty() {
	return property;
}
public void setProperty(String property) {
	this.property = property;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
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
}
