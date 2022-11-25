package org.qritrim.qivrtrack.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class EmailThreadRequest {
	private ArrayList<Influencer> influencers;
	private int brandId;
	private int agencyId;
	private int campaignId;
	private int userId;
	private String msg;
	public ArrayList<Influencer> getInfluencers() {
		return influencers;
	}
	public void setInfluencers(ArrayList<Influencer> influencers) {
		this.influencers = influencers;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
