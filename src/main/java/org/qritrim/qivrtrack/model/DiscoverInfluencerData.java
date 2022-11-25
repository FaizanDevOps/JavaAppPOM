package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class DiscoverInfluencerData {
  private String influencerId;
  private String name;
  private String profilePictureUrl;
  private String country;
  private String email;
  private Integer [] networkId;
public String getInfluencerId() {
	return influencerId;
}
public void setInfluencerId(String influencerId) {
	this.influencerId = influencerId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getProfilePictureUrl() {
	return profilePictureUrl;
}
public void setProfilePictureUrl(String profilePictureUrl) {
	this.profilePictureUrl = profilePictureUrl;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer[] getNetworkId() {
	return networkId;
}
public void setNetworkId(Integer[] networkId) {
	this.networkId = networkId;
}
}
