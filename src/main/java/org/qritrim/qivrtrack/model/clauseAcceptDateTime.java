package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data

public class clauseAcceptDateTime {
private Boolean isUserAccepted;
private Boolean isInfAccepted;
private String userAcceptedDate;
private String influencerAcceptedDate;

public String getInfluencerAcceptedDate() {
	return influencerAcceptedDate;
}
public void setInfluencerAcceptedDate(String influencerAcceptedDate) {
	this.influencerAcceptedDate = influencerAcceptedDate;
}
public String getUserAcceptedDate() {
	return userAcceptedDate;
}
public void setUserAcceptedDate(String userAcceptedDate) {
	this.userAcceptedDate = userAcceptedDate;
}

public Boolean getIsUserAccepted() {
	return isUserAccepted;
}
public void setIsUserAccepted(Boolean isUserAccepted) {
	this.isUserAccepted = isUserAccepted;
}
public Boolean getIsInfAccepted() {
	return isInfAccepted;
}
public void setIsInfAccepted(Boolean isInfAccepted) {
	this.isInfAccepted = isInfAccepted;
}

}
