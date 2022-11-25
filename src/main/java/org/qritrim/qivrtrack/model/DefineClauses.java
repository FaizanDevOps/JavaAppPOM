package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class DefineClauses {
private int clauseId;
private String clauseName;
private String clauseDescription;
private int objectiveId;
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
public int getObjectiveId() {
	return objectiveId;
}
public void setObjectiveId(int objectiveId) {
	this.objectiveId = objectiveId;
}
}
