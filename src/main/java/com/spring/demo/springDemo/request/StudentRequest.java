package com.spring.demo.springDemo.request;

import java.util.List;

import com.spring.demo.springDemo.service.Entity;

public class StudentRequest {

	private List<String> studentname;
	
	private String collegeName;
	
	private List<Entity> studentinfo;
	
	private int branchCode;

	public List<String> getStudentname() {
		return studentname;
	}

	public void setStudentname(List<String> studentname) {
		this.studentname = studentname;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public List<Entity> getStudentinfo() {
		return studentinfo;
	}

	public void setStudentinfo(List<Entity> studentinfo) {
		this.studentinfo = studentinfo;
	}

	public int getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}

	@Override
	public String toString() {
		return "StudentRequest [studentname=" + studentname + ", collegeName=" + collegeName + ", studentinfo="
				+ studentinfo + ", branchCode=" + branchCode + "]";
	}
	
}
