package org.qritrim.qivrtrack.model;

import java.sql.Timestamp;

public class SaveList {
	private int id;
	private String listName;
	private Timestamp createdOn;
	private String[] infIds;
	private int agencyId;
	private int influencerCount;
	
	
	
	public int getInfluencerCount() {
		return influencerCount;
	}
	public void setInfluencerCount(int influencerCount) {
		this.influencerCount = influencerCount;
	}
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public String[] getInfIds() {
		return infIds;
	}
	public void setInfIds(String[] infIds) {
		this.infIds = infIds;
	}
	

}
