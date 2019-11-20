package com.enrollment.studentcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enrollment.studentcourse.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	Course findByCourseName(String name);
}
