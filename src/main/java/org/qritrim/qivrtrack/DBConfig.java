package org.qritrim.qivrtrack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DBConfig {

	private static final Logger logger = LogManager.getLogger(DBConfig.class);
    
//	@Autowired
//    private Environment env;
	@Autowired
	JdbcTemplate jdbcTemplate;
    
//	   @Bean
//	    public JdbcTemplate jdbcTemplate(DataSource dataSource)
//	    {
//	    	JdbcTemplate jdbctemplate = new JdbcTemplate(dataSource);
//	    	return jdbctemplate;
//	    }
	    
//	    private DataSource createDataSourceByEnvironmentType() {
//	   	 BasicDataSource dataSource = new BasicDataSource();
//	   	 
//	   	 	// DRIVER WOULD REMAIN SAME FOR ENVT
//	   	 	dataSource.setDriverClassName(env.getProperty("db.data.driver"));
//	   	 	dataSource.setUrl(env.getProperty("db.data.url"));
//		    dataSource.setUsername(env.getProperty("db.data.username"));
//		    dataSource.setPassword(env.getProperty("db.data.password"));
//	 
//	   	 	logger.info(" >> DB URL : "+dataSource.getUrl());
//	   	 	logger.info(" >> DB User : "+dataSource.getUsername());
//	   	 	
//	   		try {
//				logger.info(" >> DB Connection Status (isClosed) : "+dataSource.getConnection().isClosed());
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	   	 	
//	   	 	
//	   	 	return dataSource;
//	   	 
//	   }
	   
//	   @Bean(destroyMethod = "")
//	   public DataSource dataSource()
//	   {
//		   return createDataSourceByEnvironmentType();
//	   }
	   
	   
}