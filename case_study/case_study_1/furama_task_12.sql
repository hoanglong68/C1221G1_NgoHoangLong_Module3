use furama;
select h_d.ma_hop_dong, n_v.ho_ten as ho_ten_nhan_vien,k_h.ho_ten as ho_ten_khach_hang, k_h.so_dien_thoai as so_dien_thoai_khach_hang,
coalesce((sum(h_d_c_t.so_luong)),0) as so_luong_dich_vu_di_kem, h_d.tien_dat_coc
from hop_dong h_d left join khach_hang k_h on h_d.ma_khach_hang = k_h.ma_khach_hang
left join nhan_vien n_v on h_d.ma_nhan_vien = n_v.ma_nhan_vien
left join hop_dong_chi_tiet h_d_c_t on h_d_c_t.ma_hop_dong = h_d.ma_hop_dong
where h_d.ma_hop_dong in (select h_d.ma_hop_dong from hop_dong h_d where (quarter(h_d.ngay_lam_hop_dong) = 4 and year(h_d.ngay_lam_hop_dong) = 2020)
and not (quarter(h_d.ngay_lam_hop_dong) in (1,2) and year(h_d.ngay_lam_hop_dong)= "2021"))
group by h_d.ma_hop_dong
-- điều kiện mã hợp đồng nằm trong truy vấn quý 4 năm 2020 và không nằm trong quý 1 2 năm 2021