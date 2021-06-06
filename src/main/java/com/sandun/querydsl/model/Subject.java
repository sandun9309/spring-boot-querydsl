package com.sandun.querydsl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "SUBJECT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subject
{
	public Subject( long id )
	{
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false)
	private long id;

	@Column(name = "SUBJECT_NAME", nullable = false)
	private String subjectName;

	@Column(name = "SUBJECT_CODE", nullable = false)
	private String subjectCode;
}
