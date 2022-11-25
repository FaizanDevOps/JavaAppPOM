package org.qritrim.qivrtrack.model;

import java.util.List;

import lombok.Data;

@Data
public class FeedsDataList {
	List<FeedsData> feedsDataList;

	public List<FeedsData> getFeedsDataList() {
		return feedsDataList;
	}

	public void setFeedsDataList(List<FeedsData> feedsDataList) {
		this.feedsDataList = feedsDataList;
	}
	
}
