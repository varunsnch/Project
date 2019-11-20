package com.enrollment.studentcourse.dao;

import java.util.List;

import com.enrollment.studentcourse.entity.Course;

public interface CourseDao {

	Course getCourseByName(String courseName);
	
	void saveCourses(List<Course> courses);

}
