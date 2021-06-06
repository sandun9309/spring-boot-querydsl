# spring data jpa-querydsl

* Dependencies for queryDSL

![alt text](https://github.com/sandun9309/spring-boot-querydsl/blob/main/src/main/resources/screenshots/dependency1.jpg?raw=true)

![alt text](https://github.com/sandun9309/spring-boot-querydsl/blob/main/src/main/resources/screenshots/dependency2.jpg?raw=true)

* once ***mvn package*** command issued the following file will be created under the target folder

![alt text](https://github.com/sandun9309/spring-boot-querydsl/blob/main/src/main/resources/screenshots/Q_model_classes.jpg?raw=true)

* copy those files from target folder to model directory in main->java directory

![alt text](https://github.com/sandun9309/spring-boot-querydsl/blob/main/src/main/resources/screenshots/copy_Q_classes.jpg?raw=true)

StudentManager
```java
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.sandun.querydsl.model.QStudent;

public class StudentManager
{
	public static Predicate findStudentByFirstNameAndLastName( String firstName, String address, long courseId )
	{
		QStudent student = QStudent.student;

		BooleanBuilder where = new BooleanBuilder();

		if ( firstName != null && !firstName.isEmpty() )
		{
			where.and( student.firstName.eq( firstName ) );
		}
		if ( address != null && !address.isEmpty() )
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
```
StudentServiceImpl
```java
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
```
