package com.sandun.querydsl.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCourse is a Querydsl query type for Course
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCourse extends EntityPathBase<Course> {

    private static final long serialVersionUID = 1736522805L;

    public static final QCourse course = new QCourse("course");

    public final StringPath courseName = createString("courseName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Subject, QSubject> subjectList = this.<Subject, QSubject>createList("subjectList", Subject.class, QSubject.class, PathInits.DIRECT2);

    public QCourse(String variable) {
        super(Course.class, forVariable(variable));
    }

    public QCourse(Path<? extends Course> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCourse(PathMetadata metadata) {
        super(Course.class, metadata);
    }

}

