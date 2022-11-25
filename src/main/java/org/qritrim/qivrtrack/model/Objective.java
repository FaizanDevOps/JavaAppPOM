package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class Objective {
	private int awarness;
	private int engagement;
	private int sales;
	public int getAwarness() {
		return awarness;
	}
	public void setAwarness(int awarness) {
		this.awarness = awarness;
	}
	public int getEngagement() {
		return engagement;
	}
	public void setEngagement(int engagement) {
		this.engagement = engagement;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	

}
