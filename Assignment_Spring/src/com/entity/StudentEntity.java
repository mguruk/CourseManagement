package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="EnrollStudent")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer enrollNumber;
	private String studentName;
	private String courseType;
	private String gender;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="courseCode")
	private CourseEntity course;
	
	
	
	public int getEnrollNumber() {
		return enrollNumber;
	}
	public void setEnrollNumber(int enrollNumber) {
		this.enrollNumber = enrollNumber;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public CourseEntity getCourse() {
		return course;
	}
	public void setCourse(CourseEntity course) {
		this.course = course;
	}
	
}
