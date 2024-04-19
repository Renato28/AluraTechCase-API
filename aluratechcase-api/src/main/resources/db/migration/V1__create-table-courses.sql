create table courses(

    id bigint not null auto_increment,
    name varchar(50) not null,
    code varchar(10) not null,
    instructor varchar(50) not null,
    description varchar(100) not null,
    creation_date date not null,
    inactivation_date date not null,

    primary key(id)

);