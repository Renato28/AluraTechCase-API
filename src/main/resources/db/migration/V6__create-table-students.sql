create table students (
    id bigint not null,
    cpf varchar(15) not null unique,
    birthDate date not null,
    primary key(id),
    foreign key (id) references users(id)
)