package com.sandun.querydsl;

import com.sandun.querydsl.model.Course;
import com.sandun.querydsl.model.Student;
import com.sandun.querydsl.model.Subject;
import com.sandun.querydsl.repository.CourseRepository;
import com.sandun.querydsl.repository.StudentRepository;
import com.sandun.querydsl.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootQuerydslApplication
{

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main( String[] args )
	{
		SpringApplication.run( SpringBootQuerydslApplication.class, args );
	}

	@PostConstruct
	public void initialData()
	{
		Subject subject1 = new Subject( 1, "Computer Programming", "S001" );
		Subject subject2 = new Subject( 2, "Program design", "S002" );
		Subject subject3 = new Subject( 3, "Computer Systems analysis", "S003" );
		Subject subject4 = new Subject( 4, "Fundamentals of Hardware", "S004" );
		Subject subject5 = new Subject( 5, "Networking", "S005" );
		Subject subject6 = new Subject( 6, "Computer Architecture and Commerce", "S006" );
		Subject subject7 = new Subject( 7, "Professional Awareness", "S007" );
		Subject subject8 = new Subject( 8, "Mathematics for Computing", "S008" );
		Subject subject9 = new Subject( 9, "Introduction to Databases", "S009" );
		Subject subject10 = new Subject( 10, "Academic skills for computing", "S010" );

		List<Subject> subjectList = Arrays.asList( subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8, subject9, subject10 );
		subjectRepository.saveAll( subjectList );

		// ----------------------------------------------------------------------------------------------------------------------------------------------------
		Course course1 = new Course( 1, "B.S. in Software Engineering", Arrays.asList( subject1, subject2, subject4, subject5, subject6, subject8, subject9, subject10 ) );
		Course course2 = new Course( 2, "B.S. in Computer Science", Arrays.asList( subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8 ) );
		Course course3 = new Course( 3, "B.S. in Business Administration", Arrays.asList( subject1, subject2, subject3, subject6, subject7, subject8, subject9, subject10 ) );

		List<Course> courseList = Arrays.asList( course1, course2, course3 );
		courseRepository.saveAll( courseList );

		// ----------------------------------------------------------------------------------------------------------------------------------------------------
		Student student1 = new Student( 1, "Mary", "Elizabeth ", "NY", course1 );
		Student student2 = new Student( 2, "Jim", "Brown", "CMB", course2 );
		Student student3 = new Student( 3, "William", "Anderson", "MEL", course3 );
		Student student4 = new Student( 4, "James", "Connor", "CHINA", course2 );
		Student student5 = new Student( 5, "Alexander", "Brooks", "NZ", course2 );
		Student student6 = new Student( 6, "Jacob", "Wilson", "CANADA", course1 );

		List<Student> studentList = Arrays.asList( student1, student2, student3, student4, student5, student6 );
		studentRepository.saveAll( studentList );
	}
}









