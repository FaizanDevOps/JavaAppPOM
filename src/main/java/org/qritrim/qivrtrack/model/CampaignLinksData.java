package org.qritrim.qivrtrack.model;

import java.util.HashMap;

import lombok.Data;
@Data
public class CampaignLinksData {

		private int campaignLinksId;
		private int campaignId;
		private int sourceInfId;
		private int userId;
		private String uploadedBy;
		private HashMap<Integer,String[]> networkIdAndLink;
		private int agencyId;
		private String campaignLinkNetworks;
		
		
	
		
		public String getCampaignLinkNetworks() {
			return campaignLinkNetworks;
		}
		public void setCampaignLinkNetworks(String campaignLinkNetworks) {
			this.campaignLinkNetworks = campaignLinkNetworks;
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
		public int getSourceInfId() {
			return sourceInfId;
		}
		public int getCampaignLinksId() {
			return campaignLinksId;
		}
		public void setCampaignLinksId(int campaignLinksId) {
			this.campaignLinksId = campaignLinksId;
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
		public HashMap<Integer, String[]> getNetworkIdAndLink() {
			return networkIdAndLink;
		}
		public void setNetworkIdAndLink(HashMap<Integer, String[]> networkIdAndLink) {
			this.networkIdAndLink = networkIdAndLink;
		}
		
		
}
