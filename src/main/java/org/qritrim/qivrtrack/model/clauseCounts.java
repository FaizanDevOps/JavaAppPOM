package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class clauseCounts {
private int totalClauses;
private int acceptedBoth;
private int influencerAccept;
private int userAccept;
public int getTotalClauses() {
	return totalClauses;
}
public void setTotalClauses(int totalClauses) {
	this.totalClauses = totalClauses;
}
public int getAcceptedBoth() {
	return acceptedBoth;
}
public void setAcceptedBoth(int acceptedBoth) {
	this.acceptedBoth = acceptedBoth;
}
public int getInfluencerAccept() {
	return influencerAccept;
}
public void setInfluencerAccept(int influencerAccept) {
	this.influencerAccept = influencerAccept;
}
public int getUserAccept() {
	return userAccept;
}
public void setUserAccept(int agencyAccept) {
	this.userAccept = agencyAccept;
}

}
