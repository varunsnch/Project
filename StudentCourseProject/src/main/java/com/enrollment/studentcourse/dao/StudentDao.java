package com.enrollment.studentcourse.dao;

import java.util.List;

import com.enrollment.studentcourse.entity.Student;



public interface StudentDao {
	
	List<Student> getAllStudentDetails();
	
	Student getStudentByName(String studentName);
	
	void saveStudent(Student student);
	
	void removeStudent(long id);
}	
