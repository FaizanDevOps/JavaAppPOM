package org.qritrim.qivrtrack.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Notification {

private int notificationId;
private int from;
private int[] to;
private int toData;
public int getToData() {
	return toData;
}
public void setToData(int toData) {
	this.toData = toData;
}
private String title;
private String message;
private Boolean isRead;
private String property;
private Timestamp created;
private String updated;
private String createdBy;
private String updatedBy;
private Boolean isNew;
private String redirection;
public int getNotificationId() {
	return notificationId;
}
public void setNotificationId(int notificationId) {
	this.notificationId = notificationId;
}
public int getFrom() {
	return from;
}
public void setFrom(int from) {
	this.from = from;
}

public int[] getTo() {
	return to;
}
public void setTo(int[] to) {
	this.to = to;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Boolean getIsRead() {
	return isRead;
}
public void setIsRead(Boolean isRead) {
	this.isRead = isRead;
}
public String getProperty() {
	return property;
}
public void setProperty(String property) {
	this.property = property;
}
public Timestamp getCreated() {
	return created;
}
public void setCreated(Timestamp created) {
	this.created = created;
}
public String getUpdated() {
	return updated;
}
public void setUpdated(String updated) {
	this.updated = updated;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public String getUpdatedBy() {
	return updatedBy;
}
public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
}
public Boolean getIsNew() {
	return isNew;
}
public void setIsNew(Boolean isNew) {
	this.isNew = isNew;
}
public String getRedirection() {
	return redirection;
}
public void setRedirection(String redirection) {
	this.redirection = redirection;
}


}
