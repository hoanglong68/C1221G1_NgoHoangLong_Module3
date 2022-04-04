use furama;
-- chưa bật safe mode nên chưa xoá nhưng code chạy được
set sql_safe_updates = 0;
delete from nhan_vien
where nhan_vien.ma_nhan_vien not in (select ma_nhan_vien from hop_dong where year(hop_dong.ngay_lam_hop_dong) between 2019 and 2021);
set sql_safe_updates = 1;
