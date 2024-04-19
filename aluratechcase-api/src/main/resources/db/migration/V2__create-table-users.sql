create table users(

    id bigint not null auto_increment,
    name varchar(50) not null,
    username varchar(50) not null,
    email varchar(50) not null,
    password varchar(100),
    role varchar(50) not null,
    date_creation date not null,

    primary key(id)

);