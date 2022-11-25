package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class RecentActivity {

	private int auditId;
	private int userId;
	private String property;
	private String action;
	private String comments;
	private Boolean isComplete;
	private String params;
	private String url;
	private String error;
	public int getAuditId() {
		return auditId;
	}
	public void setAuditId(int auditId) {
		this.auditId = auditId;
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
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Boolean getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
