use furama;
select distinct d_v.ma_dich_vu, d_v.ten_dich_vu,d_v.dien_tich,d_v.chi_phi_thue,l_d_v.ten_loai_dich_vu
from dich_vu d_v inner join loai_dich_vu l_d_v
on d_v.ma_loai_dich_vu = l_d_v.ma_loai_dich_vu
inner join hop_dong h_d
on d_v.ma_dich_vu = h_d.ma_dich_vu
where h_d.ma_dich_vu not in (select ma_dich_vu from hop_dong h_d where 
year (h_d.ngay_lam_hop_dong) = "2021" and quarter(h_d.ngay_lam_hop_dong) = 1)
-- join bảng dịch vụ với bảng loại dịch vụ để hiển thị tên loại dịch vụ trên select
-- join tiếp bảng hợp đồng, điều kiện ở where là mã dịch vụ ko nằm trong truy vấn các dịch vụ đã đặt trong năm 2021 và quý 1