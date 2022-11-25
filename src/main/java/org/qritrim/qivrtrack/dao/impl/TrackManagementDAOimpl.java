package org.qritrim.qivrtrack.dao.impl;

import java.sql.Array;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.qritrim.qivrtrack.model.Campaign;
import org.qritrim.qivrtrack.dao.TrackManagementDAO;
import org.qritrim.qivrtrack.model.Brand;
import org.qritrim.qivrtrack.model.CampaignCreate;
import org.qritrim.qivrtrack.model.CampaignDetails;
import org.qritrim.qivrtrack.model.Company;
import org.qritrim.qivrtrack.model.LinksCampaign;
import org.qritrim.qivrtrack.model.ManageCampaigns;
import org.qritrim.qivrtrack.model.Objective;
import org.qritrim.qivrtrack.model.SaveList;
import org.qritrim.qivrtrack.model.StatusId;
import org.qritrim.qivrtrack.model.TrackCampaign;
import org.qritrim.qivrtrack.model.TrackCampaignCount;
import org.qritrim.qivrtrack.utils.PropertyFileReader;
import org.qritrim.qivrtrack.utils.QivrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

@Service
public class TrackManagementDAOimpl implements TrackManagementDAO {

	private static final Logger logger = LogManager.getLogger(TrackManagementDAOimpl.class);

	@Autowired
	QivrUtils utils;

	@Autowired
	@Qualifier(value = "queries")
	PropertyFileReader pfrQueries;

	@Qualifier(value = "constants")
	@Autowired
	PropertyFileReader pfrConstants;

	@Autowired
	QivrUtils qutils;

	@Override
	public TrackCampaignCount getTrackManagement(int agencyId) {
		TrackCampaignCount campaignCount = new TrackCampaignCount();
		try {
			logger.info("Entered into the function getCampaignCounts");

			JdbcTemplate jcc = utils.getDBConnection(agencyId);

			updatePastCampaigns(jcc);

			// Integer totalCampaigns = getTotalCampaignsAgency(jcc) +
			// getTotalCampaignsAgencyPrivate(jcc);
			// Integer activeCampaigns = getactiveCampaignsAgency(jcc);
			// Integer campaignsPast = getCampaignsPastAgency(jcc);

			Integer totalCampaigns = getTotalCampaignsAgencyPrivate(jcc);

			// Objective objective1 = getObjectiveValues(jcc);

			// Objective objective2 = getObjectiveValuesPrivate(jcc);
//			Integer awarness = objective1.getAwarness() + objective2.getAwarness();
//			Integer engagement = objective1.getEngagement()+objective2.getEngagement();
//			Integer sales = objective1.getSales()+objective2.getSales();

//			
			StatusId objective2 = getStatusValue(jcc);

			Integer completed = objective2.getCompleted();
			Integer optimizing = objective2.getOptimizing();
			Integer tracking = objective2.getTracking();

			campaignCount.setTotalCampaigns(totalCampaigns);

			campaignCount.setCompleted(completed);
			campaignCount.setOptimizing(optimizing);
			campaignCount.setTracking(tracking);

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return campaignCount;

	}

	private Objective getObjectiveValues(JdbcTemplate jcc) {
		try {
			logger.info("Entered into the function getTotalCampaignsAgency");
			Objective objective = new Objective();
			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.track.manageCampaigns.objective");
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
				}
			};
			objective = jcc.query(query, pss, new ResultSetExtractor<Objective>() {

				public Objective extractData(ResultSet rs) throws SQLException, DataAccessException {
					Objective ob = new Objective();
					while (rs.next()) {
						int value = rs.getInt("objective_id");
						if (value == 1)
							ob.setSales(rs.getInt("count"));
						else if (value == 2)
							ob.setAwarness(rs.getInt("count"));
						else if (value == 3)
							ob.setEngagement(rs.getInt("count"));
					}
					return ob;
				}
			});
			return objective;
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return null;
		}
	}

	private Objective getObjectiveValuesPrivate(JdbcTemplate jcc) {
		try {
			logger.info("Entered into the function getTotalCampaignsAgency");
			Objective objective = new Objective();
			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.track.manageCampaigns.objective.private");
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
				}
			};
			objective = jcc.query(query, pss, new ResultSetExtractor<Objective>() {

				public Objective extractData(ResultSet rs) throws SQLException, DataAccessException {
					Objective ob = new Objective();
					while (rs.next()) {
						int value = rs.getInt("objective_id");
						if (value == 1)
							ob.setSales(rs.getInt("count"));
						else if (value == 2)
							ob.setAwarness(rs.getInt("count"));
						else if (value == 3)
							ob.setEngagement(rs.getInt("count"));
					}
					return ob;
				}
			});
			return objective;
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return null;
		}
	}

	private Integer getTotalCampaignsAgency(JdbcTemplate jc) {
		int totalCamp = 0;
		try {
			logger.info("Entered into the function getTotalCampaignsAgency");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.trackmanageCampaigns.totalCampaignsOfAgency");
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, Integer.parseInt(pfrConstants.getValue("qritrim.status.id.draft")));
				}
			};
			totalCamp = jc.query(query, pss, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					Integer totalCampaigns = null;
					while (rs.next()) {
						totalCampaigns = rs.getInt("count");
					}
					logger.info(totalCampaigns);
					return totalCampaigns;
				}
			});
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return 0;
		}
		return totalCamp;
	}

	private Integer getTotalCampaignsAgencyPrivate(JdbcTemplate jc) {
		int totalCamp = 0;
		try {
			logger.info("Entered into the function getTotalCampaignsAgencyPrivate");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.trackmanageCampaigns.totalCampaignsOfAgency.private");
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
				}
			};
			totalCamp = jc.query(query, pss, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					Integer totalCampaigns = null;
					while (rs.next()) {
						totalCampaigns = rs.getInt("count");
					}
					logger.info(totalCampaigns);
					return totalCampaigns;
				}
			});
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return 0;
		}
		return totalCamp;
	}

	public Integer getactiveCampaignsAgency(JdbcTemplate jc) {
		List<String> timelines = new ArrayList<>();
		int campCount = 0;
		int activeStatus = Integer.parseInt(pfrConstants.getValue("qritrim.status.id.active"));
		;
		try {
			logger.info("Entered into the function getactiveCampaignsAgency");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.trackmanageCampaigns.activeCampaignsOfAgency");
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setInt(1, activeStatus);
				}
			};
			timelines = jc.query(query, pss, new ResultSetExtractor<List<String>>() {

				public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<String> timelines = new ArrayList<String>();
					while (rs.next()) {
						String timeline = rs.getString("time_line");
						timelines.add(timeline);
					}
					return timelines;
				}
			});
			for (int i = 0; i < timelines.size(); i++) {
				String timeLine = timelines.get(i);
				if (timeLine != null) {
					JSONObject jsonObject = new JSONObject(timeLine);
					String sDate = (String) jsonObject.get("endDate");

					Date today = new Date();

					Calendar cal = Calendar.getInstance();
					cal.setTime(today);
					cal.set(Calendar.HOUR_OF_DAY, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					cal.set(Calendar.MILLISECOND, 0);
					today = cal.getTime();

					SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
					try {
						Date endDate = formatter5.parse(sDate);

						// System.out.println("endDate --- " + endDate);
						// System.out.println("today --- " + today);
						long diff = endDate.getTime() - today.getTime();
						// System.out.println("Diff ===== " + diff);
						if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) >= 1) {
							campCount++;
						}

					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return 0;
		}
		return campCount;
	}

	private Integer getCampaignsPastAgency(JdbcTemplate jc) {
		List<String> timelines = new ArrayList<>();
		int campCount = 0;
		int activeStatus = Integer.parseInt(pfrConstants.getValue("qritrim.status.id.active"));
		;
		try {
			logger.info("Entered into the function getactiveCampaignsAgency");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.trackmanageCampaigns.pastCampaigns");
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setInt(1, Integer.parseInt(pfrConstants.getValue("qritrim.status.id.draft")));
				}
			};
			timelines = jc.query(query, pss, new ResultSetExtractor<List<String>>() {

				public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<String> timelines = new ArrayList<String>();
					while (rs.next()) {
						String timeline = rs.getString("time_line");
						timelines.add(timeline);
					}
					return timelines;
				}
			});
			for (int i = 0; i < timelines.size(); i++) {
				String timeLine = timelines.get(i);
				if (timeLine != null) {
					JSONObject jsonObject = new JSONObject(timeLine);
					String sDate = (String) jsonObject.get("endDate");

					Date today = new Date();

					Calendar cal = Calendar.getInstance();
					cal.setTime(today);
					cal.set(Calendar.HOUR_OF_DAY, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					cal.set(Calendar.MILLISECOND, 0);
					today = cal.getTime();

					SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
					try {
						Date endDate = formatter5.parse(sDate);

						// System.out.println("endDate --- " + endDate);
						// System.out.println("today --- " + today);
						long diff = endDate.getTime() - today.getTime();
						// System.out.println("Diff ===== " + diff);
						if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) < 1) {
							campCount++;
						}
						System.out.println(campCount);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return 0;
		}
		return campCount;
	}

	@Override
	public List<ManageCampaigns> getTrackManageCampaigns(int agencyId, String status) {
		List<ManageCampaigns> campaigns = new ArrayList<ManageCampaigns>();
		try {
			logger.info("Entered into the function getCampaignDetails");

			PreparedStatementSetter pss = null;
			String query = null;
			if (status.equalsIgnoreCase("total")) {
				query = pfrQueries.getValue("qivr.get.track.campign.links");
			} else {
				String const1 = "qritrim.inf.status." + status.toLowerCase();
				String statusValue = pfrConstants.getValue(const1);
				int stats = Integer.parseInt(statusValue);
				query = pfrQueries.getValue("qivr.campaigns.track.status");
				pss = new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						// TODO Auto-generated method stub
						if (!(status.equals("total"))) {
							ps.setInt(1, stats);
						}
					}
				};
			}

			JdbcTemplate jmc = utils.getDBConnection(agencyId);

			campaigns = jmc.query(query, pss, new ResultSetExtractor<List<ManageCampaigns>>() {

				public List<ManageCampaigns> extractData(ResultSet rs) throws SQLException, DataAccessException {

					List<ManageCampaigns> campaignsList = new ArrayList<ManageCampaigns>();
					while (rs.next()) {
						ManageCampaigns manageCampaigns = new ManageCampaigns();
						manageCampaigns.setCampaignId(rs.getInt("campaign_id"));
						manageCampaigns.setCampaignName(rs.getString("campaign_name"));
						manageCampaigns.setObjectiveId(rs.getInt("objective_id"));
						manageCampaigns.setCreated(rs.getString("created"));
						manageCampaigns.setCatergoryId(rs.getInt("category_id"));
						manageCampaigns.setStatusId(rs.getInt("status_id"));
						Array networkIds = rs.getArray("network_id");
						Integer[] networks = (Integer[]) networkIds.getArray();
						manageCampaigns.setNetworkId(networks);
						campaignsList.add(manageCampaigns);
					}
					return campaignsList;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//			return null;
			// TODO: handle exception
		}
		return campaigns;
	}

	@Override
	public int postTrackCreateCampaign(TrackCampaign campaign) {
		int updated = 0;
		try {
			logger.info("Entered into the function getTrackCreateCampaign");
			JdbcTemplate jcc = utils.getDBConnection(campaign.getAgencyId());
			if (campaign.getCampaignId() > 0) {
				PreparedStatementSetter pss = null;
				String query = pfrQueries.getValue("qivr.update.manage.campaign.status");
				int status = Integer.parseInt(pfrConstants.getValue("qritrim.inf.status.tracking"));
				pss = new PreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, status);
						ps.setInt(2, campaign.getCampaignId());
					}
				};
				updated = jcc.update(query, pss);
			}
			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.post.track.campaign");
			Connection con = jcc.getDataSource().getConnection();
			int status = Integer.parseInt(pfrConstants.getValue("qritrim.inf.status.tracking"));
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, campaign.getCampaignName());
					ps.setInt(2, campaign.getBrandId());
					ps.setInt(3, campaign.getCompanyId());
					ps.setInt(4, campaign.getObjectiveId());
					ps.setString(5, campaign.getKpi());
					ps.setString(6, campaign.getLinks());
					ps.setString(7, campaign.getTimeLine());
					ps.setArray(8, con.createArrayOf("int", campaign.getNetwork()));
					ps.setArray(9, con.createArrayOf("int", campaign.getSavedList()));
					ps.setInt(10, status);
					ps.setString(11, campaign.getBrandCompetitors());
					ps.setArray(12, con.createArrayOf("int", campaign.getInfluencers()));
				}
			};
			updated = jcc.update(query, pss);
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public TrackCampaign trackSelectCampaign(int agencyId, int campaignId) {
		try {
			logger.info("Entered into the function trackSelectCampaign");
			JdbcTemplate jcc = utils.getDBConnection(agencyId);
			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.campaigns.track");
			TrackCampaign detailsList = new TrackCampaign();
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, campaignId);
				}
			};
			detailsList = jcc.query(query, pss, new ResultSetExtractor<TrackCampaign>() {

				public TrackCampaign extractData(ResultSet rs) throws SQLException, DataAccessException {
					TrackCampaign campaignDetails = new TrackCampaign();
					while (rs.next()) {
						campaignDetails.setCampaignId(rs.getInt("id"));
						campaignDetails.setCampaignName(rs.getString("campaign_name"));
						campaignDetails.setBrandId(rs.getInt("brand_id"));
						campaignDetails.setObjectiveId(rs.getInt("objective_id"));
						campaignDetails.setTimeLine(rs.getString("time_line"));
						campaignDetails.setKpi(rs.getString("obj_kpi"));
						campaignDetails.setLinks(rs.getString("links"));
						campaignDetails.setCompanyId(rs.getInt("company_id"));
						campaignDetails.setStatus(rs.getInt("status_id"));
						Array arr1 = rs.getArray("network_id");
						if (arr1 != null) {
							Integer[] networks = (Integer[]) arr1.getArray();
							campaignDetails.setNetwork(networks);
						}
						Array arr2 = rs.getArray("saved_list");
						if (arr2 != null) {
							Integer[] lists = (Integer[]) arr2.getArray();
							campaignDetails.setSavedList(lists);
						}
						Array arr3 = rs.getArray("influencers");
						if (arr3 != null) {
							Integer[] infs = (Integer[]) arr3.getArray();
							campaignDetails.setInfluencers(infs);
						}
						campaignDetails.setBrandCompetitors(rs.getString("brands_competitors"));
						campaignDetails.setCompanyName(rs.getString("companyName"));
						campaignDetails.setBrandName(rs.getString("brandName"));

					}
					return campaignDetails;
				}
			});
			return detailsList;
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<ManageCampaigns> getTrackManageCampaignsPrivate(int agencyId, String status) {
		List<ManageCampaigns> campaigns = new ArrayList<ManageCampaigns>();
		try {
			logger.info("Entered into the function getCampaignDetails");

			PreparedStatementSetter pss = null;
			String query = null;
			if (status.equalsIgnoreCase("total")) {
				query = pfrQueries.getValue("qivr.get.track.campign.links");
			} else {
				String const1 = "qritrim.inf.status." + status.toLowerCase();
				String statusValue = pfrConstants.getValue(const1);
				int stats = Integer.parseInt(statusValue);
				query = pfrQueries.getValue("qivr.campaigns.track.status");
				pss = new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						// TODO Auto-generated method stub
						if (!(status.equals("total"))) {
							ps.setInt(1, stats);
						}
					}
				};
			}

			JdbcTemplate jmc = utils.getDBConnection(agencyId);

			campaigns = jmc.query(query, pss, new ResultSetExtractor<List<ManageCampaigns>>() {

				public List<ManageCampaigns> extractData(ResultSet rs) throws SQLException, DataAccessException {

					List<ManageCampaigns> campaignsList = new ArrayList<ManageCampaigns>();
					while (rs.next()) {
						ManageCampaigns manageCampaigns = new ManageCampaigns();
						manageCampaigns.setCampaignId(rs.getInt("id"));
						manageCampaigns.setCampaignName(rs.getString("campaign_name"));
						manageCampaigns.setObjectiveId(rs.getInt("objective_id"));
						manageCampaigns.setStatusId(rs.getInt("status_id"));
						Array networkIds = rs.getArray("network_id");
						Integer[] networks = (Integer[]) networkIds.getArray();
						manageCampaigns.setNetworkId(networks);
						campaignsList.add(manageCampaigns);
					}
					return campaignsList;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//			return null;
			// TODO: handle exception
		}
		return campaigns;
	}

	@Override
	public List<Brand> trackSelectBrand(int agencyId, int companyId) {
		try {
			logger.info("Entered into the function trackSelectBrand");
			JdbcTemplate jcc = utils.getDBConnection(agencyId);
			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.brand.track");
			List<Brand> detailsList = new ArrayList<Brand>();
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, companyId);
				}
			};
			detailsList = jcc.query(query, pss, new ResultSetExtractor<List<Brand>>() {

				public List<Brand> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<Brand> details = new ArrayList<Brand>();
					while (rs.next()) {
						Brand brandDetails = new Brand();
						brandDetails.setBrandId(rs.getInt("brand_id"));
						brandDetails.setBrandName(utils.decrypt(rs.getString("name")));
						details.add(brandDetails);
					}
					return details;
				}
			});
			return detailsList;
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int isExistingTrackCmapaignNamePut(TrackCampaign campaign) {
		// TODO Auto-generated method stub

		try {
			logger.info("Entered into the function isExistingtrackCmapaignName");
			String query = pfrQueries.getValue("qivr.get.track.campign.duplicate");
			PreparedStatementSetter pss = null;
			pss = new PreparedStatementSetter() {

				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, campaign.getCampaignName());

				}
			};

			JdbcTemplate jd = utils.getDBConnection(campaign.getAgencyId());

			int id = jd.query(query, pss, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					Integer proId = 0;
					while (rs.next()) {
						proId = rs.getInt("count");

					}

					return proId;
				}
			});
			return id;
		} catch (Exception e) {
			logger.error(e.toString());
			return 0;
		}
	}

	@Override
	public List<LinksCampaign> getLinks(int agencyId) {
		try {
			List<LinksCampaign> campaigns = new ArrayList<LinksCampaign>();
			logger.info("Entered into the function getLinks");
			String query = pfrQueries.getValue("qivr.get.track.campign.links");
			PreparedStatementSetter pss = null;
			pss = new PreparedStatementSetter() {

				public void setValues(PreparedStatement ps) throws SQLException {

				}
			};

			JdbcTemplate jd = utils.getDBConnection(agencyId);

			campaigns = jd.query(query, pss, new ResultSetExtractor<List<LinksCampaign>>() {

				public List<LinksCampaign> extractData(ResultSet rs) throws SQLException, DataAccessException {

					List<LinksCampaign> campaignsList = new ArrayList<LinksCampaign>();
					while (rs.next()) {
						LinksCampaign tcampaigns = new LinksCampaign();
						tcampaigns.setCampaignId(rs.getInt("id"));
						tcampaigns.setCampaignName(rs.getString("campaign_name"));
						tcampaigns.setObjectiveId(rs.getInt("objective_id"));
						tcampaigns.setBrandId(rs.getInt("brand_id"));
						tcampaigns.setCompanyId(rs.getInt("company_id"));
						tcampaigns.setTimeLine(rs.getString("time_line"));
						Array arr1 = rs.getArray("influencers");
						if (arr1 != null) {
							Integer[] infs = (Integer[]) arr1.getArray();
							tcampaigns.setInfluencers(infs);
						}

						String links = rs.getString("links");

						JSONArray array = new JSONArray(links);

//						Map<Integer,String> map = new HashMap<>(); 
//						
//						for(int i=0;i<array.length();i++) {
//							JSONObject obj = array.getJSONObject(i);
//							map.put(obj.getInt("id"),obj.getString("path"));
//						}
						tcampaigns.setLinks(links);
						tcampaigns.setAgencyId(agencyId);
						tcampaigns.setKpi(rs.getString("obj_kpi"));
						tcampaigns.setBrands(rs.getString("brands_competitors"));
						Brand b = getBrandById(tcampaigns.getBrandId(),jd);
						tcampaigns.setBrandName(b.getBrandName());
						campaignsList.add(tcampaigns);
					}
					return campaignsList;
				}
			});
			return campaigns;
		} catch (Exception e) {
			logger.error(e.toString());
			return null;
		}
	}

	private StatusId getStatusValue(JdbcTemplate jcc) {
		try {
			logger.info("Entered into the function getTotalCampaignsAgency");
			StatusId statusId = new StatusId();
			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.track.manageCampaigns.objective.private");
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
				}
			};
			statusId = jcc.query(query, pss, new ResultSetExtractor<StatusId>() {

				public StatusId extractData(ResultSet rs) throws SQLException, DataAccessException {
					StatusId ob = new StatusId();
					while (rs.next()) {
						int value = rs.getInt("status_id");
						if (value == Integer.parseInt(pfrConstants.getValue("qritrim.inf.status.completed")))
							ob.setCompleted(rs.getInt("count"));
						else if (value == Integer.parseInt(pfrConstants.getValue("qritrim.inf.status.tracking")))
							ob.setTracking(rs.getInt("count"));
						else if (value == Integer.parseInt(pfrConstants.getValue("qritrim.inf.status.optimizing")))
							ob.setOptimizing(rs.getInt("count"));
					}
					return ob;
				}
			});
			return statusId;
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return null;
		}
	}

	public int updatePastCampaigns(JdbcTemplate jt) {
		// TODO Auto-generated method stub
		int value = 0;
		try {
			logger.info("entered into updatePastCampaigns");
			String query = pfrQueries.getValue("qivr.get.track.campign.links");
			List<Campaign> campaigns = new ArrayList<>();
			campaigns = jt.query(query, new ResultSetExtractor<List<Campaign>>() {

				public List<Campaign> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<Campaign> campaignList = new ArrayList<Campaign>();
					while (rs.next()) {
						Campaign campaign = new Campaign();
						campaign.setTimeLine(rs.getString("time_line"));
						campaign.setCampaignId(rs.getInt("id"));
						campaignList.add(campaign);
					}

					return campaignList;
				}
			});
			List<Integer> ids = new ArrayList<Integer>();
			for (int i = 0; i < campaigns.size(); i++) {
				String timeLine = campaigns.get(i).getTimeLine();
				if (timeLine != null) {
					JSONObject jsonObject = new JSONObject(timeLine);
					String sDate = (String) jsonObject.get("endDate");

					Date today = new Date();

					Calendar cal = Calendar.getInstance();
					cal.setTime(today);
					cal.set(Calendar.HOUR_OF_DAY, 0);
					cal.set(Calendar.MINUTE, 0);
					cal.set(Calendar.SECOND, 0);
					cal.set(Calendar.MILLISECOND, 0);
					today = cal.getTime();

					SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
					try {
						Date endDate = formatter5.parse(sDate);

						// System.out.println("endDate --- " + endDate);
						// System.out.println("today --- " + today);
						long diff = endDate.getTime() - today.getTime();
						// System.out.println("Diff ===== " + diff);
						if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) < 1) {
							System.out.println(ids.add(campaigns.get(i).getCampaignId()));
						}
						// System.out.println(campaigns.get(i).getCampaignId());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println(ids);
			try {
				String query2 = pfrQueries.getValue("qivr.update.campaign.status");
				String commaSeparatedNumbers = ids.stream().map(i -> i.toString()).collect(Collectors.joining(", "));
				int statusId = Integer.parseInt(pfrConstants.getValue("qritrim.status.id.past"));
				PreparedStatementSetter pss = null;

				pss = new PreparedStatementSetter() {

					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, statusId);
						ps.setString(2, commaSeparatedNumbers);

					}
				};
				value = jt.update(query2, pss);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

	@Override
	public int saveInfData(SaveList data) {
		int updatedCount = 0;
		List<String> names = new ArrayList<String>();
		try {
			logger.info("Entered ino the function saveInfData in trackManagementDaoImpl");

			String query = pfrQueries.getValue("qivr.post.influencerlist");

			String query2 = pfrQueries.getValue("qivr.get.listname.influencerlist");

			JdbcTemplate jd = utils.getDBConnection(data.getAgencyId());
			Connection con = jd.getDataSource().getConnection();

			names = jd.query(query2, new ResultSetExtractor<List<String>>() {

				public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<String> values = new ArrayList<String>();
					while (rs.next()) {
						values.add(rs.getString("list_name"));
					}

					return values;
				}
			});
			int count = 0;
			for (String name : names) {
				if (name.equals(data.getListName()))
					count++;
			}

			// System.out.println("count----------"+count);
			if (count == 0) {
				PreparedStatementSetter pss = null;
				pss = new PreparedStatementSetter() {

					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, data.getInfluencerCount());
						ps.setString(2, data.getListName());
						ps.setArray(3, con.createArrayOf("int", data.getInfIds()));

					}
				};
				updatedCount = jd.update(query, pss);
				System.out.println(updatedCount);
			} else {
				return 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return updatedCount;
	}

	@Override
	public List<SaveList> findSaveList(int agencyId) {
		// TODO Auto-generated method stub
		List<SaveList> list = new ArrayList<SaveList>();
		try {
			logger.info("Entered ino the function findSaveList in DiscoverInfluencerDAOImpl");
			JdbcTemplate je = utils.getDBConnection(agencyId);
			String query = pfrQueries.getValue("qivr.get.listname.influencerlist");
			PreparedStatementSetter pss = null;
			pss = new PreparedStatementSetter() {
				public void setValues(PreparedStatement ps) throws SQLException {
				}
			};
			list = je.query(query, new ResultSetExtractor<List<SaveList>>() {

				public List<SaveList> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<SaveList> values = new ArrayList<SaveList>();
					while (rs.next()) {
						SaveList slist = new SaveList();
						slist.setId(rs.getInt("id"));
						slist.setListName(rs.getString("list_name"));
						slist.setInfluencerCount(rs.getInt("influencer_count"));
						slist.setCreatedOn(rs.getTimestamp("created"));
						Array arr1 = rs.getArray("influencer_ids");
						if (arr1 != null) {
							String[] infs = (String[]) arr1.getArray();
							slist.setInfIds(infs);
						}
						values.add(slist);
					}

					return values;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return list;
	}

	@Override
	public List<SaveList> companybranddecoded(int agencyId) {
		List<SaveList> list = new ArrayList<SaveList>();
		try {
			logger.info("Entered ino the function company in DiscoverInfluencerDAOImpl");
			JdbcTemplate je = utils.getDBConnection(agencyId);
			String query = "select company_id,company_name from company";
			List<Company> companys = new ArrayList<>();
			companys = je.query(query, new ResultSetExtractor<List<Company>>() {

				public List<Company> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<Company> values = new ArrayList<Company>();
					while (rs.next()) {
						Company company = new Company();
						company.setCompanyId(rs.getInt("company_id"));
						company.setCompanyName(qutils.decrypt(rs.getString("company_name")));
						values.add(company);
					}
					return values;
				}
			});
			String insertQuery = "update company set cname = ? where company_id = ?";

			for (Company c : companys) {
				PreparedStatementSetter pss = null;
				pss = new PreparedStatementSetter() {
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, c.getCompanyName());
						ps.setInt(2, c.getCompanyId());
					}
				};
				int value = je.update(insertQuery, pss);
			}

			logger.info("Entered ino the function brand in DiscoverInfluencerDAOImpl");
			// JdbcTemplate je = utils.getDBConnection(agencyId);
			String query2 = "select brand_id,name from brand";
			List<Brand> brands = new ArrayList<>();
			brands = je.query(query2, new ResultSetExtractor<List<Brand>>() {

				public List<Brand> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<Brand> values = new ArrayList<Brand>();
					while (rs.next()) {
						Brand brand = new Brand();
						brand.setBrandId(rs.getInt("brand_id"));
						brand.setBrandName(qutils.decrypt(rs.getString("name")));
						values.add(brand);
					}
					return values;
				}
			});
			String insertQuery2 = "update brand set bname = ? where brand_id = ?";

			for (Brand c : brands) {
				PreparedStatementSetter pss = null;
				pss = new PreparedStatementSetter() {
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, c.getBrandName());
						ps.setInt(2, c.getBrandId());
					}
				};
				int value = je.update(insertQuery2, pss);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public int existingCampaignName(String name, int agencyId) {
		// TODO Auto-generated method stub

		try {
			logger.info("Entered into the function isExistingCmapaignName");
			String query = pfrQueries.getValue("qivr.get.track.campign.duplicate");
			PreparedStatementSetter pss = null;
			pss = new PreparedStatementSetter() {

				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, name);

				}
			};

			JdbcTemplate jd = utils.getDBConnection(agencyId);

			int id = jd.query(query, pss, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					Integer proId = null;
					while (rs.next()) {
						proId = rs.getInt("count");

					}

					return proId;
				}
			});
			return id;
		} catch (Exception e) {
			logger.error(e.toString());
			return 0;
		}
	}

	@Override
	public int existingListName(String listName, int agencyId) {
		try {
			logger.info("Entered into the function existingListName");
			List<String> names = new ArrayList<String>();
			String query2 = pfrQueries.getValue("qivr.get.listname.influencerlist");

			JdbcTemplate jd = utils.getDBConnection(agencyId);

			names = jd.query(query2, new ResultSetExtractor<List<String>>() {

				public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<String> values = new ArrayList<String>();
					while (rs.next()) {
						values.add(rs.getString("list_name"));
					}

					return values;
				}
			});
			int count = 0;
			for (String name : names) {
				if (name.equals(listName)) {
					System.out.println("list_names-----------:"+name);
					count++;
				}
			}
			System.out.println(count);
			return count;
		} catch (Exception e) {
			logger.error(e.toString());
			return 0;
		}
	}
	public Brand getBrandById(int brandId,JdbcTemplate jc) {
		Brand brand = new Brand();
		try {
			logger.info("Entered into the function getBrandById");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.brand.get.id");

			pss = new PreparedStatementSetter() {

				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, brandId);

				}
			};

			brand = jc.query(query, pss, new ResultSetExtractor<Brand>() {

				public Brand extractData(ResultSet rs) throws SQLException, DataAccessException {

					Brand brandData = new Brand();
					while (rs.next()) {
						//brandData.setBrandName(decrypt(rs.getString("name")));
						brandData.setBrandName(rs.getString("name"));
						brandData.setBrandId(brandId);
					}
					return brandData;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			//e.printStackTrace();
//		   return null;
		}
		return brand;
	}

}
