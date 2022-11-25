package org.qritrim.qivrtrack.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.qritrim.qivrtrack.dao.TrackManagementDAO;
import org.qritrim.qivrtrack.model.Brand;
import org.qritrim.qivrtrack.model.CampaignDetails;
import org.qritrim.qivrtrack.model.LinksCampaign;
import org.qritrim.qivrtrack.model.ManageCampaigns;
import org.qritrim.qivrtrack.model.SaveList;
import org.qritrim.qivrtrack.model.TrackCampaign;
import org.qritrim.qivrtrack.model.TrackCampaignCount;
import org.qritrim.qivrtrack.service.TrackManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackManagementServiceimpl implements TrackManagementService {

	@Autowired
	TrackManagementDAO dao;
	
	@Override
	public TrackCampaignCount getCampaignCount(int agencyId) {
		TrackCampaignCount campaignCount = new TrackCampaignCount();
		try {
			campaignCount = dao.getTrackManagement(agencyId);
			return campaignCount;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<ManageCampaigns> getTrackManageCampaigns(int agencyId, String status) {
	try {
//		List<ManageCampaigns> manageCampaignsQIVR = dao.getTrackManageCampaigns(agencyId,status);
//	    manageCampaignsQIVR.addAll(dao.getTrackManageCampaignsPrivate(agencyId, status));
//	   
	    List<ManageCampaigns> manageCampaignsQIVR  = dao.getTrackManageCampaignsPrivate(agencyId, status);
	    System.out.println("manage campaigns size " + manageCampaignsQIVR.size());
	    return manageCampaignsQIVR;
	}catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	 
	}
	
	@Override
	public int postTrackCreateCampaign(TrackCampaign campaign) {
		 int trackCampaign = 0;
	 try {
		int isExistingCmapaignName = dao.isExistingTrackCmapaignNamePut(campaign);
		if (isExistingCmapaignName > 0) {
			return -1;
		} else {
			trackCampaign = dao.postTrackCreateCampaign(campaign);
		}
	 }catch (Exception e) {
		e.printStackTrace();
	}
	  return trackCampaign;
	}
	@Override
	public TrackCampaign trackSelectCampaign(int agencyId,int campaignId) {
		TrackCampaign details = new TrackCampaign();
		try {
				// TODO Auto-generated method stub
			    details = dao.trackSelectCampaign(agencyId,campaignId);
			}catch (Exception e) {
				e.printStackTrace();
			}
			  return details;
			}
	@Override
	public List<Brand> trackSelectBrand(int agencyId, int companyId) {
		List<Brand> details = new ArrayList<Brand>();
		try {
				// TODO Auto-generated method stub
			    details = dao.trackSelectBrand(agencyId,companyId);
			}catch (Exception e) {
				e.printStackTrace();
			}
			  return details;
			}
	@Override
	public List<LinksCampaign> getLinks(int agencyId) {
		List<LinksCampaign> details = new ArrayList<LinksCampaign>();
		try {
				// TODO Auto-generated method stub
			    details = dao.getLinks(agencyId);
			}catch (Exception e) {
				e.printStackTrace();
			}
			  return details;
			}
	@Override
	public int saveInfData(SaveList data) {
		int details = 0;
		try {
				// TODO Auto-generated method stub
			    details = dao.saveInfData(data);
			}catch (Exception e) {
				e.printStackTrace();
			}
			  return details;
			}
	@Override
	public List<SaveList> findSaveList(int agencyId) {
		List<SaveList> details  =  new ArrayList<SaveList>();
		try {
				// TODO Auto-generated method stub
			    details = dao.findSaveList(agencyId);
			}catch (Exception e) {
				e.printStackTrace();
			}
			  return details;
			}
	@Override
	public List<SaveList> companybranddecoded(int agencyId) {
		// TODO Auto-generated method stub
		List<SaveList> details  =  new ArrayList<SaveList>();
		try {
				// TODO Auto-generated method stub
			    details = dao.companybranddecoded(agencyId);
			}catch (Exception e) {
				e.printStackTrace();
			}
			  return details;
	}
	@Override
	public int existingCampaignName(String name, int agencyId) {
		// TODO Auto-generated method stub
		int details  =  0;
		try {
			    details = dao.existingCampaignName(name,agencyId);
			}catch (Exception e) {
				e.printStackTrace();
			}
			  return details;
	}
	@Override
	public int existingListName(String name, int agencyId) {
		int details  =  0;
		try {
			    details = dao.existingListName(name,agencyId);
			}catch (Exception e) {
				e.printStackTrace();
			}
			  return details;
	}
	
}


