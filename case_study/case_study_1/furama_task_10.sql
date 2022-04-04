use furama;
select h_d.ma_hop_dong, h_d.ngay_lam_hop_dong, h_d.ngay_ket_thuc, h_d.tien_dat_coc, coalesce((sum(h_d_c_t.so_luong)),0) as so_luong_dich_vu_di_kem
from hop_dong h_d left join hop_dong_chi_tiet h_d_c_t
on h_d.ma_hop_dong = h_d_c_t.ma_hop_dong
left join dich_vu_di_kem
on h_d_c_t.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by h_d.ma_hop_dong