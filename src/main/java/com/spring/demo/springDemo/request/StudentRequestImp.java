package com.spring.demo.springDemo.request;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.spring.demo.springDemo.service.Entity;

@Scope(value = "singleton")
@Component
public class StudentRequestImp {

	StudentRequestWrapper stwrapper = null;
	public StudentRequestImp(){
		init();
	}
	
	private void init(){
		StudentRequest stReq = new StudentRequest();
 		List<Entity> info = new ArrayList<Entity>();
		Entity entity = new Entity();
		entity.setLable("1");
		entity.setValue("Radhe");
		info.add(entity);
		Entity entity1 = new Entity();
		entity1.setLable("2");
		entity1.setValue("Krishna");
		info.add(entity1);
		stReq.setStudentinfo(info);
		stReq.setCollegeName("Nitk Surathkal");
		stReq.setBranchCode(1500250);
		List<String> listname = new ArrayList<String>();
		listname.add("vikas Solanki");
		listname.add("sachine Patidar");
		listname.add("Ashu jain");
		listname.add("Suneel Kumar");
		stReq.setStudentname(listname);
		stwrapper = new StudentRequestWrapper();
		stwrapper.setStrequest(stReq);
	}
	
	public StudentRequest getStudentInfo(){
		return stwrapper.getStrequest();
	}
	public StudentRequestWrapper getStudentInfoWrapper(){
		return stwrapper;
	}
	
}
