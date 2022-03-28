create table student_management.class(
id int auto_increment not null,
`name` varchar(45) null,
primary key (id)
);
create table student_management.teacher(
id int auto_increment not null,
`name` varchar(45) null,
age int null,
country varchar(45) null,
primary key(id)
);