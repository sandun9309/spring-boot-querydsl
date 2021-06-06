package com.sandun.querydsl.manager;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sandun.querydsl.model.QStudent;

public class StudentManager
{
	public static Predicate findStudentByFirstNameAndLastName( String firstName, String address, long courseId )
	{
		QStudent student = QStudent.student;

		BooleanBuilder where = new BooleanBuilder();

		if ( firstName != null && !"".equals( firstName ) )
		{
			where.and( student.firstName.eq( firstName ) );
		}
		if ( address != null && !"".equals( address ) )
		{
			where.and( student.address.likeIgnoreCase( address ) );
		}
		if ( courseId > 0 )
		{
			where.and( student.course.id.eq( courseId ) );
		}
		return where;

	}
}
