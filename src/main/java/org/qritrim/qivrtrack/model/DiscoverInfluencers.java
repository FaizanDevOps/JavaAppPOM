package org.qritrim.qivrtrack.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class DiscoverInfluencers {
	private int discoverInfId;
	private int influencersCount;
	private String listName;
	private Timestamp createdOn;
	private int userId;
	private String[] infIds;
	private int agencyId;
	private int categoryId;
	private int region_id;
	private Integer[] brand;
	private Integer[] ageGroup;
	private int gender;
	private Integer[] attribute;
	private Integer[] ethinicity;
	private String[] key;
	
	
	

	public int getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int category_id) {
		this.categoryId = category_id;
	}

	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

		public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

		public int getDiscoverInfId() {
		return discoverInfId;
	}

	public void setDiscoverInfId(int discoverInfId) {
		this.discoverInfId = discoverInfId;
	}

	public String[] getInfIds() {
		return infIds;
	}

	public void setInfIds(String[] infIds) {
		this.infIds = infIds;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getInfluencersCount() {
		return influencersCount;
	}

	public void setInfluencersCount(int influencersCount) {
		this.influencersCount = influencersCount;
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

	public Integer[] getBrand() {
		return brand;
	}

	public void setBrand(Integer[] brand) {
		this.brand = brand;
	}

	public Integer[] getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(Integer[] ageGroup) {
		this.ageGroup = ageGroup;
	}

	public Integer[] getAttribute() {
		return attribute;
	}

	public void setAttribute(Integer[] attribute) {
		this.attribute = attribute;
	}

	public Integer[] getEthinicity() {
		return ethinicity;
	}

	public void setEthinicity(Integer[] ethinicity) {
		this.ethinicity = ethinicity;
	}

	public String[] getKey() {
		return key;
	}

	public void setKey(String[] key) {
		this.key = key;
	}
	
}
