package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Course;
import com.bean.Student;
import com.entity.CourseEntity;

import com.entity.StudentEntity;

@Component
public class EnrollStudentDAO {

	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public int enrollStudent(Student student) {
		StudentEntity se= new StudentEntity();
		se.setStudentName(student.getStudentName());
		se.setGender(student.getGender());
		//String courseType=student.getCourseType()[0];
		int size=student.getCourseType().length;
		if(size>1) 
			se.setCourseType("both");
		else 
			se.setCourseType(student.getCourseType()[0]);
		CourseEntity course = em.find(CourseEntity.class, student.getCourseCode());
		se.setCourse(course);
		em.persist(se);
		Integer enrollId=se.getEnrollNumber();
		System.out.println(enrollId);
		return enrollId;
	}
	
	public String retrieveCourseType(String courseCode) {
		CourseEntity ce=em.find(CourseEntity.class, courseCode);
		return ce.getCourseType();
	}
	
	public List<Course> getCourseDetails(){
		List<Course> courseDetail = new  ArrayList<Course>();
		Query q=em.createQuery("select obj from CourseEntity obj");
		List<CourseEntity> courseEntityDetail= q.getResultList();
		for(CourseEntity course: courseEntityDetail){
			Course c=new Course();
			//System.out.println(course.getCourseCode());
			c.setCourseCode(course.getCourseCode());
			c.setCourseName(course.getCourseName());
			c.setCoursefees(Integer.toString(course.getCoursefees()));
			c.setCourseCode(course.getCourseCode());
			c.setCourseType(course.getCourseType());
			courseDetail.add(c);
		}
		return courseDetail;
	}
}
