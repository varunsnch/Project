package com.enrollment.studentcourse.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@Column(name = "course_id")
	@GeneratedValue
	private Long courseId;

	@Column(name = "course_name")
	private String courseName;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	Set<EnrollmentDetail> enrollmentDetails;

	public Course() {
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<EnrollmentDetail> getEnrollmentDetails() {
		return enrollmentDetails;
	}

	public void setEnrollmentDetails(Set<EnrollmentDetail> enrollmentDetails) {
		this.enrollmentDetails = enrollmentDetails;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + "]";
	}

	

}
