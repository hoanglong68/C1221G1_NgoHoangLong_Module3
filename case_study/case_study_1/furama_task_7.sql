use furama;
select d_v.ma_dich_vu, d_v.ten_dich_vu, d_v.dien_tich, d_v.so_nguoi_toi_da, d_v.chi_phi_thue,l_d_v.ten_loai_dich_vu
from dich_vu d_v inner join loai_dich_vu l_d_v
on d_v.ma_loai_dich_vu = l_d_v.ma_loai_dich_vu
inner join hop_dong h_d
on d_v.ma_dich_vu = h_d.ma_dich_vu
where h_d.ma_dich_vu not in (select ma_dich_vu from hop_dong where year(ngay_lam_hop_dong) != "2020"
and year(ngay_lam_hop_dong) = "2021"
group by ma_dich_vu)
group by h_d.ma_dich_vu;
-- điều kiện mã dịch vụ ko nằm trong truy vấn mã dịch vụ trong hợp đồng có năm khác năm 2020 và là năm 2021