package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class PostLinks {
	String campaignName;
	int campaignId;
	String timeLine;
	int influencerId;
	String campaignLink;
	int agencyId;
	int budget;
	int objectiveId;
	String objectiveName;
	
	
	public String getObjectiveName() {
		return objectiveName;
	}
	public void setObjectiveName(String objectiveName) {
		this.objectiveName = objectiveName;
	}
	public int getObjectiveId() {
		return objectiveId;
	}
	public void setObjectiveId(int objectiveId) {
		this.objectiveId = objectiveId;
	}
	
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	
	public String getTimeLine() {
		return timeLine;
	}
	public void setTimeLine(String timeLine) {
		this.timeLine = timeLine;
	}
	
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public int getInfluencerId() {
		return influencerId;
	}
	public void setInfluencerId(int influencerId) {
		this.influencerId = influencerId;
	}
	public String getCampaignLink() {
		return campaignLink;
	}
	public void setCampaignLink(String campaignLink) {
		this.campaignLink = campaignLink;
	}
	
}
