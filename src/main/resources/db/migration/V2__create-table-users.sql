create table users(

    id bigint not null auto_increment,
    name varchar(50) not null unique,
    username varchar(50) not null unique,
    email varchar(50) not null unique,
    password varchar(100),
    role varchar(50) not null,
    creation_date date not null,

    primary key(id)

);