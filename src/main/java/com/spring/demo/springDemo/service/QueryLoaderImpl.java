package com.spring.demo.springDemo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


@Scope(value="singleton")
@Component
public class QueryLoaderImpl implements QueryLoader{

	private static final Logger LOG = LoggerFactory.getLogger(QueryLoaderImpl.class);
	private Queries queryMap;

	public QueryLoaderImpl() {

		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(QueryLoader.class.getResourceAsStream("/queries.yaml")));
		
		LOG.info("queries reading in queryloader "+reader.toString());
		try {
			this.queryMap = mapper.readValue(reader, Queries.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Queries getQueryMap() {
		return queryMap;
	}

}
