package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class CampaignTypeStatus {
	private int statusId;
	private int campaignTypeId;
	private int sourceInfId;
	public int getSourceInfId() {
		return sourceInfId;
	}
	public void setSourceInfId(int sourceInfId) {
		this.sourceInfId = sourceInfId;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public int getCampaignTypeId() {
		return campaignTypeId;
	}
	public void setCampaignTypeId(int campaignTypeId) {
		this.campaignTypeId = campaignTypeId;
	}
	
}
