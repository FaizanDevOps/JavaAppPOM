package org.qritrim.qivrtrack.model;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class InfluencerEngagement {

	private int infEngId;
	private int sourceInfId;
	private int campaignId;
	private int statusId;
	private String createdBy;
	private String updatedBy;
	private Timestamp created;
	private Timestamp updated;
	private int userId;
	private String preambleId;
	public String getPreambleId() {
		return preambleId;
	}
	public void setPreambleId(String preambleId) {
		this.preambleId = preambleId;
	}
	private String preambleUrl;
	private Timestamp preambleUploadedAt;
	private int kpi;
	private int target;
	private int budget;
	private String sowId;
	private String sowUrl;
	private Boolean isKpiAccepted;
	private Boolean isSowAccepted;
	private Boolean isPreambleAccepted;
	private Boolean isInviteAccepted;
	private String agencyName;
	
	public int getInfEngId() {
		return infEngId;
	}
	public void setInfEngId(int infEngId) {
		this.infEngId = infEngId;
	}
	public int getSourceInfId() {
		return sourceInfId;
	}
	public void setSourceInfId(int sourceInfId) {
		this.sourceInfId = sourceInfId;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int user_id) {
		this.userId = user_id;
	}
	public String getPreambleUrl() {
		return preambleUrl;
	}
	public void setPreambleUrl(String preambleUrl) {
		this.preambleUrl = preambleUrl;
	}
	public Timestamp getPreambleUploadedAt() {
		return preambleUploadedAt;
	}
	public void setPreambleUploadedAt(Timestamp preambleUploadedAt) {
		this.preambleUploadedAt = preambleUploadedAt;
	}
	public int getKpi() {
		return kpi;
	}
	public void setKpi(int kpi) {
		this.kpi = kpi;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	public String getSowId() {
		return sowId;
	}
	public void setSowId(String sowId) {
		this.sowId = sowId;
	}
	public String getSowUrl() {
		return sowUrl;
	}
	public void setSowUrl(String sowUrl) {
		this.sowUrl = sowUrl;
	}
	public Boolean getIsKpiAccepted() {
		return isKpiAccepted;
	}
	public void setIsKpiAccepted(Boolean isKpiAccepted) {
		this.isKpiAccepted = isKpiAccepted;
	}
	public Boolean getIsSowAccepted() {
		return isSowAccepted;
	}
	public void setIsSowAccepted(Boolean isSowAccepted) {
		this.isSowAccepted = isSowAccepted;
	}
	public Boolean getIsPreambleAccepted() {
		return isPreambleAccepted;
	}
	public void setIsPreambleAccepted(Boolean isPreambleAccepted) {
		this.isPreambleAccepted = isPreambleAccepted;
	}
	public Boolean getIsInviteAccepted() {
		return isInviteAccepted;
	}
	public void setIsInviteAccepted(Boolean isInviteAccepted) {
		this.isInviteAccepted = isInviteAccepted;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	
	
}
