package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class TagsMentions {
	private String tagsMention;
	private int count;
	public String getTagsMention() {
		return tagsMention;
	}
	public void setTagsMention(String tagsMention) {
		this.tagsMention = tagsMention;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
