package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Course;
import com.bean.Student;
import com.exception.StudentEnrollmentException;
import com.service.EnrollStudentService;

@Controller
public class EnrollStudentController {

	@Autowired
	private EnrollStudentService service;
	
	@RequestMapping("/home.htm")
	public ModelAndView displayHomepage() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@ModelAttribute("courseList")
	public Map<String,String> populateCourse() {
		List<Course> courseNameList= service.getCourseDetails();
		Map<String,String> courseNameMap= new HashMap<String,String>();
		for(Course coursename:courseNameList ) {
			courseNameMap.put(coursename.getCourseCode(),coursename.getCourseName() );
		}
		return courseNameMap;
	}
	
	@RequestMapping("/enrollmentForm.htm")
	public ModelAndView loadEnrollmentPage(ModelMap map) throws Exception {
		Student student= new Student();
		map.addAttribute(student);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("courseenrollment");
		return mv;
	}
	
	@RequestMapping("/enroll.htm")
	public ModelAndView enrollStudent(@ModelAttribute Student student) throws Exception {
		ModelAndView mv = new ModelAndView();
		//System.out.println(student.getGender()+student.getStudentName());
		try {
			String enrollmentId = service.enrollStudent(student);
			mv.addObject("message","Thank you for your registration,your Enrollment id is"+enrollmentId);
			mv.setViewName("success");
		} catch (Exception e) {
			mv.addObject("message","Error :"+e.getMessage());
			mv.setViewName("courseenrollment");
		}
		return mv;
	}
	
	
	@RequestMapping("/CourseDetail.htm")
	public ModelAndView getCourseDetail() throws Exception {
		ModelAndView mv = new ModelAndView();
		List<Course> courseList=service.getCourseDetails();
		System.out.println(courseList.isEmpty());
		mv.addObject("List",courseList);
		mv.setViewName("viewallcourse");
		return mv;
	}
}
