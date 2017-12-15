package com.spring.demo.springDemo.esDao;

import java.io.IOException;

import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.demo.springDemo.request.StudentRequest;
import com.spring.demo.springDemo.service.QueryLoader;

import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;

@Scope(value = "singleton")
@Component
public class ESDaoQuery {

	private static final Logger LOG = LoggerFactory.getLogger(ESDaoQuery.class);
	private QueryLoader queryLoader;
	private ESDaoRepoImp esDaorep;
	
	@Autowired(required = true)
	public ESDaoQuery(QueryLoader queryLoader, ESDaoRepoImp esDaorep){
		this.queryLoader = queryLoader;
		this.esDaorep = esDaorep;
	}
	
	
	
	public String ESResponse(StudentRequest request) throws IOException{
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		//searchSourceBuilder.size(0);
		
		String queryBuilder = queryLoader.getQueryMap().getQueriesMap()
				.get("studentInfo");
		
		LOG.info("Query for filter by query loader "+queryBuilder);
		
		searchSourceBuilder.query(queryBuilder.getBytes());
		SearchResult result = null;
		result = performESQuery(searchSourceBuilder);
		return result.toString();
	}
	
	@SuppressWarnings("unused")
	private SearchResult performESQuery(SearchSourceBuilder searchSourceBuilder) throws IOException{
		LOG.info("Input query " + searchSourceBuilder.toString());
		SearchResult result = null;
		Search search = null;//			buildSearchObject(searchSourceBuilder);
		Search.Builder searchBuilder = null;
		
		searchBuilder = new Search.Builder(searchSourceBuilder.toString()).addType("doc")
				.addIndex("customer");
		searchBuilder.setParameter("request_cache", true);
		search = searchBuilder.build();
		LOG.info("search build result "+search);
		result = esDaorep.execute(search);
		LOG.info("Response Code " + result.getResponseCode());
		LOG.info("Output result " + result.getJsonString());
		return result;
	}
}
