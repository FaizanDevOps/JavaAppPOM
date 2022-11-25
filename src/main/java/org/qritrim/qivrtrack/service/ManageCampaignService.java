package org.qritrim.qivrtrack.service;

import java.util.List;




import org.qritrim.qivrtrack.model.CampaignCount;
import org.qritrim.qivrtrack.model.CompanyDetails;
import org.qritrim.qivrtrack.model.CompanyDetailsSummary;
import org.qritrim.qivrtrack.model.ManageCampaigns;
import org.qritrim.qivrtrack.model.ManageCompanies;

public interface ManageCampaignService {

	public List<ManageCampaigns> getCampaignsDetails(int agencyId, String status);
	public List<ManageCompanies> getCompanyDetails(int agencyId);
	public List<CompanyDetails> getCompanyDetailsGrid(int companyId,int agencyId);
	public CompanyDetailsSummary getCompanyDetailsSummary(int companyId);
	public CampaignCount getCampaignCounts(int agencyId);
	public CampaignCount getCampaignsCreated(int agencyId);
}
	