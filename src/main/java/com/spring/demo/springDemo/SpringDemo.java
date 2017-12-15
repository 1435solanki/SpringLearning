package com.spring.demo.springDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * @Radhe
 *
 */

@SpringBootApplication(exclude = { ElasticsearchAutoConfiguration.class, ElasticsearchDataAutoConfiguration.class })
@ComponentScan("com.spring.demo.springDemo")
public class SpringDemo {

	private static final Logger LOG = LoggerFactory.getLogger(SpringDemo.class);
	
	public static void main(String[] args) throws Exception {
		try{
			SpringApplication.run(SpringDemo.class, args);
		}catch(Exception e){
			LOG.error(e.getMessage());
			throw new Exception("Spring Application not started");
		}
		
	}
}
