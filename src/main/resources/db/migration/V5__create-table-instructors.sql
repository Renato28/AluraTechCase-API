create table instructors (
    user_id bigint not null,
    cpf varchar(15) not null unique,
    birthDate date not null,
    primary key(id),
    foreign key (user_id) references users(id)
)