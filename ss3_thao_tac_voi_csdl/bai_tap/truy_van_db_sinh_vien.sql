use quan_ly_sinh_vien;

select student.student_name from student
where student.student_name like "h%";

select class.* from class
where month(start_date) =12;

select `subject`.* from `subject`
where credit between 3 and 5;

set sql_safe_updates = 0;
update student
set class_id = 2
where student_name = "Hung";
set sql_safe_updates = 1;

select s.student_name, sub.sub_name, m.mark
from student s inner join mark m on s.student_id = m.student_id
inner join `subject` sub on sub.sub_id = m.sub_id;
