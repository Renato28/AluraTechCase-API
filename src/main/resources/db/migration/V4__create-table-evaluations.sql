create table evaluations(

    id bigint not null auto_increment,
    course_id bigint not null,
    user_id bigint not null,
    grade double not null,
    comments varchar(100) not null,
    reason_grade varchar(100) not null,
    evaluation_date date not null,

    primary key(id),
    constraint fk_course_evaluation foreign key (course_id) references courses(id),
    constraint fk_user_evaluation foreign key (user_id) references users(id)

);