use furama;
select d_v_d_k.*
from dich_vu_di_kem d_v_d_k left join hop_dong_chi_tiet h_d_c_t
on d_v_d_k.ma_dich_vu_di_kem = h_d_c_t.ma_dich_vu_di_kem
left join hop_dong h_d on h_d.ma_hop_dong = h_d_c_t.ma_hop_dong
left join khach_hang k_h on k_h.ma_khach_hang = h_d.ma_khach_hang
left join loai_khach l_k on l_k.ma_loai_khach = k_h.ma_loai_khach
where l_k.ma_loai_khach = 1 and (k_h.dia_chi like "% Vinh%" or k_h.dia_chi like "% Quảng Ngãi%")
group by h_d_c_t.ma_dich_vu_di_kem;