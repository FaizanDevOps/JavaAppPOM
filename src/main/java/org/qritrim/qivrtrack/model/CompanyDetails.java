package org.qritrim.qivrtrack.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class CompanyDetails {
    private int brandId;
	private int campaignId;
	private String brandName;
	private String campaignName;
	private String objective;
	private String category;
	private InfluencersEngaged influencers;
	private String networks;
	private String created;
	private int categoryId;
	private int objId;
	private ArrayList<Integer> infIds;
	private Integer[] campaignCategory;
	private int campaignStatus;
	
public String getNetworks() {
		return networks;
	}
	public String getCreated() {
	return created;
}
public void setCreated(String created) {
	this.created = created;
}
	public void setNetworks(String networks) {
		this.networks = networks;
	}
public InfluencersEngaged getInfluencers() {
		return influencers;
	}
	public void setInfluencers(InfluencersEngaged influencers) {
		this.influencers = influencers;
	}
	//	private String influencers;
//	private String imageUrls;
//	private String networks;
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public int getCampaignId() {
		return campaignId;
	}
	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getObjId() {
		return objId;
	}
	public void setObjId(int objId) {
		this.objId = objId;
	}
	public ArrayList<Integer> getInfIds() {
		return infIds;
	}
	public void setInfIds(ArrayList<Integer> infIds) {
		this.infIds = infIds;
	}
	public Integer[] getCampaignCategory() {
		return campaignCategory;
	}
	public void setCampaignCategory(Integer[] campaignCategory) {
		this.campaignCategory = campaignCategory;
	}
	public int getCampaignStatus() {
		return campaignStatus;
	}
	public void setCampaignStatus(int campaignStatus) {
		this.campaignStatus = campaignStatus;
	}
	


}
