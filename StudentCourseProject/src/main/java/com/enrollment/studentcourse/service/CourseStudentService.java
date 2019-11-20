package com.enrollment.studentcourse.service;

import java.util.List;

import com.enrollment.studentcourse.entity.Course;
import com.enrollment.studentcourse.entity.EnrollmentDetail;
import com.enrollment.studentcourse.entity.Student;
import com.enrollment.studentcourse.model.StudentDetail;

public interface CourseStudentService {
	
	List<Student> getAllStudents();
	
	void addStudentDetails(StudentDetail detail);
	
	void deleteStudent(long id);
	
	List<String> getStudentsEnrolledInCourse(String courseName);
	
	List<String> getStudentsNotEnrolledInCourse(String courseName);
}
