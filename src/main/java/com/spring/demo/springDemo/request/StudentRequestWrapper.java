package com.spring.demo.springDemo.request;

public class StudentRequestWrapper {

	private StudentRequest strequest;

	public StudentRequest getStrequest() {
		return strequest;
	}

	public void setStrequest(StudentRequest strequest) {
		this.strequest = strequest;
	}
	

	@Override
	public String toString() {
		return "StudentRequestWrapper [strequest=" + strequest + "]";
	}

}
