package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class clauses {
private int clauseId;
private String clauseName;
private String clauseDescription;
private int clauseType;
private int budget;

public int getClauseId() {
	return clauseId;
}
public void setClauseId(int clauseId) {
	this.clauseId = clauseId;
}
public String getClauseName() {
	return clauseName;
}
public void setClauseName(String clauseName) {
	this.clauseName = clauseName;
}
public String getClauseDescription() {
	return clauseDescription;
}
public void setClauseDescription(String clauseDescription) {
	this.clauseDescription = clauseDescription;
}
public int getClauseType() {
	return clauseType;
}
public void setClauseType(int clauseType) {
	this.clauseType = clauseType;
}
public int getBudget() {
	return budget;
}
public void setBudget(int budget) {
	this.budget = budget;
}

}
