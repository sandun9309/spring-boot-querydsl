package com.sandun.querydsl.repository;

import com.sandun.querydsl.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>
{
}
