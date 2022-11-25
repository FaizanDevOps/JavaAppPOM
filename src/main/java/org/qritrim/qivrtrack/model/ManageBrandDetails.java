package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class ManageBrandDetails {
private int activeCampaigns;
private int brandsOnboarded;
private int influencersEngaged;
private int noOfCampaigns;
public int getActiveCampaigns() {
	return activeCampaigns;
}
public void setActiveCampaigns(int activeCampaigns) {
	this.activeCampaigns = activeCampaigns;
}
public int getBrandsOnboarded() {
	return brandsOnboarded;
}
public void setBrandsOnboarded(int brandsOnboarded) {
	this.brandsOnboarded = brandsOnboarded;
}
public int getInfluencersEngaged() {
	return influencersEngaged;
}
public void setInfluencersEngaged(int influencersEngaged) {
	this.influencersEngaged = influencersEngaged;
}
public int getNoOfCampaigns() {
	return noOfCampaigns;
}
public void setNoOfCampaigns(int noOfCampaigns) {
	this.noOfCampaigns = noOfCampaigns;
}

}
