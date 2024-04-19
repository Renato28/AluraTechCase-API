create table registrations(

    id bigint not null auto_increment,
    user_id bigint not null,
    course_id bigint not null,
    registration_date date not null,

    primary key(id),
    constraint fk_user foreign key (user_id) references users(id),
    constraint fk_course foreign key (course_id) references courses(id)
);