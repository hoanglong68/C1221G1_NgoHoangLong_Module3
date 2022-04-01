use furama;
select k_h.ho_ten from khach_hang k_h
group by k_h.ma_khach_hang
having count(k_h.ma_khach_hang) = 1;