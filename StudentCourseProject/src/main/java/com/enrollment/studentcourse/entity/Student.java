package com.enrollment.studentcourse.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@Column(name = "student_id")
	@GeneratedValue
	private Long studentId;

	@Column(name = "student_name")
	private String studentName;
	
	/*@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private Set<StudentCourse> studentCourse = new HashSet<StudentCourse>();
	
	

	public Set<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(Set<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}*/
	
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	Set<EnrollmentDetail> enrollmentDetails;
	
	public Student() {}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Set<EnrollmentDetail> getEnrollmentDetails() {
		return enrollmentDetails;
	}

	public void setEnrollmentDetails(Set<EnrollmentDetail> enrollmentDetails) {
		this.enrollmentDetails = enrollmentDetails;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}

	

		
}