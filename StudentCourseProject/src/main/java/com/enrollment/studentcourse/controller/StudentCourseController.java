package com.enrollment.studentcourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enrollment.studentcourse.model.StudentDetail;
import com.enrollment.studentcourse.repository.CourseRepository;
import com.enrollment.studentcourse.repository.EnrollmentDetailRepository;
import com.enrollment.studentcourse.repository.StudentRepository;
import com.enrollment.studentcourse.service.CourseStudentService;

@RestController
public class StudentCourseController {

	@Autowired
	CourseStudentService svc;
	
	@Autowired 
	StudentRepository studentRepo;
	
	@Autowired 
	CourseRepository courseRepo;
	
	@Autowired 
	EnrollmentDetailRepository enrollmentDetailRepo;
	
	@PostMapping(value = "/addStudent")
	public ResponseEntity addStudentDetails(@RequestBody StudentDetail studentDetail) {
		// calling service
		svc.addStudentDetails(studentDetail);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable long id) {
		svc.deleteStudent(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/studentsEnrolled")
	public ResponseEntity<List<String>> getAllStudentsByCourse(@RequestParam("courseName") String courseName) {
		List<String> students = svc.getStudentsEnrolledInCourse(courseName);
		return new ResponseEntity<List<String>>(students, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/studentsNotEnrolled")
	public ResponseEntity<List<String>> getAllStudentsNotEnrolledByCourse(@RequestParam("courseName") String courseName) {
		List<String> students = svc.getStudentsNotEnrolledInCourse(courseName);
		return new ResponseEntity<List<String>>(students, HttpStatus.OK);
	}
	
	
}
