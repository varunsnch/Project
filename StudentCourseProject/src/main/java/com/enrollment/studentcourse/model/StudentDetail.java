package com.enrollment.studentcourse.model;

import java.util.ArrayList;
import java.util.List;

public class StudentDetail {

	String studentName;
	List<CourseDetail> coursesEnrolled = new ArrayList<>();

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String name) {
		this.studentName = name;
	}

	public List<CourseDetail> getCoursesEnrolled() {
		return coursesEnrolled;
	}

	public void setCoursesEnrolled(List<CourseDetail> coursesEnrolled) {
		this.coursesEnrolled = coursesEnrolled;
	}

	@Override
	public String toString() {
		return "StudentDetail [name=" + studentName + ", courseEnrolled=" + coursesEnrolled + "]";
	}
	
	

}
