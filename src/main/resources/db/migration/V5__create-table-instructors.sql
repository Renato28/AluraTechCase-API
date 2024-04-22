create table instructors (
    id bigint not null,
    cpf varchar(15) not null unique,
    birth_date date not null,
    primary key(id),
    foreign key (id) references users(id)
)