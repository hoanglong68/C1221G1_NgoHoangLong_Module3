create database student_management;
create table student_management.student(
id int auto_increment,
`name` varchar(45),
age int,
country varchar(45),
primary key (id)
);