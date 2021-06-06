package com.sandun.querydsl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false)
	private long id;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "ADDRESS", nullable = false)
	private String address;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "COURSE_ID", referencedColumnName = "ID", nullable = false, foreignKey = @ForeignKey(name = "FK_STUDENT_2_COURSE"))
	private Course course;
}
