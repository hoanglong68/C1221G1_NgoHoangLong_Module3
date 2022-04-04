use furama;
select h_d.ma_hop_dong,l_d_v.ten_loai_dich_vu,d_v_d_k.ten_dich_vu_di_kem, count(d_v_d_k.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong h_d 
inner join hop_dong_chi_tiet h_d_c_t on h_d.ma_hop_dong = h_d_c_t.ma_hop_dong
inner join dich_vu_di_kem d_v_d_k on h_d_c_t.ma_dich_vu_di_kem = d_v_d_k.ma_dich_vu_di_kem
inner join dich_vu d_v on d_v.ma_dich_vu = h_d.ma_dich_vu
inner join loai_dich_vu l_d_v on l_d_v.ma_loai_dich_vu = d_v.ma_loai_dich_vu
group by d_v_d_k.ma_dich_vu_di_kem
having count(d_v_d_k.ma_dich_vu_di_kem) = 1
order by ma_hop_dong;