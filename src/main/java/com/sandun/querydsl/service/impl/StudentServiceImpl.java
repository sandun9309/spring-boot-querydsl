package com.sandun.querydsl.service.impl;

import com.google.common.collect.Lists;
import com.querydsl.jpa.impl.JPAQuery;
import com.sandun.querydsl.manager.StudentManager;
import com.sandun.querydsl.model.QStudent;
import com.sandun.querydsl.model.Student;
import com.sandun.querydsl.repository.StudentRepository;
import com.sandun.querydsl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student findStudentById( Long id )
	{
		try
		{
			return studentRepository.findById( id ).orElse( new Student() );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			return new Student();
		}
	}

	@Override
	public List<Student> findStudents( String studentFirstName, String address, long courseId )
	{
		try
		{
			Iterable<Student> studentIterable = studentRepository.findAll( StudentManager.findStudentByFirstNameAndLastName( studentFirstName, address, courseId ) );
			return Lists.newArrayList( studentIterable );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}
