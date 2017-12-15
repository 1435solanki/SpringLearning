package com.spring.demo.springDemo.service;

import java.util.Map;

public class Queries {
	private Map<String, String> queriesMap;

	public Map<String, String> getQueriesMap() {
		return queriesMap;
	}

	public void setQueriesMap(Map<String, String> queriesMap) {
		this.queriesMap = queriesMap;
	}

	@Override
	public String toString() {
		return "Queries [queriesMap=" + queriesMap + "]";
	}
}
