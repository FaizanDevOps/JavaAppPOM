package org.qritrim.qivrtrack.model;

import java.util.HashMap;

import lombok.Data;

@Data
public class AudienceInsight {
	
	private float malePercentage;
	private float femalePercentage;
	private String[] brand;
	private HashMap<String, Integer> regions;
	private HashMap<String, Integer> maleAge;
	private HashMap<String, Integer> femaleAge;
	private HashMap<String, Integer> languages;
	public float getMalePercentage() {
		return malePercentage;
	}
	public void setMalePercentage(float malePercentage) {
		this.malePercentage = malePercentage;
	}
	public float getFemalePercentage() {
		return femalePercentage;
	}
	public void setFemalePercentage(float femalePercentage) {
		this.femalePercentage = femalePercentage;
	}
	public String[] getBrand() {
		return brand;
	}
	public void setBrand(String[] brand) {
		this.brand = brand;
	}
	public HashMap<String, Integer> getRegions() {
		return regions;
	}
	public void setRegions(HashMap<String, Integer> regions) {
		this.regions = regions;
	}
	public HashMap<String, Integer> getMaleAge() {
		return maleAge;
	}
	public void setMaleAge(HashMap<String, Integer> maleAge) {
		this.maleAge = maleAge;
	}
	public HashMap<String, Integer> getFemaleAge() {
		return femaleAge;
	}
	public void setFemaleAge(HashMap<String, Integer> femaleAge) {
		this.femaleAge = femaleAge;
	}
	public HashMap<String, Integer> getLanguages() {
		return languages;
	}
	public void setLanguages(HashMap<String, Integer> languages) {
		this.languages = languages;
	}
	
} 
