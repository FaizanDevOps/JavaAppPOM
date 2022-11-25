package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class CampaignFilterCount {
	private int id;
	private int campaignId;
	private int engagementMin;
	private int engagementMax;
	private int atsMin;
	private int atsMax;
	private int amsMin;
	private int amsMax;
	private int FollowerMin;
	private int FollowerMax;
	private boolean updated;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public int getEngagementMin() {
		return engagementMin;
	}
	public void setEngagementMin(int engagementMin) {
		this.engagementMin = engagementMin;
	}
	public int getEngagementMax() {
		return engagementMax;
	}
	public void setEngagementMax(int engagementMax) {
		this.engagementMax = engagementMax;
	}
	public int getAtsMin() {
		return atsMin;
	}
	public void setAtsMin(int atsMin) {
		this.atsMin = atsMin;
	}
	public int getAtsMax() {
		return atsMax;
	}
	public void setAtsMax(int atsMax) {
		this.atsMax = atsMax;
	}
	public int getAmsMin() {
		return amsMin;
	}
	public void setAmsMin(int amsMin) {
		this.amsMin = amsMin;
	}
	public int getAmsMax() {
		return amsMax;
	}
	public void setAmsMax(int amsMax) {
		this.amsMax = amsMax;
	}
	public int getFollowerMin() {
		return FollowerMin;
	}
	public void setFollowerMin(int followerMin) {
		FollowerMin = followerMin;
	}
	public int getFollowerMax() {
		return FollowerMax;
	}
	public void setFollowerMax(int followerMax) {
		FollowerMax = followerMax;
	}
	public boolean getUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	
	
	

}
