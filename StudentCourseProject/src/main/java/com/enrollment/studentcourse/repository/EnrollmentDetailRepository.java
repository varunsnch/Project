package com.enrollment.studentcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enrollment.studentcourse.entity.Course;
import com.enrollment.studentcourse.entity.EnrollmentDetail;

public interface EnrollmentDetailRepository extends JpaRepository<EnrollmentDetail, Long> {
	
	List<EnrollmentDetail> findAllByCourse(Course course);
	
	List<EnrollmentDetail> findAllByCourseNotOrCourseIsNull(Course course);
}
