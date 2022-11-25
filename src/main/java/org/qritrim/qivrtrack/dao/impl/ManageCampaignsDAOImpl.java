package org.qritrim.qivrtrack.dao.impl;

import java.sql.Array;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.qritrim.qivrtrack.dao.ManageCampaignsDAO;
import org.qritrim.qivrtrack.model.Brand;
import org.qritrim.qivrtrack.model.CampaignCount;
import org.qritrim.qivrtrack.model.CampaignTypeStatus;
import org.qritrim.qivrtrack.model.CompanyDetails;
import org.qritrim.qivrtrack.model.CompanyDetailsSummary;
import org.qritrim.qivrtrack.model.InfluencersEngaged;
import org.qritrim.qivrtrack.model.ManageCampaigns;
import org.qritrim.qivrtrack.model.ManageCompanies;
import org.qritrim.qivrtrack.model.Networks;
import org.qritrim.qivrtrack.model.SealDeal;
import org.qritrim.qivrtrack.model.clauses;
import org.qritrim.qivrtrack.utils.PropertyFileReader;
import org.qritrim.qivrtrack.utils.QivrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class ManageCampaignsDAOImpl implements ManageCampaignsDAO {

	@Autowired
	@Qualifier("queries")
	PropertyFileReader pfrQueries;

	private static final Logger logger = LogManager.getLogger(ManageCampaignsDAOImpl.class);

	@Autowired
	@Qualifier("application")
	PropertyFileReader pfrApp;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	QivrUtils qutils;
	
	@Qualifier(value = "constants")
	@Autowired
	PropertyFileReader pfrConstants;

	

	public CompanyDetailsSummary getCompanyDetailsSummary(int companyId) {
		CompanyDetailsSummary companyDetailsSummary = new CompanyDetailsSummary();
		try {
			logger.info("Entered into the function getCompanyDetailsSummary");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.companies.companyDetailsSummary");

			pss = new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setInt(1, companyId);

				}
			};

			companyDetailsSummary = jdbcTemplate.query(query, pss, new ResultSetExtractor<CompanyDetailsSummary>() {

				public CompanyDetailsSummary extractData(ResultSet rs) throws SQLException, DataAccessException {

					CompanyDetailsSummary companyDetailsList = new CompanyDetailsSummary();
					while (rs.next()) {
						companyDetailsList.setCompanyId(rs.getInt("company_id"));
						companyDetailsList.setCompany(qutils.decrypt(rs.getString("company_name")));
						companyDetailsList.setUploaded(rs.getString("created"));
						companyDetailsList.setBrandsCount(rs.getInt("count"));
						companyDetailsList.setCompanyLogoUrl(rs.getString("company_logo_url"));
						companyDetailsList.setCampaignCount(getCampaignCountCompany(companyId));
						String str = rs.getString("brands");
						String[] brandsList = str.split(",");
						System.out.println(brandsList);
						ArrayList<String> decryptBrandList = new ArrayList<String>();

						for (int i = 0; i < brandsList.length; i++) {
							String bn = qutils.decrypt(brandsList[i]);
							decryptBrandList.add(bn);
						}
						companyDetailsList.setBrandsList(decryptBrandList);
					}
					return companyDetailsList;
				}

			});

		} catch (Exception e) {
			logger.error(e.toString());
			//e.printStackTrace();
//		return null;
		}
		return companyDetailsSummary;
	}

	private int getCampaignCountCompany(int companyId) {
		// TODO Auto-generated method stub
		int campaignCount = 0;
		PreparedStatementSetter pss = null;
		String query = pfrQueries.getValue("qivr.get.campaignCountCompany");
		pss = new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, companyId);
			}
		};
		campaignCount = jdbcTemplate.query(query, pss, new ResultSetExtractor<Integer>() {

			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

				Integer count = 0;
				while (rs.next()) {
					count = rs.getInt("count");
				}
				return count;
			}
		});

		return campaignCount;
	}

	public List<CompanyDetails> getCompanyDetailsGrid(int companyId, int agencyId) {
		List<CompanyDetails> companyDetailsGrid = new ArrayList<CompanyDetails>();

		List<CompanyDetails> finalCompanyList = new ArrayList<CompanyDetails>();

		try {

			PreparedStatementSetter pss = null;
			String brandQuery = pfrQueries.getValue("qivr.get.brand.companyId");
			List<Brand> brandList = new ArrayList<Brand>();

			pss = new PreparedStatementSetter() {

				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, companyId);

				}
			};

			brandList = jdbcTemplate.query(brandQuery, pss, new ResultSetExtractor<List<Brand>>() {

				public List<Brand> extractData(ResultSet rs) throws SQLException, DataAccessException {

					List<Brand> brands = new ArrayList<Brand>();
					while (rs.next()) {
						Brand brand = new Brand();
						brand.setBrandId(rs.getInt("brand_id"));
						brand.setBrandName(rs.getString("name"));

						brands.add(brand);
					}
					return brands;
				}
			});

			for (Brand brand : brandList) {

				PreparedStatementSetter pss1 = null;
				String campaignQuery = pfrQueries.getValue("qivr.get.campaign.brandId");
//				List<Brand> brandList = new ArrayList<Brand>();

				pss1 = new PreparedStatementSetter() {

					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setInt(1, brand.getBrandId());

					}
				};

				companyDetailsGrid = jdbcTemplate.query(campaignQuery, pss1,
						new ResultSetExtractor<List<CompanyDetails>>() {

							public List<CompanyDetails> extractData(ResultSet rs)
									throws SQLException, DataAccessException {

								List<CompanyDetails> companyList = new ArrayList<CompanyDetails>();
								while (rs.next()) {
									CompanyDetails compayDetail = new CompanyDetails();

									compayDetail.setCampaignId(rs.getInt("campaign_id"));
									Integer projectId = rs.getInt("campaign_id");
									compayDetail.setBrandId(brand.getBrandId());
									compayDetail.setCampaignName(rs.getString("campaign_name"));
									compayDetail.setBrandName(qutils.decrypt(brand.getBrandName()));
									compayDetail.setCreated(rs.getString("created"));

									Array campCat = rs.getArray("category_id");
									if (campCat != null) {
										Integer[] categories = (Integer[]) campCat.getArray();
										compayDetail.setCampaignCategory(categories);
									}

									int campStatus = rs.getInt("project_status_id");
									compayDetail.setCampaignStatus(campStatus);
									if (campStatus == 2) {
										ArrayList<Integer> infIds = getInfluencerIds(projectId);
										compayDetail.setInfIds(infIds);
									}

									compayDetail.setObjId(rs.getInt("objId"));

									companyList.add(compayDetail);
									finalCompanyList.add(compayDetail);
								}
								if (!(companyList.size() > 0)) {
									CompanyDetails company = new CompanyDetails();
									company.setBrandId(brand.getBrandId());
									company.setBrandName(qutils.decrypt(brand.getBrandName()));

									companyList.add(company);
									finalCompanyList.add(company);
								}
								return companyList;
							}
						});

//				finalCompanyList.add((CompanyDetails) companyDetailsGrid);
			}

//	  logger.info("Entered into the function getCompanyDetailsGrid");
//		
//		PreparedStatementSetter pss = null;
//		String query = pfrQueries.getValue("qivr.companies.companyDetails");
//
//		pss = new PreparedStatementSetter() {
//
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				// TODO Auto-generated method stub
//				ps.setInt(1, companyId);
//
//			}
//		};
//
//		companyDetailsGrid = jdbcTemplate.query(query, pss, new ResultSetExtractor<List<CompanyDetails>>() {
//
//			public List<CompanyDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
//
//				List<CompanyDetails> companyDetailsList = new ArrayList<CompanyDetails>();
//				while (rs.next()) {
//					CompanyDetails manageCompaniesGrid = new CompanyDetails();
//					InfluencersEngaged inf = new InfluencersEngaged();
////					Integer projectId = rs.getInt("project_id");
//					manageCompaniesGrid.setCampaignId(rs.getInt("campaign_id"));
//					Integer projectId = rs.getInt("campaign_id");
////					HashMap<Integer, String> influencers = getInfluencersEngaged(projectId, agencyId);
////					HashMap<Integer, String> influencerNames = getInfluencersNames(projectId, agencyId);
//
////					inf.setInfluencerNames(influencerNames.get(projectId));
////					inf.setImageUrls(influencers.get(projectId));
//					
//					
//					
//					manageCompaniesGrid.setBrandId(rs.getInt("brand_id"));
//					manageCompaniesGrid.setCampaignName(rs.getString("campaignName"));
//					manageCompaniesGrid.setBrandName(qutils.decrypt(rs.getString("brandname")));
//					manageCompaniesGrid.setCreated(rs.getString("created"));
////					manageCompaniesGrid.setNetworks(rs.getString("networks"));
//					
//					Array campCat = rs.getArray("category_id");
//					if (campCat != null) {
//						Integer[] categories = (Integer[]) campCat.getArray();
//						manageCompaniesGrid.setCampaignCategory(categories);
//					}
//					
//					int campStatus = rs.getInt("projectStatus");
//					manageCompaniesGrid.setCampaignStatus(campStatus);
//					if(campStatus == 2) {
//						ArrayList<Integer> infIds = getInfluencerIds(projectId);
//						manageCompaniesGrid.setInfIds(infIds);
//					}
////					manageCompaniesGrid.setCategoryId(rs.getInt("category_id"));
//
//// 					manageCompaniesGrid.setInfluencers(inf);
//
////					manageCompaniesGrid.setCategory(rs.getString("categoryname"));
////					manageCompaniesGrid.setInfluencers(inf);
//
//					manageCompaniesGrid.setObjId(rs.getInt("objId"));
//					companyDetailsList.add(manageCompaniesGrid);
//				}
//				return companyDetailsList;
//			}
//		});

		} catch (Exception e) {
			logger.error(e.toString());
			//e.printStackTrace();
//		return null;
		}
//		return companyDetailsGrid;
		return finalCompanyList;
	}

	public ArrayList<Integer> getInfluencerIds(int projectId) {
		ArrayList<Integer> infIds = new ArrayList<Integer>();
		try {
			String query = pfrQueries.getValue("qivr.inf.ids.campId");
			PreparedStatementSetter pss = new PreparedStatementSetter() {
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, projectId);

				}
			};

			infIds = jdbcTemplate.query(query, pss, new ResultSetExtractor<ArrayList<Integer>>() {

				public ArrayList<Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {

					ArrayList<Integer> influencers = new ArrayList<Integer>();
					while (rs.next()) {
						influencers.add(rs.getInt("source_inf_id"));
					}
					return influencers;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			//e.printStackTrace();
//			return null;
		}
		return infIds;
	}

	public List<ManageCampaigns> getCampaignDetails(int agencyId, String status) {
		List<ManageCampaigns> campaigns = new ArrayList<ManageCampaigns>();
		try {
			logger.info("Entered into the function getCampaignDetails");

//			String total = pfrConstants.getValue("qritrim.status.id.total");
//			String active = pfrConstants.getValue("qritrim.status.id.active");
//			String draft = pfrConstants.getValue("qritrim.status.is.draft");
//			String past = pfrConstants.getValue("qritrim.status.is.past");
			PreparedStatementSetter pss = null;
			String query = null;
			if (status.equalsIgnoreCase("total") || status.equalsIgnoreCase("past")) {
				query = pfrQueries.getValue("qivr.campaigns.total");
//				pss = new PreparedStatementSetter() {
//
//					@Override
//					public void setValues(PreparedStatement ps) throws SQLException {
//						// TODO Auto-generated method stub
//						if (!(status.equals("total"))) {
//							ps.setInt(1, Integer.parseInt(statusValue));
//						} 
//					}
//				};
			} else {
				String const1 = "qritrim.status.id." + status.toLowerCase();
				String statusValue = pfrConstants.getValue(const1);
				int stats = Integer.parseInt(statusValue);
				query = pfrQueries.getValue("qivr.campaigns.status");
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
			
			JdbcTemplate jmc = qutils.getDBConnection(agencyId);
			
			campaigns = jmc.query(query, pss, new ResultSetExtractor<List<ManageCampaigns>>() {

				public List<ManageCampaigns> extractData(ResultSet rs) throws SQLException, DataAccessException {

					List<ManageCampaigns> campaignsList = new ArrayList<ManageCampaigns>();
					while (rs.next()) {
						String timeLine = rs.getString("time_line");
						int campCount=0;
						if (timeLine!=null && !status.equals("past") && !status.equals("total")) {
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

							//	System.out.println("endDate --- " + endDate);
							//	System.out.println("today --- " + today);
								long diff = endDate.getTime() - today.getTime();
							//	System.out.println("Diff ===== " + diff);
								if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) >= 1) {
									campCount ++;
								}
							
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else if(status.equals("past")) {
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

							//	System.out.println("endDate --- " + endDate);
							//	System.out.println("today --- " + today);
								long diff = endDate.getTime() - today.getTime();
							//	System.out.println("Diff ===== " + diff);
								if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) < 1) {
									campCount ++;
								}
							
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else {
							campCount++;
						}
						ManageCampaigns manageCampaigns = new ManageCampaigns();

						manageCampaigns.setCampaignId(rs.getInt("campaign_id"));
						manageCampaigns.setCampaignName(rs.getString("campaign_name"));
						manageCampaigns.setObjectiveId(rs.getInt("objective_id"));
						manageCampaigns.setCreated(rs.getString("created"));
						manageCampaigns.setCatergoryId(rs.getInt("category_id"));
						manageCampaigns.setStatusId(rs.getInt("status_id"));
						Array arr = rs.getArray("influencers_invited");
						if(arr != null) {
						Integer[] infls = (Integer[])arr.getArray();
						manageCampaigns.setInfluencersInvited(infls.length);
						}
						else
							manageCampaigns.setInfluencersInvited(0);
						Array networkIds = rs.getArray("network_id");
						Integer[] networks = (Integer[])networkIds.getArray();
						manageCampaigns.setNetworkId(networks);
						if(campCount>0)
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

//	@SuppressWarnings("null")
	public List<ManageCompanies> getCompanyDetails(int agencyId) {
		List<ManageCompanies> companies = new ArrayList<ManageCompanies>();
		try {
			logger.info("Entered into the function getCompanyDetails");

			HashMap<Integer, ArrayList<String>> brandName = getBrandName(agencyId);
			HashMap<Integer, String> companyName = getcompanyName(agencyId);
			HashMap<Integer, Integer> totalCamp = getTotalCampaigns(agencyId);
			HashMap<Integer, Integer> activeCamp = getActiveCampaigns(agencyId);
			HashMap<Integer, Integer> draftCamp = getDraftCampaigns(agencyId);

			System.out.println("The set is: " + brandName.keySet());

			Iterator<Integer> iterator = brandName.keySet().iterator();
			while (iterator.hasNext()) {
				ManageCompanies manageCompanyData = new ManageCompanies();
				Integer element = iterator.next();
				manageCompanyData.setCompanyId(element);
				manageCompanyData.setCompanyName(companyName.get(element));
				String CompanyLogoUrl = getCompanyLogoUrl(element);
				manageCompanyData.setCompanyLogoUrl(CompanyLogoUrl);
//			  manageCompanyData.setBrands(brandName.get(element));
				manageCompanyData.setBrandList(brandName.get(element));
				if (totalCamp.containsKey(element)) {
					manageCompanyData.setTotalCampaigns(totalCamp.get(element));
				}
				if (activeCamp.containsKey(element)) {
					manageCompanyData.setActiveCampaigns(activeCamp.get(element));
				}
				if (draftCamp.containsKey(element)) {
					manageCompanyData.setDraftCampaigns(draftCamp.get(element));
				}

				companies.add(manageCompanyData);
			}

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//		return null;
			// TODO: handle exception
		}
		return companies;
	}

	private String getCompanyLogoUrl(Integer companyId) {
		// TODO Auto-generated method stub
		String url = null;
		PreparedStatementSetter pss = null;
		String query = pfrQueries.getValue("qivr.companies.getCompanyUrl");
		pss = new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, companyId);
			}
		};
		url = jdbcTemplate.query(query, pss, new ResultSetExtractor<String>() {

			public String extractData(ResultSet rs) throws SQLException, DataAccessException {

				String logoUrl = null;
				while (rs.next()) {
					logoUrl = rs.getString("company_logo_url");
				}
				return logoUrl;
			}
		});

		return url;
	}

	private HashMap<Integer, String> getInfluencersNames(int projectId, int agencyId) {
		HashMap<Integer, String> inf = new HashMap<Integer, String>();
		try {
			logger.info("Entered into the function getInfluencersNames");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.companies.influencersEngaged");
			pss = new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setInt(1, projectId);
					ps.setInt(2, agencyId);
				}
			};
			inf = jdbcTemplate.query(query, pss, new ResultSetExtractor<HashMap<Integer, String>>() {

				public HashMap<Integer, String> extractData(ResultSet rs) throws SQLException, DataAccessException {

					HashMap<Integer, String> influencers = new HashMap<Integer, String>();
					while (rs.next()) {
						System.out.println("************influencers");
						System.out.println(rs);
						influencers.put(rs.getInt("campaign_id"), rs.getString("influencer"));

					}
					return influencers;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
		return inf;
	}

	private HashMap<Integer, String> getInfluencersEngaged(int projectId, int agencyId) {
		HashMap<Integer, String> inf = new HashMap<Integer, String>();
		try {
			logger.info("Entered into the function getInfluencersEngaged");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.companies.influencersEngaged");
			pss = new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setInt(1, projectId);
					ps.setInt(2, agencyId);
				}
			};
			inf = jdbcTemplate.query(query, pss, new ResultSetExtractor<HashMap<Integer, String>>() {

				public HashMap<Integer, String> extractData(ResultSet rs) throws SQLException, DataAccessException {

					HashMap<Integer, String> influencers = new HashMap<Integer, String>();
					while (rs.next()) {
						System.out.println("************influencers");
						System.out.println(rs);
						influencers.put(rs.getInt("campaign_id"), rs.getString("image"));

					}
					return influencers;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//		return null;
			// TODO: handle exception
		}
		return inf;
	}

	private HashMap<Integer, ArrayList<String>> getBrandName(int agencyId) {
		HashMap<Integer, ArrayList<String>> brands = new HashMap<Integer, ArrayList<String>>();
		try {
			logger.info("Entered into the function getBrandName");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.companies.engagedCompanies");
			pss = new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setInt(1, agencyId);

				}
			};
			brands = jdbcTemplate.query(query, pss, new ResultSetExtractor<HashMap<Integer, ArrayList<String>>>() {

				public HashMap<Integer, ArrayList<String>> extractData(ResultSet rs)
						throws SQLException, DataAccessException {

					HashMap<Integer, ArrayList<String>> brandData = new HashMap<Integer, ArrayList<String>>();
					while (rs.next()) {
						System.out.println("************brands");
						System.out.println(rs);
						String str = rs.getString("brand_name");
						String[] namesList = str.split(",");
						System.out.println(namesList);
						ArrayList<String> decryptBrandList = new ArrayList<String>();

						for (int i = 0; i < namesList.length; i++) {
							String bn = qutils.decrypt(namesList[i]);
							decryptBrandList.add(bn);
						}

						brandData.put(rs.getInt("company_id"), decryptBrandList);

					}
					return brandData;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//		return null;
			// TODO: handle exception
		}
		return brands;
	}

	private HashMap<Integer, String> getcompanyName(int agencyId) {
		HashMap<Integer, String> company = new HashMap<Integer, String>();
		try {
			logger.info("Entered into the function getcompanyName");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.companies.engagedCompanies");
			pss = new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setInt(1, agencyId);

				}
			};
			company = jdbcTemplate.query(query, pss, new ResultSetExtractor<HashMap<Integer, String>>() {

				public HashMap<Integer, String> extractData(ResultSet rs) throws SQLException, DataAccessException {

					HashMap<Integer, String> brandData = new HashMap<Integer, String>();
					while (rs.next()) {
						System.out.println("************brands");
						System.out.println(rs);
						brandData.put(rs.getInt("company_id"), qutils.decrypt(rs.getString("company_name")));

					}
					return brandData;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//		return null;
			// TODO: handle exception
		}
		return company;
	}

	private HashMap<Integer, Integer> getTotalCampaigns(int agencyId) {
		HashMap<Integer, Integer> totalCamp = new HashMap<Integer, Integer>();
		try {
			logger.info("Entered into the function getTotalCampaigns");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.companies.totalCampaigns");
			pss = new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setInt(1, agencyId);

				}
			};
			totalCamp = jdbcTemplate.query(query, pss, new ResultSetExtractor<HashMap<Integer, Integer>>() {

				public HashMap<Integer, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {

					HashMap<Integer, Integer> camp = new HashMap<Integer, Integer>();
					while (rs.next()) {
						System.out.println("************total campaigns");
						System.out.println(rs);
						camp.put(rs.getInt("company_id"), rs.getInt("count"));

					}
					return camp;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//		return null;
			// TODO: handle exception
		}
		return totalCamp;
	}

	private HashMap<Integer, Integer> getActiveCampaigns(int agencyId) {
		HashMap<Integer, Integer> activeCamp = new HashMap<Integer, Integer>();
		try {
			logger.info("Entered into the function getActiveCampaigns");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.companies.activeCampaigns");
			pss = new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setInt(1, agencyId);

				}
			};
			activeCamp = jdbcTemplate.query(query, pss, new ResultSetExtractor<HashMap<Integer, Integer>>() {

				public HashMap<Integer, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {

					HashMap<Integer, Integer> camp = new HashMap<Integer, Integer>();
					while (rs.next()) {
						System.out.println("************active campaigns");
						System.out.println(rs);
						camp.put(rs.getInt("company_id"), rs.getInt("count"));

					}
					return camp;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//		return null;
			// TODO: handle exception
		}
		return activeCamp;
	}

	private HashMap<Integer, Integer> getDraftCampaigns(int agencyId) {
		HashMap<Integer, Integer> draftCamp = new HashMap<Integer, Integer>();
		try {
			logger.info("Entered into the function getDraftCampaigns");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.companies.draftCampaigns");
			pss = new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setInt(1, agencyId);

				}
			};
			draftCamp = jdbcTemplate.query(query, pss, new ResultSetExtractor<HashMap<Integer, Integer>>() {

				public HashMap<Integer, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {

					HashMap<Integer, Integer> camp = new HashMap<Integer, Integer>();
					while (rs.next()) {
						System.out.println("************draft campaigns");
						System.out.println(rs);
						camp.put(rs.getInt("company_id"), rs.getInt("count"));

					}
					return camp;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//		return null;
			// TODO: handle exception
		}
		return draftCamp;
	}

	public ArrayList<Integer> getInfluencerList(int campaignId) {
		ArrayList<Integer> infList = new ArrayList<Integer>();
		try {
			logger.info("Entered into the function getDraftCampaigns");
			String infQuery = pfrQueries.getValue("qivr.inf.campaign.enagaged.campaignId");

			PreparedStatementSetter pss = new PreparedStatementSetter() {

				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, campaignId);

				}
			};

			infList = jdbcTemplate.query(infQuery, pss, new ResultSetExtractor<ArrayList<Integer>>() {

				public ArrayList<Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {

					ArrayList<Integer> influencerList = new ArrayList<Integer>();
					while (rs.next()) {
						int infId = rs.getInt("source_inf_id");
						influencerList.add(Integer.valueOf(infId));

					}
					return influencerList;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//			return null;
		}
		return infList;

	}

	public ArrayList<HashMap<String, Integer>> getInfluencerStatusList(int campaignId) {
//		Map<String, Integer> infList = new HashMap<String, Integer>();
		ArrayList<HashMap<String, Integer>> infList = new ArrayList<HashMap<String, Integer>>();
		try {
			logger.info("Entered into the function getDraftCampaigns");
			String infQuery = pfrQueries.getValue("qivr.inf.campaign.enagaged.campaignId");

			PreparedStatementSetter pss = new PreparedStatementSetter() {

				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, campaignId);

				}
			};

			infList = jdbcTemplate.query(infQuery, pss, new ResultSetExtractor<ArrayList<HashMap<String, Integer>>>() {

				public ArrayList<HashMap<String, Integer>> extractData(ResultSet rs)
						throws SQLException, DataAccessException {

					ArrayList<HashMap<String, Integer>> influencerList = new ArrayList<HashMap<String, Integer>>();
//					ArrayList<Integer> statusIds = new ArrayList<Integer>();

					while (rs.next()) {
						HashMap<String, Integer> infMap = new HashMap<String, Integer>();
						infMap.put("infId", rs.getInt("source_inf_id"));
						infMap.put("status", rs.getInt("status_id"));
//						int infId = rs.getInt("source_inf_id");
						influencerList.add(infMap);

					}
					return influencerList;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//			return null;
		}
		return infList;

	}

	public ArrayList<HashMap<String, Integer>> getActiveInfluencerStatusList(int campaignId) {
//		Map<String, Integer> infList = new HashMap<String, Integer>();
		ArrayList<HashMap<String, Integer>> infList = new ArrayList<HashMap<String, Integer>>();
		try {
			logger.info("Entered into the function getDraftCampaigns");
			String infQuery = pfrQueries.getValue("qivr.inf.campaign.active.campaignId");

			PreparedStatementSetter pss = new PreparedStatementSetter() {

				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, campaignId);

				}
			};

			infList = jdbcTemplate.query(infQuery, pss, new ResultSetExtractor<ArrayList<HashMap<String, Integer>>>() {

				public ArrayList<HashMap<String, Integer>> extractData(ResultSet rs)
						throws SQLException, DataAccessException {

					ArrayList<HashMap<String, Integer>> influencerList = new ArrayList<HashMap<String, Integer>>();
//					ArrayList<Integer> statusIds = new ArrayList<Integer>();

					while (rs.next()) {
						HashMap<String, Integer> infMap = new HashMap<String, Integer>();
						infMap.put("infId", rs.getInt("source_inf_id"));
						infMap.put("status", rs.getInt("status_id"));
//						int infId = rs.getInt("source_inf_id");
						influencerList.add(infMap);

					}
					return influencerList;
				}
			});

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//			return null;
		}
		return infList;

	}

	@Override
	public CampaignCount getCampaignCounts(int agencyId, JdbcTemplate jc) {
		CampaignCount campaignCount = new CampaignCount();
		try {
			logger.info("Entered into the function getCampaignCounts");

			Integer totalCampaigns = getTotalCampaignsAgency(agencyId, jc);
			Integer activeCampaigns = getactiveCampaignsAgency(agencyId, jc);
			Integer campaignsWaiting = getcampaignsWaitingAgency(agencyId, jc);
			Integer campaignsPast = getCampaignsPastAgency(agencyId,jc);
		  
			//Integer campaignsPast = Integer.valueOf(totalCampaigns.intValue() - (activeCampaigns.intValue() + campaignsWaiting.intValue()));
			campaignCount.setTotalCampaigns(totalCampaigns);
			campaignCount.setActiveCampaigns(activeCampaigns);
			campaignCount.setCampaignsWaiting(campaignsWaiting);
			campaignCount.setCampaignsPast(campaignsPast);
			
			
//			Integer campaignsInNegotiation = campaignsInNegotiation(agencyId);
//			HashMap<String,Integer> objectiveValues = getObjectiveValues(agencyId);
//          Integer campaignsInNegotiation = campaignsInNegotiation(agencyId);			
//
//			Integer IncreaseEngagement = objectiveValues.get("Increase Engagement");
//			Integer IncreaseBrandAwarness = objectiveValues.get("Increase Brand Awareness");
//			Integer IncreseSales = objectiveValues.get("Grow More Sales");
//
			
//			campaignCount.setIncreaseBrandSales(IncreseSales);
//			campaignCount.setIncreaseBrandEngagement(IncreaseEngagement);
//			campaignCount.setIncreaseBrandAwarness(IncreaseBrandAwarness);

			
//			campaignCount.setCampaignsInNegotiation(campaignsInNegotiation);

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//			return null;
		}
		return campaignCount;
	}


	private Integer getTotalCampaignsAgency(int agencyId, JdbcTemplate jc) {
		int totalCamp = 0;
		try {
			logger.info("Entered into the function getTotalCampaignsAgency");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.manageCampaigns.totalCampaignsOfAgency");
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
//					ps.setInt(1, agencyId);
				}
			};
			totalCamp = jc.query(query, pss, new ResultSetExtractor<Integer>() {

				public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
					Integer totalCampaigns = null;
					while (rs.next()) {
						totalCampaigns = rs.getInt("count");
					}
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

	public Integer getactiveCampaignsAgency(int agencyId, JdbcTemplate jc) {
		List<String> timelines = new ArrayList<>();
		int campCount = 0;
		int activeStatus = Integer.parseInt(pfrConstants.getValue("qritrim.status.id.active"));
		;
		try {
			logger.info("Entered into the function getactiveCampaignsAgency");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.manageCampaigns.activeCampaignsOfAgency");
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
			for(int i=0;i<timelines.size();i++) {
			String timeLine = timelines.get(i);
			if (timeLine!=null) {
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

				//	System.out.println("endDate --- " + endDate);
				//	System.out.println("today --- " + today);
					long diff = endDate.getTime() - today.getTime();
				//	System.out.println("Diff ===== " + diff);
					if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) >= 1) {
						campCount ++;
					}
				
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return 0;
		}
		return campCount;
	}

	public HashMap<String,Integer> getObjectiveValues(int agencyId) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		try {
			logger.info("Entered into the function getIncreaseBrandSales");

			String query = pfrQueries.getValue("qivr.get.manageCampaigns.objective");
			hm = jdbcTemplate.query(query, new ResultSetExtractor<HashMap<String,Integer>>() {

				public HashMap<String,Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
					HashMap<String, Integer> hm = new HashMap<String, Integer>();
					while (rs.next()) {
						System.out.println(rs.getString("name"));
						System.out.println(rs.getInt("count"));
						hm.put(rs.getString("name"), rs.getInt("count"));
					}
					return hm;
				}
			});
		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return hm;
		}
		return hm;
	}

	private Integer getcampaignsWaitingAgency(int agencyId, JdbcTemplate jc) {
		int campCount = 0;
		List<String> timelines = new ArrayList<>();
		int draftStatus = Integer.parseInt(pfrConstants.getValue("qritrim.status.id.draft"));
		try {
			logger.info("Entered into the function getcampaignsWaitingAgency");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.manageCampaigns.campaignsWaiting");
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setInt(1, draftStatus);
				}
			};
			timelines = jc.query(query, pss, new ResultSetExtractor<List<String>>() {

				public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<String> timelines = new ArrayList<>();
					while (rs.next()) {
						String timeline = rs.getString("time_line");
						timelines.add(timeline);
					}
					return timelines;
				}
			});
			System.out.println(timelines.size());
			for(int i=0;i<timelines.size();i++) {
			String timeLine = timelines.get(i);
			if (timeLine!=null) {
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

				//	System.out.println("endDate --- " + endDate);
				//	System.out.println("today --- " + today);
					long diff = endDate.getTime() - today.getTime();
				//	System.out.println("Diff ===== " + diff);
					if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) >= 1) {
						campCount ++;
					}
				
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return 0;
		}
		return campCount;
	}

	private Integer campaignsInNegotiation(int agencyId) {
		List<String> timelines = new ArrayList<>();
		int campCount = 0;
		int draftStatus = Integer.parseInt(pfrConstants.getValue("qritrim.status.is.draft"));
		String campNego = pfrConstants.getValue("qritrim.inf.nego.campaigns.staus");

		try {
			logger.info("Entered into the function getcampaignsWaitingAgency");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.manageCampaigns.campaignsNegotiationCount");
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setInt(1, agencyId);
					ps.setInt(2, draftStatus);
					ps.setString(3, campNego);
				}
			};
			timelines = jdbcTemplate.query(query, pss, new ResultSetExtractor<List<String>>() {

				public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
					Integer campaignsWaitingEngagement = null;
					List<String> timelines = new ArrayList<>();
					while (rs.next()) {
						String timeline = rs.getString("time_line");
						timelines.add(timeline);
					}
					return timelines;
				}
			});
			for(int i=0;i<timelines.size();i++) {
			String timeLine = timelines.get(i);
			if (timeLine!=null) {
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

				//	System.out.println("endDate --- " + endDate);
				//	System.out.println("today --- " + today);
					long diff = endDate.getTime() - today.getTime();
				//	System.out.println("Diff ===== " + diff);
					if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) > 1) {
						campCount ++;
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

	@Override
	public CampaignCount getCampaignsCreated(int agencyId) {
		CampaignCount totalCampaignsCreated = new CampaignCount();
		try {
			logger.info("Entered into the function getCampaignsCreated");
			totalCampaignsCreated.setTotalCampaigns(getTotalCampaignsAgency(agencyId, jdbcTemplate));

		} catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
//	       return 0;
		}
		return totalCampaignsCreated;
	}

	private Integer getCampaignsPastAgency(int agencyId, JdbcTemplate jc) {
		List<String> timelines = new ArrayList<>();
		int campCount = 0;
		int activeStatus = Integer.parseInt(pfrConstants.getValue("qritrim.status.id.active"));
		;
		try {
			logger.info("Entered into the function getactiveCampaignsAgency");

			PreparedStatementSetter pss = null;
			String query = pfrQueries.getValue("qivr.get.manageCampaigns.pastCampaigns");
			pss = new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
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
			for(int i=0;i<timelines.size();i++) {
			String timeLine = timelines.get(i);
			if (timeLine!=null) {
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

				//	System.out.println("endDate --- " + endDate);
				//	System.out.println("today --- " + today);
					long diff = endDate.getTime() - today.getTime();
				//	System.out.println("Diff ===== " + diff);
					if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) < 1) {
						campCount ++;
					}
					System.out.println(campCount);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}catch (Exception e) {
			logger.error(e.toString());
			e.printStackTrace();
			return 0;
		}
		return campCount;
	}
}
