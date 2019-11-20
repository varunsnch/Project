package com.enrollment.studentcourse.model;

public class CourseDetail {

	String courseName;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String name) {
		this.courseName = name;
	}

	@Override
	public String toString() {
		return "CourseDetail [courseName=" + courseName + "]";
	}

}
