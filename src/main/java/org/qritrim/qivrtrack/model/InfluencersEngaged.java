package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class InfluencersEngaged {
 private String influencerNames;
 private String imageUrls;
public String getInfluencerNames() {
	return influencerNames;
}
public void setInfluencerNames(String influencerNames) {
	this.influencerNames = influencerNames;
}
public String getImageUrls() {
	return imageUrls;
}
public void setImageUrls(String imageUrls) {
	this.imageUrls = imageUrls;
}

}
