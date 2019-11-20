package com.enrollment.studentcourse.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enrollment.studentcourse.entity.Student;
import com.enrollment.studentcourse.repository.StudentRepository;

@Component
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudentDetails() {
		return studentRepository.findAll();
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void removeStudent(long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student getStudentByName(String studentName) {
		return studentRepository.findByStudentName(studentName);
	}
	
	
	

}
