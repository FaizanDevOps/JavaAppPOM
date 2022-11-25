package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class AuditRedirectParams {
	private int userId;
	private String data;
	private String property;
	private String url;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
