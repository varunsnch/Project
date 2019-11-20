package com.enrollment.studentcourse.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enrollment.studentcourse.entity.Course;
import com.enrollment.studentcourse.repository.CourseRepository;

@Component
public class CourseDaoImpl implements CourseDao {

	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public void saveCourses(List<Course> courses) {
		for(Course course : courses) {
			courseRepository.save(course);
		}
	}

	@Override
	public Course getCourseByName(String courseName) {
		return courseRepository.findByCourseName(courseName);
	}

}
