package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.Course;
import com.bean.Student;
import com.dao.EnrollStudentDAO;
import com.exception.StudentEnrollmentException;


@Component
public class EnrollStudentService {

	@Autowired
	EnrollStudentDAO dao;
	
	public String enrollStudent(Student student) throws Exception {
		
		String courseType=dao.retrieveCourseType(student.getCourseCode());
		System.out.println(courseType);
		System.out.println(student.getCourseType()[0]);
		if(!courseType.equals("both") ) {
			System.out.println("inside check");
			if(!student.getCourseType()[0].equals(courseType)) {
				System.out.println("match");
				throw new StudentEnrollmentException();
			}
		}
		return Integer.toString(dao.enrollStudent(student));
	}
	
	
	public List<Course> getCourseDetails(){
		List<Course>  courseDetails = dao.getCourseDetails();
		System.out.println(courseDetails.size());
		return courseDetails;
	}
	
	
}
