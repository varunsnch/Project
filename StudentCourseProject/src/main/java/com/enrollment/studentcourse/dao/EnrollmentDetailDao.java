package com.enrollment.studentcourse.dao;

import java.util.List;

import com.enrollment.studentcourse.entity.Course;
import com.enrollment.studentcourse.entity.EnrollmentDetail;

public interface EnrollmentDetailDao {
	
	void addEnrollmentDetails(EnrollmentDetail enrollmentDetail);
	
	List<EnrollmentDetail> getAllEnrollmentDetails();
	
	List<EnrollmentDetail> getAllStudentsByCourse(Course course);
	
	List<EnrollmentDetail> getAllStudentsNotEnrolledInCourse(Course course);
}
