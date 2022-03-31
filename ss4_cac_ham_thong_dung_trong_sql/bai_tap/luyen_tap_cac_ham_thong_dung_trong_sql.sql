use quan_ly_sinh_vien;
select sub.*
from `subject` sub
where sub.credit = (
select max(sub.credit)
from `subject` sub
);

select sub.* , max(m.mark) as max_point
from mark m inner join `subject` sub
on m.sub_id = sub.sub_id
where m.mark = (
select max(m.mark)
from mark m
);

select s.*, avg(m.mark) as avg_point
from student s inner join mark m
on s.student_id = m.student_id
group by student_id
order by avg_point desc;