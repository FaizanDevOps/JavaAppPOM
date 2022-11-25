package org.qritrim.qivrtrack.model;

import java.sql.Timestamp;
import lombok.Data;

@Data

public class InfluencerStatus {
 private int infId;
 private int status;
private Timestamp statusUpdatedAt;
public int getInfId() {
	return infId;
}
public void setInfId(int infId) {
	this.infId = infId;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public Timestamp getStatusUpdatedAt() {
	return statusUpdatedAt;
}
public void setStatusUpdatedAt(Timestamp statusUpdatedAt) {
	this.statusUpdatedAt = statusUpdatedAt;
}


}
