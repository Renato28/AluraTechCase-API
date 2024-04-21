create table evaluations(

    id bigint not null auto_increment,
    course_id bigint not null,
    user_id bigint not null,
    grade double not null,
    reason varchar(100) not null,

    primary key(id)
    constraint fk_course foreign key (course_id) references courses(id)
    constraint fk_user foreign key (user_id) references users(id)

);