package org.qritrim.qivrtrack.model;

import java.util.List;

import lombok.Data;

@Data

public class CampaignLinks {
	private int campaignLinksId;
	private int campaignId;
	private int sourceInfId;
	private int userId;
	private String uploadedBy;
	private String[] links;
	private String campaignLinkNetworks;
	
	
	

	public String getCampaignLinkNetworks() {
		return campaignLinkNetworks;
	}

	public void setCampaignLinkNetworks(String campaignLinkNetworks) {
		this.campaignLinkNetworks = campaignLinkNetworks;
	}

	private int agencyId;
public int getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	//private String campaignLinkNetworks;
	private int networkId;

	public int getNetworkId() {
		return networkId;
	}

	public String[] getLinks() {
		return links;
	}

	public void setLinks(String[] links) {
		this.links = links;
	}

	public void setNetworkId(int networkId) {
		this.networkId = networkId;
	}

	public int getCampaignLinksId() {
		return campaignLinksId;
	}

	public void setCampaignLinksId(int campaignLinksId) {
		this.campaignLinksId = campaignLinksId;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public int getSourceInfId() {
		return sourceInfId;
	}

	public void setSourceInfId(int sourceInfId) {
		this.sourceInfId = sourceInfId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

}
