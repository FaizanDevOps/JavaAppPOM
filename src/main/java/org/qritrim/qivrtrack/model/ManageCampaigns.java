package org.qritrim.qivrtrack.model;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;

@Data
public class ManageCampaigns {
	private int campaignId;
	private String campaignName;
	private int statusId;
	private int objectiveId;
	private int catergoryId;
	private Integer[] networkId;
//private String status;
//private String categories;
//private Integer[] categoryIds;

//private ArrayList<Integer> infIds;
//private ArrayList<HashMap<String, Integer>> infIdsStatus;

	private int influencersInvited;

	

	public int getCatergoryId() {
		return catergoryId;
	}

	public void setCatergoryId(int catergoryId) {
		this.catergoryId = catergoryId;
	}

	public int getObjectiveId() {
		return objectiveId;
	}

	public void setObjectiveId(int objectiveId) {
		this.objectiveId = objectiveId;
	}

//private String[] brandList;
	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
//private String brand;
//private InfluencersEngaged influencers;

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getNetworks() {
		return networks;
	}

	public void setNetworks(String networks) {
		this.networks = networks;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	private String networks;
	private String created;

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Integer[] getNetworkId() {
		return networkId;
	}

	public void setNetworkId(Integer[] networkId) {
		this.networkId = networkId;
	}

	public int getInfluencersInvited() {
		return influencersInvited;
	}

	public void setInfluencersInvited(int influencersInvited) {
		this.influencersInvited = influencersInvited;
	}

	
}
