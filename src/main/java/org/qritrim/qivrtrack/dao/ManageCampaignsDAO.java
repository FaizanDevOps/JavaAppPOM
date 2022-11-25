package org.qritrim.qivrtrack.dao;

import java.util.List;


import org.qritrim.qivrtrack.model.CampaignCount;
import org.qritrim.qivrtrack.model.CompanyDetails;
import org.qritrim.qivrtrack.model.CompanyDetailsSummary;
import org.qritrim.qivrtrack.model.ManageCampaigns;
import org.qritrim.qivrtrack.model.ManageCompanies;
import org.springframework.jdbc.core.JdbcTemplate;

public interface ManageCampaignsDAO {
	
	 public List<ManageCampaigns> getCampaignDetails(int agencyId, String status);
	 public List<ManageCompanies> getCompanyDetails(int agencyId);
	 public List<CompanyDetails> getCompanyDetailsGrid(int companyId,int agencyId);
	 public CompanyDetailsSummary getCompanyDetailsSummary(int companyId);
	public CampaignCount getCampaignCounts(int agencyId, JdbcTemplate jd);
	public CampaignCount getCampaignsCreated(int agencyId);
}
