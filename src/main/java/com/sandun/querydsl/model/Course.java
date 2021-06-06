package com.sandun.querydsl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "COURSE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false)
	private long id;

	@Column(name = "COURSE_NAME", nullable = false)
	private String courseName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "COURSE_SUBJECT",
			joinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_COURSE_2_SUBJECT")),
			inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_SUBJECT_2_COURSE")))
	private List<Subject> subjectList;

}
