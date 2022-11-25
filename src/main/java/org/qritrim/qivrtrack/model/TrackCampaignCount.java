package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class TrackCampaignCount {
	private int totalCampaigns;
//	private int activeCampaigns;
//	private int campaignsPast;
//	private int awarness;
//	private int engagement;
//	private int sales;
	private int completed;
	private int tracking;
	private int optimizing;
	
	
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	public int getTracking() {
		return tracking;
	}
	public void setTracking(int tracking) {
		this.tracking = tracking;
	}
	public int getOptimizing() {
		return optimizing;
	}
	public void setOptimizing(int optimizing) {
		this.optimizing = optimizing;
	}
	//	
//	public int getAwarness() {
//		return awarness;
//	}
//	public void setAwarness(int awarness) {
//		this.awarness = awarness;
//	}
//	public int getEngagement() {
//		return engagement;
//	}
//	public void setEngagement(int engagement) {
//		this.engagement = engagement;
//	}
//	public int getSales() {
//		return sales;
//	}
//	public void setSales(int sales) {
//		this.sales = sales;
//	}
	public int getTotalCampaigns() {
		return totalCampaigns;
	}
	public void setTotalCampaigns(int totalCampaigns) {
		this.totalCampaigns = totalCampaigns;
	}
//	public int getActiveCampaigns() {
//		return activeCampaigns;
//	}
//	public void setActiveCampaigns(int activeCampaigns) {
//		this.activeCampaigns = activeCampaigns;
//	}
//	public int getCampaignsPast() {
//		return campaignsPast;
//	}
//	public void setCampaignsPast(int campaignsPast) {
//		this.campaignsPast = campaignsPast;
//	}
	
}
