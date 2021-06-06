package com.sandun.querydsl.controller;

import com.sandun.querydsl.model.Student;
import com.sandun.querydsl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController
{
	@Autowired
	StudentService studentService;

	@GetMapping("/{id}")
	public Student findStudentById( @PathVariable Long id )
	{
		return studentService.findStudentById( id );
	}

	@GetMapping
	// @Formatter:Off
	public List<Student> findStudents( @RequestParam(required = false, defaultValue = "") String studentFirstName,
			@RequestParam(required = false, defaultValue = "") String address,
			@RequestParam(required = false, defaultValue = "-1") long courseId )
	// @Formatter:On
	{
		return studentService.findStudents( studentFirstName, address, courseId );
	}
}
