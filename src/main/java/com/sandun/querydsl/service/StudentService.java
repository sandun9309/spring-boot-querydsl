package com.sandun.querydsl.service;

import com.sandun.querydsl.model.Student;

import java.util.List;

public interface StudentService
{
	Student findStudentById( Long id );

	List<Student> findStudents( String studentFirstName, String address, long courseId );
}
