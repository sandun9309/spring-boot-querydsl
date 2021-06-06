package com.sandun.querydsl.repository;

import com.sandun.querydsl.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, QuerydslPredicateExecutor<Student>
{
}
