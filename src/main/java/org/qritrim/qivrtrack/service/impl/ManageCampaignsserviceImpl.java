package org.qritrim.qivrtrack.service.impl;

import java.util.ArrayList;


import java.util.List;

import org.qritrim.qivrtrack.dao.ManageCampaignsDAO;
import org.qritrim.qivrtrack.model.CampaignCount;
import org.qritrim.qivrtrack.model.CompanyDetails;
import org.qritrim.qivrtrack.model.CompanyDetailsSummary;
import org.qritrim.qivrtrack.model.ManageCampaigns;
import org.qritrim.qivrtrack.model.ManageCompanies;
import org.qritrim.qivrtrack.service.ManageCampaignService;
import org.qritrim.qivrtrack.utils.QivrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ManageCampaignsserviceImpl implements ManageCampaignService {

	@Autowired
	ManageCampaignsDAO manageCampaignsDAO;
	
	@Autowired
	QivrUtils utils;
	
	@Override
	public List<ManageCampaigns> getCampaignsDetails(int agencyId, String status) {
		 List<ManageCampaigns> manageCampaigns = new ArrayList<ManageCampaigns>();
	try {
		// TODO Auto-generated method stub
	    manageCampaigns = manageCampaignsDAO.getCampaignDetails(agencyId,status);
	    System.out.println("manage campaigns size " + manageCampaigns.size());
//	     if(manageCampaigns.size() == 0 && status.equals("engage")) {
//	    	 String draftStatus = "draft";
//	    	 manageCampaigns = manageCampaignsDAO.getCampaignDetails(agencyId,draftStatus);
//	    	 return manageCampaigns;
//	     }
	}catch (Exception e) {
		e.printStackTrace();
//		return null;
	}
	  return manageCampaigns;
	}
	
	@Override
	public List<ManageCompanies> getCompanyDetails(int agencyId) {
		List<ManageCompanies> manageCompanies = new ArrayList<ManageCompanies>();
	try {
		manageCompanies = manageCampaignsDAO.getCompanyDetails(agencyId);
		
	}catch (Exception e) {
		e.printStackTrace();
//		return null;

	}
	return manageCompanies;
	}
	
	@Override
	public List<CompanyDetails> getCompanyDetailsGrid(int companyId,int agencyId) {
		List<CompanyDetails> manageCompaniesGrid = new ArrayList<CompanyDetails>();
	try {
		manageCompaniesGrid = manageCampaignsDAO.getCompanyDetailsGrid(companyId,agencyId);
	}catch (Exception e) {
		e.printStackTrace();
//		return null;
	}
	return manageCompaniesGrid;
	}
	
	@Override
	public CompanyDetailsSummary getCompanyDetailsSummary(int companyId) {
		CompanyDetailsSummary manageCompaniesSummary = new CompanyDetailsSummary();
	try {
		manageCompaniesSummary = manageCampaignsDAO.getCompanyDetailsSummary(companyId);
	}catch (Exception e) {
		e.printStackTrace();
//		return null;
	}
	return manageCompaniesSummary;
	}

	@Override
	public CampaignCount getCampaignCounts(int agencyId) {
		CampaignCount campaignCounts = new CampaignCount();
		JdbcTemplate jcc = utils.getDBConnection(agencyId);
		try {
			campaignCounts = manageCampaignsDAO.getCampaignCounts(agencyId, jcc);
		}catch (Exception e) {
			e.printStackTrace();
//			return null;
		}
		return campaignCounts;
	}

	@Override
	public CampaignCount getCampaignsCreated(int agencyId) {
		CampaignCount campaignCounts = new CampaignCount();
		try {
			campaignCounts = manageCampaignsDAO.getCampaignsCreated(agencyId);
		}catch (Exception e) {
			e.printStackTrace();
//			return null;
		}
		return campaignCounts;
	}

}
