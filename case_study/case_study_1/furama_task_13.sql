use furama;
select d_v_d_k.*, sum(h_d_c_t.so_luong) as so_luong_dich_vu_di_kem
from dich_vu_di_kem d_v_d_k inner join hop_dong_chi_tiet h_d_c_t
on d_v_d_k.ma_dich_vu_di_kem = h_d_c_t.ma_dich_vu_di_kem
inner join hop_dong h_d on h_d.ma_hop_dong = h_d_c_t.ma_hop_dong
group by d_v_d_k.ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem = (select sum(h_d_c_t.so_luong) as so_luong_dich_vu_di_kem from hop_dong_chi_tiet h_d_c_t 
group by h_d_c_t.ma_dich_vu_di_kem
order by so_luong_dich_vu_di_kem desc
limit 1)
order by so_luong_dich_vu_di_kem desc
