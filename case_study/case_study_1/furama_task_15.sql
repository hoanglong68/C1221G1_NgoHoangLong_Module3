use furama;
select n_v.ma_nhan_vien,n_v.ho_ten,t_d.ten_trinh_do,b_p.ten_bo_phan,n_v.so_dien_thoai,n_v.dia_chi
from nhan_vien n_v inner join trinh_do t_d on n_v.ma_trinh_do = t_d.ma_trinh_do
inner join bo_phan b_p on n_v.ma_bo_phan = b_p.ma_bo_phan
inner join hop_dong h_d on h_d.ma_nhan_vien = n_v.ma_nhan_vien 
where h_d.ma_nhan_vien in (select h_d.ma_nhan_vien from hop_dong h_d where year(h_d.ngay_lam_hop_dong) between 2020 and 2021)
group by n_v.ma_nhan_vien
having count(h_d.ngay_lam_hop_dong) <= 3