package org.qritrim.qivrtrack.model;

import lombok.Data;
@Data
public class Conversion {
	private int agency_id;
	private String agencyname;
	private int brand_id;
	private String campaignName;
	//private CampaignTimeLine[] campaignTimeLine;
	private String CampaignTimeLine;
	private int campaign_id;
	private int campaign_status_id;
	private int campaign_type_id;
	private Integer[] category;
	public Integer[] getCategory() {
		return category;
	}
	public void setCategory(Integer[] category) {
		this.category = category;
	}
	private String created;
	private String imageUrl;
	private String infName;
	private String inf_sealed_at;
	private String inf_terms_accepted_at;
	private boolean is_inf_seal_accepted;
	private boolean is_inf_terms_accepted;
	private boolean is_obj_defined;
	private boolean is_u_seal_accepted;
	private boolean is_u_terms_accepted;
	public boolean isIs_u_terms_accepted() {
		return is_u_terms_accepted;
	}
	public void setIs_u_terms_accepted(boolean is_u_terms_accepted) {
		this.is_u_terms_accepted = is_u_terms_accepted;
	}
	private int objective;
	private String  preamble_id;
	private String preamble_uploaded_at;
	private String preamble_url;
	private int qritrim_inf_id;
	private int source_inf_id;
	private String sow_path;
	private int status_id;
	private Integer[] targetRegions;
	private InfEmailThread[] thread;
	private int threadId;
	private String u_sealed_at;
	private String u_terms_accepted_at;
	private String brandName;
	private String brandurl;
	private boolean inf_invitation_accepted;
	private int user_id;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public boolean isInf_invitation_accepted() {
		return inf_invitation_accepted;
	}
	public void setInf_invitation_accepted(boolean inf_invitation_accepted) {
		this.inf_invitation_accepted = inf_invitation_accepted;
	}
	public int getAgency_id() {
		return agency_id;
	}
	public void setAgency_id(int agency_id) {
		this.agency_id = agency_id;
	}
	public String getAgencyname() {
		return agencyname;
	}
	public void setAgencyname(String agencyname) {
		this.agencyname = agencyname;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getCampaignName() {
		return campaignName;
	}
	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	
	public String getCampaignTimeLine() {
		return CampaignTimeLine;
	}
	public void setCampaignTimeLine(String campaignTimeLine) {
		CampaignTimeLine = campaignTimeLine;
	}
	public int getCampaign_id() {
		return campaign_id;
	}
	public void setCampaign_id(int campaign_id) {
		this.campaign_id = campaign_id;
	}
	public int getCampaign_status_id() {
		return campaign_status_id;
	}
	public void setCampaign_status_id(int campaign_status_id) {
		this.campaign_status_id = campaign_status_id;
	}
	public int getCampaign_type_id() {
		return campaign_type_id;
	}
	public void setCampaign_type_id(int campaign_type_id) {
		this.campaign_type_id = campaign_type_id;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getInfName() {
		return infName;
	}
	public void setInfName(String infName) {
		this.infName = infName;
	}
	public String getInf_sealed_at() {
		return inf_sealed_at;
	}
	public void setInf_sealed_at(String inf_sealed_at) {
		this.inf_sealed_at = inf_sealed_at;
	}
	public String getInf_terms_accepted_at() {
		return inf_terms_accepted_at;
	}
	public void setInf_terms_accepted_at(String inf_terms_accepted_at) {
		this.inf_terms_accepted_at = inf_terms_accepted_at;
	}
	public boolean isIs_inf_seal_accepted() {
		return is_inf_seal_accepted;
	}
	public void setIs_inf_seal_accepted(boolean is_inf_seal_accepted) {
		this.is_inf_seal_accepted = is_inf_seal_accepted;
	}
	public boolean isIs_inf_terms_accepted() {
		return is_inf_terms_accepted;
	}
	public void setIs_inf_terms_accepted(boolean is_inf_terms_accepted) {
		this.is_inf_terms_accepted = is_inf_terms_accepted;
	}
	public boolean isIs_obj_defined() {
		return is_obj_defined;
	}
	public void setIs_obj_defined(boolean is_obj_defined) {
		this.is_obj_defined = is_obj_defined;
	}
	public boolean isIs_u_seal_accepted() {
		return is_u_seal_accepted;
	}
	public void setIs_u_seal_accepted(boolean is_u_seal_accepted) {
		this.is_u_seal_accepted = is_u_seal_accepted;
	}
	public int getObjective() {
		return objective;
	}
	public void setObjective(int objective) {
		this.objective = objective;
	}
	public String getPreamble_id() {
		return preamble_id;
	}
	public void setPreamble_id(String preamble_id) {
		this.preamble_id = preamble_id;
	}
	
	public String getPreamble_url() {
		return preamble_url;
	}
	public void setPreamble_url(String preamble_url) {
		this.preamble_url = preamble_url;
	}
	public int getQritrim_inf_id() {
		return qritrim_inf_id;
	}
	public void setQritrim_inf_id(int qritrim_inf_id) {
		this.qritrim_inf_id = qritrim_inf_id;
	}
	public int getSource_inf_id() {
		return source_inf_id;
	}
	public void setSource_inf_id(int source_inf_id) {
		this.source_inf_id = source_inf_id;
	}
	public String getSow_path() {
		return sow_path;
	}
	public void setSow_path(String sow_path) {
		this.sow_path = sow_path;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public Integer[] getTargetRegions() {
		return targetRegions;
	}
	public void setTargetRegions(Integer[] targetRegions) {
		this.targetRegions = targetRegions;
	}
	public InfEmailThread[] getThread() {
		return thread;
	}
	public void setThread(InfEmailThread[] thread) {
		this.thread = thread;
	}
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}
	
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getPreamble_uploaded_at() {
		return preamble_uploaded_at;
	}
	public void setPreamble_uploaded_at(String preamble_uploaded_at) {
		this.preamble_uploaded_at = preamble_uploaded_at;
	}
	public String getU_sealed_at() {
		return u_sealed_at;
	}
	public void setU_sealed_at(String u_sealed_at) {
		this.u_sealed_at = u_sealed_at;
	}
	public String getU_terms_accepted_at() {
		return u_terms_accepted_at;
	}
	public void setU_terms_accepted_at(String u_terms_accepted_at) {
		this.u_terms_accepted_at = u_terms_accepted_at;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandurl() {
		return brandurl;
	}
	public void setBrandurl(String brandurl) {
		this.brandurl = brandurl;
	}
	
}
