package com.enrollment.studentcourse.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enrollment.studentcourse.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findByStudentName(String name);
	List<Student> findAll();
}
