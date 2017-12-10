package com.spring.demo.springDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.demo.springDemo.service.dataBuilder.InfoData;

@Scope(value = "singleton")
@Component
public class dataBuilderImp{

	private static final Logger LOG = LoggerFactory.getLogger(dataBuilderImp.class);
	
	private dataBuilder databuilder;
	
	public dataBuilderImp(){
		init();
	}
	
	public void init(){
		List<Entity> info = new ArrayList<Entity>();
		Entity entity = new Entity();
		entity.setLable("1");
		entity.setValue("Radhe");
		info.add(entity);
		Entity entity1 = new Entity();
		entity1.setLable("2");
		entity1.setValue("Krishna");
		info.add(entity1);
		InfoData infodata = new InfoData();
		infodata.setInfo(info);
		databuilder = new dataBuilder();
		databuilder.setInfoData(infodata);
		LOG.info("here msg "+databuilder.getInfoData().toString());
	}
	
	public InfoData retriveData(){
		return databuilder.getInfoData();
	}
}
