package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class ClauseTemplate {
private int templateId;
private String templateName;
private String[] clauses;
private Integer[] templateClauseId;
private int userId;
private int agencyId;
private int brandId;
public String[] getClauses() {
	return clauses;
}
public void setClauses(String[] clauses) {
	this.clauses = clauses;
}
public Integer[] getTemplateClauseId() {
	return templateClauseId;
}
public void setTemplateClauseId(Integer[] templateClauseId) {
	this.templateClauseId = templateClauseId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getAgencyId() {
	return agencyId;
}
public void setAgencyId(int agencyId) {
	this.agencyId = agencyId;
}
public int getBrandId() {
	return brandId;
}
public void setBrandId(int brandId) {
	this.brandId = brandId;
}
public int getTemplateId() {
	return templateId;
}
public void setTemplateId(int templateId) {
	this.templateId = templateId;
}
public String getTemplateName() {
	return templateName;
}
public void setTemplateName(String templateName) {
	this.templateName = templateName;
}


}
