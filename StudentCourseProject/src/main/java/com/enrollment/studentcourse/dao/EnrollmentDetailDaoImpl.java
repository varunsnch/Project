package com.enrollment.studentcourse.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enrollment.studentcourse.entity.Course;
import com.enrollment.studentcourse.entity.EnrollmentDetail;
import com.enrollment.studentcourse.repository.EnrollmentDetailRepository;

@Component
public class EnrollmentDetailDaoImpl implements EnrollmentDetailDao {
	
	@Autowired
	EnrollmentDetailRepository enrollmentDetailRepository;
	
	@Override
	public void addEnrollmentDetails(EnrollmentDetail enrollmentDetail) {
		enrollmentDetailRepository.save(enrollmentDetail);
	}

	@Override
	public List<EnrollmentDetail> getAllStudentsByCourse(Course course) {
		return enrollmentDetailRepository.findAllByCourse(course);
	}

	@Override
	public List<EnrollmentDetail> getAllStudentsNotEnrolledInCourse(Course course) {
		return enrollmentDetailRepository.findAllByCourseNotOrCourseIsNull(course);
	}

	@Override
	public List<EnrollmentDetail> getAllEnrollmentDetails() {
		return enrollmentDetailRepository.findAll();
	}

}
