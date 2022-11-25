package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class CampaignDetails {
	private String campaignName;
	private int campaignId;
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	
}
