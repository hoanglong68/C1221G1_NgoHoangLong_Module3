create table student_management.class(
id int auto_increment,
`name` varchar(45),
primary key (id)
);
create table student_management.teacher(
id int auto_increment,
`name` varchar(45),
age int,
country varchar(45),
primary key(id)
);