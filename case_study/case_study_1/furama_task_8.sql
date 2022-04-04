use furama;
-- cach 1
select k_h.ho_ten from khach_hang k_h
group by k_h.ho_ten;

-- cach 2
select distinct k_h.ho_ten from khach_hang k_h;

-- cach 3
select k_h.ho_ten from khach_hang k_h
union
select k_h.ho_ten from khach_hang k_h;