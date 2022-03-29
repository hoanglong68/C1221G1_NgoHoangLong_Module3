create database point_management;
create table point_management.student(
code_student varchar(20),
name_student varchar(50),
  date_of_birth datetime,
  classroom varchar(20),
  teacher varchar(20),
  primary key (code_student)
);
create table point_management.`subject`(
code_subject varchar(20),
name_subject varchar(50),
primary key (code_subject)
);
create table point_management.`point`(
code_student varchar(20),
code_subject varchar(20),
`point` int,
date_exam datetime,
primary key (code_student,code_subject),
foreign key (code_student) references student(code_student),
foreign key (code_subject) references subject(code_subject)
);
create table point_management.teacher(
code_teacher varchar(20),
name_teacher varchar(20),
phone_number varchar(10),
primary key (code_teacher)
);
use point_management;
alter table `subject` add code_teacher varchar(20);
alter table `subject` add foreign key(code_teacher) references teacher(code_teacher);