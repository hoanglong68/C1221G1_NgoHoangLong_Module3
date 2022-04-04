use furama;
create view soluong as
select dvdk.ma_dich_vu_di_kem,hdct.so_luong,hd.ngay_lam_hop_dong from hop_dong_chi_tiet hdct inner join hop_dong hd
on hdct.ma_hop_dong = hd.ma_hop_dong
inner join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
where so_luong > 10 and year(hd.ngay_lam_hop_dong) = 2020
group by hdct.so_luong;
set sql_safe_updates = 0;
update dich_vu_di_kem dvdk
set dvdk.gia = dvdk.gia*2
where dvdk.ma_dich_vu_di_kem in (Select ma_dich_vu_di_kem from soluong);
set sql_safe_updates = 1;
