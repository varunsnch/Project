package com.enrollment.studentcourse.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollment.studentcourse.dao.CourseDao;
import com.enrollment.studentcourse.dao.EnrollmentDetailDao;
import com.enrollment.studentcourse.dao.StudentDao;
import com.enrollment.studentcourse.entity.Course;
import com.enrollment.studentcourse.entity.EnrollmentDetail;
import com.enrollment.studentcourse.entity.Student;
import com.enrollment.studentcourse.model.CourseDetail;
import com.enrollment.studentcourse.model.StudentDetail;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	EnrollmentDetailDao enrollmentDetailDao;

	

	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudentDetails();
	}

	private void addStudentDetails(Student student, List<Course> courses) {
		studentDao.saveStudent(student); // save student entity
		courseDao.saveCourses(courses); // save course entity
		
	}

	private void addAllStudentEnrollmentDetails(List<EnrollmentDetail> enrollmentDetails) {
		for(EnrollmentDetail detail : enrollmentDetails) {
			enrollmentDetailDao.addEnrollmentDetails(detail); // save enrollmentDetail entity
		}
	}

	@Override
	public void deleteStudent(long id) {
		studentDao.removeStudent(id); // remove student entity
	}

	@Override
	public void addStudentDetails(StudentDetail detail) {
		// generate student entity
		Student student = studentDao.getStudentByName(detail.getStudentName()); // check for existing student entity
		if(student == null) student = new Student(); // create new if not found
		student.setStudentName(detail.getStudentName());
		// generate Course Entity
		List<Course> courses = new ArrayList<>();
		for(CourseDetail courseEnrolled : detail.getCoursesEnrolled()) {
			Course course = courseDao.getCourseByName(courseEnrolled.getCourseName());
			if(course == null) { // no course entity present
				course = new Course(); // create new
				course.setCourseName(courseEnrolled.getCourseName());
			}
			courses.add(course);
		}
		// add student and courses data
		addStudentDetails(student, courses);
		// generate enrollment entity
		List<EnrollmentDetail> enrollmentDetails = new ArrayList<>();
		if(courses.isEmpty()) { // if no courses enrolled by student
			EnrollmentDetail enrollmentDetail = new EnrollmentDetail();
			enrollmentDetail.setStudent(student);
			enrollmentDetails.add(enrollmentDetail);
		}
		for(Course course : courses) {
			EnrollmentDetail enrollmentDetail = new EnrollmentDetail();
			enrollmentDetail.setStudent(student);
			enrollmentDetail.setCourse(course);
			enrollmentDetails.add(enrollmentDetail);
		}
		// add enrollment details
		addAllStudentEnrollmentDetails(enrollmentDetails);
		
	}

	@Override
	public List<String> getStudentsEnrolledInCourse(String courseName) {
		List<String> students = new ArrayList<>();
		Course course = courseDao.getCourseByName(courseName); // get course entity
		if(course == null) return students; // return empty list course not present
		List<EnrollmentDetail> details = enrollmentDetailDao.getAllStudentsByCourse(course); // get enrollment details by course
		for(EnrollmentDetail detail : details) {
			students.add(detail.getStudent().getStudentName()); // add student names
		}
		Collections.sort(students); // sorting students by name
		return students;
	}

	@Override
	public List<String> getStudentsNotEnrolledInCourse(String courseName) {
		List<String> students = new ArrayList<>();
		Course course = courseDao.getCourseByName(courseName); // get course entity
		List<EnrollmentDetail> details = new ArrayList<>();
		if(course != null) details = enrollmentDetailDao.getAllStudentsNotEnrolledInCourse(course); // fetch not enrolled details by course
		else details = enrollmentDetailDao.getAllEnrollmentDetails(); // get all students irrespective of courses if unknown course entity
		for(EnrollmentDetail detail : details) {
			students.add(detail.getStudent().getStudentName()); // add student names
		}
		return students;
	}

}
