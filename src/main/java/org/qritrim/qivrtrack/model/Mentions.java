package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class Mentions {
	private String topMentions;
	private int count;
	public String getTopMentions() {
		return topMentions;
	}
	public void setTopMentions(String topMentions) {
		this.topMentions = topMentions;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
