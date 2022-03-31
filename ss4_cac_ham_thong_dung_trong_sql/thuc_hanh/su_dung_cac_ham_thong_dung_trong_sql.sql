use quan_ly_sinh_vien;
select address, count(address) as quanity_student
from student
group by address;

select s.student_name, avg(m.mark) as average_point
from student s inner join mark m 
on s.student_id = m.student_id
group by s.student_name;

select s.student_name, avg(m.mark) as average_point
from student s inner join mark m 
on s.student_id = m.student_id
group by s.student_name
having average_point > 15;

-- truy vấn con ở trong all
-- chọn các điểm trung bình từ bảng mark với group by là student_id
select s.student_name, avg(m.mark) as average_point
from student s inner join mark m 
on s.student_id = m.student_id
group by s.student_name
having average_point >=
all (
select avg(m.mark)
from mark m
group by m.student_id
);