package com.bean;



public class Student {
	
	private Integer enrollNumber;
	private String studentName;
	private String gender;
	private String[] courseType;
	private String courseCode;
	private int contact;
	
	
	public int getEnrollNumber() {
		return enrollNumber;
	}


	public void setEnrollNumber(int enrollNumber) {
		this.enrollNumber = enrollNumber;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String[] getCourseType() {
		return courseType;
	}


	public void setCourseType(String[] courseType) {
		this.courseType = courseType;
	}


	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public int getContact() {
		return contact;
	}


	public void setContact(int contact) {
		this.contact = contact;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getStudentName()+" "+getEnrollNumber()+" "+getGender()+" "+getCourseType();
	}
	
	
	
}
