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

//import com.google.gson.Gson;
import org.qritrim.qivrtrack.model.FeedsData;

//public class FeedsDataMapper {
//
//}

@Component
public class FeedsDataMapper  implements ResultSetExtractor<List<FeedsData>> {

	private static final Logger logger = LogManager.getLogger(FeedsDataMapper.class);
	
	@Override
	public List<FeedsData> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<FeedsData> feedsDatas = new ArrayList<>();
		
		while(rs.next()) {
			
			FeedsData feedsData = new FeedsData();
			feedsData.setId(rs.getInt("id"));
			feedsData.setFeedsId(rs.getString("feedsId"));
			
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
			feedsDatas.add(feedsData);
		}
		
		logger.info(">>>> feedsDatas Count : " + feedsDatas.size());
		return feedsDatas;
		
	}

}

