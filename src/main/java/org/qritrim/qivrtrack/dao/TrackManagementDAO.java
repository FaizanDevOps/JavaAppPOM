package org.qritrim.qivrtrack.dao;

import java.util.List;


import org.qritrim.qivrtrack.model.Brand;
import org.qritrim.qivrtrack.model.CampaignDetails;
import org.qritrim.qivrtrack.model.LinksCampaign;
import org.qritrim.qivrtrack.model.ManageCampaigns;
import org.qritrim.qivrtrack.model.SaveList;
import org.qritrim.qivrtrack.model.TrackCampaign;
import org.qritrim.qivrtrack.model.TrackCampaignCount;

public interface TrackManagementDAO {

	public TrackCampaignCount getTrackManagement(int agencyId);

	public List<ManageCampaigns> getTrackManageCampaigns(int agencyId, String status);

	public int postTrackCreateCampaign(TrackCampaign campaign);

	public TrackCampaign trackSelectCampaign(int agencyId, int campaignId);
	
	public List<ManageCampaigns> getTrackManageCampaignsPrivate(int agencyId, String status);

	public List<Brand> trackSelectBrand(int agencyId, int companyId);

	public int isExistingTrackCmapaignNamePut(TrackCampaign campaign);

	public List<LinksCampaign> getLinks(int agencyId);

	public int saveInfData(SaveList data);

	public List<SaveList> findSaveList(int agencyId);

	public List<SaveList> companybranddecoded(int agencyId);

	public int existingCampaignName(String name, int agencyId);

	public int existingListName(String name, int agencyId);


}
