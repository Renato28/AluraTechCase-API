create table students_courses(
    student_id bigint not null,
    course_id bigint not null,
    primary key (student_id, course_id),
    foreign key (student_id) references students(id),
    foreign key (course_id) references courses(id)
)