package org.qritrim.qivrtrack.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ActivityLog {

	private int logId;
//	private int clauseId;
	private String property;
	private String comments;
	private Timestamp created;
	private int agencyId;
	private int brandId;
	private int userId;
	private int sourceInfId;
	private String fromId;
	private String toId;
	private int infCampaignClauseId;
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
//	public int getClauseId() {
//		return clauseId;
//	}
//	public void setClauseId(int clauseId) {
//		this.clauseId = clauseId;
//	}
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
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
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
	public int getSourceInfId() {
		return sourceInfId;
	}
	public void setSourceInfId(int sourceInfId) {
		this.sourceInfId = sourceInfId;
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
	public int getInfCampaignClauseId() {
		return infCampaignClauseId;
	}
	public void setInfCampaignClauseId(int infCampaignClauseId) {
		this.infCampaignClauseId = infCampaignClauseId;
	}
	
	
}
