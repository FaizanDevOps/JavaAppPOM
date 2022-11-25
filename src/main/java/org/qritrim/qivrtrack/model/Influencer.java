package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class Influencer {

	private int influencerId;
	private int networkId;
	private Integer qritrimInfId;
	private String name;
	private String email;
	private String password;
	private Boolean isTracking;
	private String infId;
	public int getInfluencerId() {
		return influencerId;
	}
	public void setInfluencerId(int influencerId) {
		this.influencerId = influencerId;
	}
	public int getNetworkId() {
		return networkId;
	}
	public void setNetworkId(int networkId) {
		this.networkId = networkId;
	}
	public Integer getQritrimInfId() {
		return qritrimInfId;
	}
	public void setQritrimInfId(Integer qritrimInfId) {
		this.qritrimInfId = qritrimInfId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
