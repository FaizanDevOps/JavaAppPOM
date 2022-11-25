package org.qritrim.qivrtrack.model;

import java.sql.Timestamp;

import java.sql.Date;
import lombok.Data;

@Data
public class UserDetails {
private int agency_id;
private int brand_id;
private Timestamp created;
private String createdBy;
private String designation;
private String email;
private String firstName;
private String lastName;
private Timestamp updated;
private String updatedBy;
private int user_id;
private int qritrim_influencer_id;
private Date dob;
private int industry_id;
private int role_id;
private int category_id;
private boolean is_tracking;
private int source_inf_id;
private String property;



public String getProperty() {
	return property;
}
public void setProperty(String property) {
	this.property = property;
}
public int getQritrim_influencer_id() {
	return qritrim_influencer_id;
}
public void setQritrim_influencer_id(int qritrim_influencer_id) {
	this.qritrim_influencer_id = qritrim_influencer_id;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public int getIndustry_id() {
	return industry_id;
}
public void setIndustry_id(int industry_id) {
	this.industry_id = industry_id;
}
public int getRole_id() {
	return role_id;
}
public void setRole_id(int role_id) {
	this.role_id = role_id;
}
public int getCategory_id() {
	return category_id;
}
public void setCategory_id(int category_id) {
	this.category_id = category_id;
}
public boolean isIs_tracking() {
	return is_tracking;
}
public void setIs_tracking(boolean is_tracking) {
	this.is_tracking = is_tracking;
}
public int getSource_inf_id() {
	return source_inf_id;
}
public void setSource_inf_id(int source_inf_id) {
	this.source_inf_id = source_inf_id;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getAgency_id() {
	return agency_id;
}
public void setAgency_id(int agency_id) {
	this.agency_id = agency_id;
}
public int getBrand_id() {
	return brand_id;
}
public void setBrand_id(int brand_id) {
	this.brand_id = brand_id;
}
public Timestamp getCreated() {
	return created;
}
public void setCreated(Timestamp created) {
	this.created = created;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public Timestamp getUpdated() {
	return updated;
}
public void setUpdated(Timestamp updated) {
	this.updated = updated;
}
public String getUpdatedBy() {
	return updatedBy;
}
public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}

}
