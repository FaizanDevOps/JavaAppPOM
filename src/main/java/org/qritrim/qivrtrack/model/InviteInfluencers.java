package org.qritrim.qivrtrack.model;

import java.util.List;

import lombok.Data;

@Data
public class InviteInfluencers {

	public Integer campaignId;
	public Integer agencyId;
	public Integer userId;
	public List<Influencer> inf;
}
