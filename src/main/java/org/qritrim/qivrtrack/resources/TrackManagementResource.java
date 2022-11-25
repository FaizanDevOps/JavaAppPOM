package org.qritrim.qivrtrack.resources;

import java.util.List;






import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qritrim.qivrtrack.model.Brand;
import org.qritrim.qivrtrack.model.CampaignCount;
import org.qritrim.qivrtrack.model.CampaignDetails;
import org.qritrim.qivrtrack.model.LinksCampaign;
import org.qritrim.qivrtrack.model.ManageCampaigns;
import org.qritrim.qivrtrack.model.QivrRequestEntity;
import org.qritrim.qivrtrack.model.QivrResponseEntity;
import org.qritrim.qivrtrack.model.ResponseStatus;
import org.qritrim.qivrtrack.model.SaveList;
import org.qritrim.qivrtrack.model.TrackCampaign;
import org.qritrim.qivrtrack.model.TrackCampaignCount;
import org.qritrim.qivrtrack.service.ManageCampaignService;
import org.qritrim.qivrtrack.service.TrackManagementService;
import org.qritrim.qivrtrack.utils.PropertyFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "qivrtrack/")
public class TrackManagementResource {
		
		@Autowired
		TrackManagementService managementService;

		private static final Logger logger = LogManager.getLogger(TrackManagementResource.class);
		
		@Autowired
		@Qualifier("messages")
		PropertyFileReader pfrMsgs;
		
		@Value("${qivr.agency.id}")
		private int AGENCY_ID;
		
		@GetMapping(value = "trackCampaignCount")
		public ResponseEntity<Object> getTrackCampaignCount(@RequestParam("agencyId") int agencyId){
			ResponseEntity<Object> response = null;
			QivrResponseEntity<TrackCampaignCount> qivrResp = new QivrResponseEntity<TrackCampaignCount>();
			
			ResponseStatus respStatus = new ResponseStatus();
			TrackCampaignCount campaignsDetails = managementService.getCampaignCount(agencyId);
			if(campaignsDetails != null) {
				qivrResp.setBody(campaignsDetails);
				
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.success.code"));
				respStatus.setMsg("successfully fetched data!!");

				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
			}else {
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.invalid.code"));
				respStatus.setMsg("data not exist");
				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.BAD_REQUEST);
				return response;
			}
			return response;
		}
		@GetMapping(value = "trackManageCampaigns")
		public ResponseEntity<Object> getTrackManageCampaigns(@RequestParam("agencyId") int agencyId,@RequestParam("status") String status){
			ResponseEntity<Object> response = null;
			QivrResponseEntity<List<ManageCampaigns>> qivrResp = new QivrResponseEntity<List<ManageCampaigns>>();
			
			ResponseStatus respStatus = new ResponseStatus();
			List<ManageCampaigns> campaignsDetails = managementService.getTrackManageCampaigns(agencyId,status);
			if(campaignsDetails != null && campaignsDetails.size() > 0 ) {
				qivrResp.setBody(campaignsDetails);
				
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.success.code"));
				respStatus.setMsg("successfully fetched data!!");

				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
			}else if(campaignsDetails.size() == 0) {
	             qivrResp.setBody(campaignsDetails);
				
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.success.code"));
				respStatus.setMsg("no data available!!");

				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
			}else {
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.invalid.code"));
				respStatus.setMsg("data not exist");
				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.BAD_REQUEST);
				return response;
			}
			return response;
		}
		@PostMapping(value = "trackCreateCampaign")
		public ResponseEntity<Object> postTrackCreateCampaign(@RequestBody QivrRequestEntity<TrackCampaign> requestObject){
			ResponseEntity<Object> response = null;
			QivrResponseEntity<Integer> qivrResp = new QivrResponseEntity<Integer>();
			TrackCampaign campaign = requestObject.getBody();
			ResponseStatus respStatus = new ResponseStatus();
			int updated = managementService.postTrackCreateCampaign(campaign);
			
			if (updated == -1) {
				qivrResp.setBody(updated);
				respStatus.setMsg(pfrMsgs.getValue("qivr.campaign.duplicate.error.msg"));
				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.BAD_REQUEST);
			}
			else if(updated >0 ) {
				
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.success.code"));
				respStatus.setMsg("successfully inserted data!!");

				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
			}else {
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.invalid.code"));
				respStatus.setMsg("data no inserted");
				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.BAD_REQUEST);
				return response;
			}
			return response;
		}
		@GetMapping(value = "trackSelectCampaign")
		public ResponseEntity<Object> trackSelectCampaign(@RequestParam("agencyId") int agencyId,@RequestParam("campaignId")int campaignId){
			ResponseEntity<Object> response = null;
			ResponseStatus respStatus = new ResponseStatus();
			QivrResponseEntity<TrackCampaign> qivrResp = new QivrResponseEntity<TrackCampaign>();
			TrackCampaign details = managementService.trackSelectCampaign(agencyId, campaignId);
			if(details!=null ) {
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.success.code"));
				respStatus.setMsg("successfully retrieved data!!");
				qivrResp.setBody(details);
				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
			}else {
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.invalid.code"));
				respStatus.setMsg("no data");
				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.BAD_REQUEST);
				return response;
			}
			return response;
		}

		@GetMapping(value = "trackSelectBrand")
		public ResponseEntity<Object> trackSelectBrand(@RequestParam("agencyId") int agencyId,@RequestParam("companyId")int companyId){
			ResponseEntity<Object> response = null;
			ResponseStatus respStatus = new ResponseStatus();
			QivrResponseEntity<List<Brand>> qivrResp = new QivrResponseEntity<List<Brand>>();
			List<Brand> details = managementService.trackSelectBrand(agencyId,companyId);
			if(details!=null ) {
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.success.code"));
				respStatus.setMsg("successfully retrieved data!!");
				qivrResp.setBody(details);
				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
			}else {
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.invalid.code"));
				respStatus.setMsg("no data");
				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.BAD_REQUEST);
				return response;
			}
			return response;
		}
		@GetMapping(value = "listLinks")
		public ResponseEntity<Object> getLinks(/*@RequestParam("agencyId") int agencyId*/){
			ResponseEntity<Object> response = null;
			ResponseStatus respStatus = new ResponseStatus();
			QivrResponseEntity<List<LinksCampaign>> qivrResp = new QivrResponseEntity<List<LinksCampaign>>();
			List<LinksCampaign> details = managementService.getLinks(AGENCY_ID);
			if(details!=null ) {
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.success.code"));
				respStatus.setMsg("successfully retrieved data!!");
				qivrResp.setBody(details);
				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
			}else {
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.invalid.code"));
				respStatus.setMsg("no data");
				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.BAD_REQUEST);
				return response;
			}
			return response;
		}
		@PostMapping(value = "/saveInfList")
		public ResponseEntity<Object> saveDiscoverInfData(@RequestBody QivrRequestEntity<SaveList> requestObject) {
			ResponseEntity<Object> response = null;
			QivrResponseEntity<Integer> qivrResponseEntity = new QivrResponseEntity<Integer>();
			ResponseStatus respStatus = new ResponseStatus();
			SaveList data = requestObject.getBody();
			int uploaded = managementService.saveInfData(data);
			if (uploaded == 1) {
				qivrResponseEntity.setBody(uploaded);
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.success.code"));
				respStatus.setMsg("succesfully inserted");
				qivrResponseEntity.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResponseEntity, HttpStatus.OK);
			}else if(uploaded == 2){
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.invalid.code"));
				respStatus.setMsg("list name already exists");
				qivrResponseEntity.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResponseEntity, HttpStatus.BAD_REQUEST);
				return response;
				
			}else {
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.invalid.code"));
				respStatus.setMsg(pfrMsgs.getValue("qivr.inf.id.invalid.msg"));
				qivrResponseEntity.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResponseEntity, HttpStatus.BAD_REQUEST);
				return response;
			}

			return response;

		}
		@GetMapping(value = "/infSavedList")
		public ResponseEntity<Object> discoverInfList(@RequestParam("agencyId") int agencyId){
			ResponseEntity<Object> response = null;
			QivrResponseEntity<List<SaveList>> qivrResp = new QivrResponseEntity<List<SaveList>>();
			
			ResponseStatus respStatus = new ResponseStatus();
			List<SaveList> savedList = managementService.findSaveList(agencyId);
			if(savedList != null && savedList.size() > 0 ) {
				qivrResp.setBody(savedList);
				
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.success.code"));
				respStatus.setMsg("successfully fetched data!!");

				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
			}else if(savedList.size() == 0) {
	             qivrResp.setBody(savedList);
				
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.success.code"));
				respStatus.setMsg("no data available!!");

				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
			}else {
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.invalid.code"));
				respStatus.setMsg("data not exist");
				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.BAD_REQUEST);
				return response;
			}
			return response;
		}
	//this call is to decode brand and company names
		@GetMapping(value = "/companybranddecode")
		public ResponseEntity<Object> companybranddecoded(@RequestParam("agencyId") int agencyId){
			ResponseEntity<Object> response = null;
			QivrResponseEntity<List<SaveList>> qivrResp = new QivrResponseEntity<List<SaveList>>();
			
			ResponseStatus respStatus = new ResponseStatus();
			List<SaveList> savedList = managementService.companybranddecoded(agencyId);
			if(savedList != null && savedList.size() > 0 ) {
				qivrResp.setBody(savedList);
				
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.success.code"));
				respStatus.setMsg("successfully fetched data!!");

				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
			}else if(savedList.size() == 0) {
	             qivrResp.setBody(savedList);
				
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.success.code"));
				respStatus.setMsg("no data available!!");

				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
			}else {
				respStatus.setCode(pfrMsgs.getValue("qivr.inf.id.invalid.code"));
				respStatus.setMsg("data not exist");
				qivrResp.setStatus(respStatus);
				response = new ResponseEntity<>(qivrResp, HttpStatus.BAD_REQUEST);
				return response;
			}
			return response;
		}		
		@GetMapping(value = "/isExistingCampaignName")
		public ResponseEntity<Object> existingCampaignName(@RequestParam("name") String name,@RequestParam("agencyId") int agencyId) {
			ResponseEntity<Object> response = null;
			QivrResponseEntity<Boolean> qivrResp = new QivrResponseEntity<Boolean>();
			ResponseStatus respStatus = new ResponseStatus();

				int info = managementService.existingCampaignName(name,agencyId);
				if (info > 0) {
					respStatus.setCode(pfrMsgs.getValue("qivr.success.code"));
					respStatus.setMsg("true");
					qivrResp.setStatus(respStatus);
					response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
				} 
			 else {
				 	respStatus.setCode(pfrMsgs.getValue("qivr.success.code"));
					respStatus.setMsg("false");
					qivrResp.setStatus(respStatus);
					response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
				
			}

			return response;

		}
		@GetMapping(value = "/isExistingListName")
		public ResponseEntity<Object> existingListName(@RequestParam("name") String name,@RequestParam("agencyId") int agencyId) {
			ResponseEntity<Object> response = null;
			QivrResponseEntity<Boolean> qivrResp = new QivrResponseEntity<Boolean>();
			ResponseStatus respStatus = new ResponseStatus();

				int info = managementService.existingListName(name,agencyId);
				if (info > 0) {
					respStatus.setCode(pfrMsgs.getValue("qivr.success.code"));
					respStatus.setMsg("true");
					qivrResp.setStatus(respStatus);
					response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
				} 
			 else {
				 	respStatus.setCode(pfrMsgs.getValue("qivr.success.code"));
					respStatus.setMsg("false");
					qivrResp.setStatus(respStatus);
					response = new ResponseEntity<>(qivrResp, HttpStatus.OK);
				
			}

			return response;

		}
		
}