package org.qritrim.qivrtrack;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.qritrim.qivrtrack.utils.PropertyFileReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;



@Configuration
@ComponentScan
@PropertySource(value = { "classpath:application.properties","classpath:queries.properties", "classpath:messages.properties" })
@Import({DBConfig.class})

public class AppConfig {

	private static final Logger logger = LogManager.getLogger(AppConfig.class);
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }  
    
 
    
    @Bean
    @Qualifier("application")
    @Primary
    public PropertyFileReader propertyFileReaderApplication() {
        	return new PropertyFileReader("application");
    }
   
    @Bean("queries")
    @Qualifier("queries")
    public PropertyFileReader propertyFileReaderQueries() {
        	return new PropertyFileReader("queries");
    }
    
    @Bean("messages")
    @Qualifier("messages")
    public PropertyFileReader propertyFileReaderMessages() {
        	return new PropertyFileReader("messages");
    }
    
    @Bean("constants")
    @Qualifier("constants")
    public PropertyFileReader propertyFileReaderConstants() {
    	return new PropertyFileReader("constants");
}
    
}
