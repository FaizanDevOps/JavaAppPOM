package org.qritrim.qivrtrack.utils;


import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class PropertyFileReader {
    
	private ResourceBundle resourceBundle=null;
	
	@Autowired
	private Environment envt;
    
	public PropertyFileReader(String fileName) {
        super();
        resourceBundle = ResourceBundle.getBundle(fileName);
    }
    
    public String getValue(String key){
        return resourceBundle.getString(key);
        
    }
    
    public String getEnvtValue(String key) {
    	 return envt.getProperty(key);
    	
    }
    
}
