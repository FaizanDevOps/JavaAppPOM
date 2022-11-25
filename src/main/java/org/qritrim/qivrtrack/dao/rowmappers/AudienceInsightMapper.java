package org.qritrim.qivrtrack.dao.rowmappers;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.util.PGobject;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.qritrim.qivrtrack.model.AudienceInsight;
//import com.google.gson.Gson;
import org.qritrim.qivrtrack.model.FeedsData;

//public class FeedsDataMapper {
//
//}

@Component
public class AudienceInsightMapper  implements ResultSetExtractor<List<AudienceInsight>> {

	private static final Logger logger = LogManager.getLogger(AudienceInsightMapper.class);
	
	@Override
	public List<AudienceInsight> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<AudienceInsight> audienceData = new ArrayList<>();
		
		while(rs.next()) {
			String[] data = null;
			String em = rs.getString("brand");
			em = em.replace("{", "");
			em = em.replace("}", "");
			em = em.replace("", "");
			System.out.println(em);
			data = em.split(",");
//			data = data.replace("{", " ");
		    for (int i =0; i < data.length; i++){
		        System.out.println(data[i]);
		    }
			AudienceInsight audienceInsightData = new AudienceInsight();
			audienceInsightData.setMalePercentage(rs.getFloat("malePercentage"));
			audienceInsightData.setFemalePercentage(rs.getFloat("femalePercentage"));
			audienceInsightData.setBrand(data);
//			audienceInsightData.setBrand(data);
			System.out.println(rs.getArray("brand"));
			System.out.println(((Object)rs.getString("brand")).getClass().getSimpleName());
//			audienceInsightData.setBrand(rs.getArray("brand"));
//			audienceInsightData.setId(rs.getInt("id"));
//			audienceInsightData.setFeedsId(rs.getString("feedsId"));
			
//			userGroup.setGroupId(rs.getInt("groupId"));
//			userGroup.setGroupName(rs.getString("groupName"));
//			userGroup.setGroupDesc(rs.getString("groupDesc"));
//			userGroup.setGroupOwner(rs.getString("groupOwner"));
//			userGroup.setRoleId(rs.getInt("roleId"));
//			userGroup.setGroupActiveStatus(rs.getString("groupActiveStatus").charAt(0));
//			userGroup.setCreatedBy(rs.getString("createdBy"));
//			userGroup.setCreatedOn(rs.getString("createdOn"));
//			userGroup.setLastModifiedBy(rs.getString("lastModifiedBy"));
//			userGroup.setLastModifiedOn(rs.getString("lastModifiedOn"));
//			
			audienceData.add(audienceInsightData);
		}
		
		logger.info(">>>>  Count : " + audienceData.size());
		return audienceData;
		
	}

}

