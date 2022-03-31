use furama;
select n_v.*
from nhan_vien n_v
where n_v.ho_ten regexp "^[HKT]" and char_length(n_v.ho_ten) <= 15;