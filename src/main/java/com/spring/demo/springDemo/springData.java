package com.spring.demo.springDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope(value = "singleton")
@Component
public class springData {
	
	private static final Logger LOG = LoggerFactory.getLogger(springData.class);
	public springData(){
		
	}
	
	private String  jsonString = "{" 
			   + "    \"geodata\": [" 
			   + "        {" 
			   + "                \"id\": \"1\"," 
			   + "                \"name\": \"Julie Sherman\","                  
			   + "                \"gender\" : \"female\"," 
			   + "                \"latitude\" : \"37.33774833333334\"," 
			   + "                \"longitude\" : \"-121.88670166666667\""            
			   + "                }" 
			   + "        }," 
			   + "        {" 
			   + "                \"id\": \"2\"," 
			   + "                \"name\": \"Johnny Depp\","          
			   + "                \"gender\" : \"male\"," 
			   + "                \"latitude\" : \"37.336453\"," 
			   + "                \"longitude\" : \"-121.884985\""            
			   + "                }" 
			   + "        }" 
			   + "    ]" 
			   + "}"; 
	
	public String getInfo(){
		LOG.info("Reading Json String ");
		return jsonString.trim();
	}
}
