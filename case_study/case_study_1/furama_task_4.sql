use furama;
select k_h.ma_khach_hang,k_h.ho_ten, count(k_h.ma_khach_hang) as so_lan_dat_phong
from khach_hang k_h inner join hop_dong h_d
on k_h.ma_khach_hang = h_d.ma_khach_hang
inner join loai_khach l_k
on (l_k.ma_loai_khach = 1) = k_h.ma_loai_khach
group by ma_khach_hang
order by so_lan_dat_phong
