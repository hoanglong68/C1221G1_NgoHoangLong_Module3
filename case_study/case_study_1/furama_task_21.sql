use furama;
create view v_nhan_vien as
select * from nhan_vien
where nhan_vien.dia_chi like "% Hải Châu%" and ma_nhan_vien in (select ma_nhan_vien from hop_dong where date(hop_dong.ngay_lam_hop_dong) = "2019-12-12");
select * from v_nhan_vien;
drop view v_nhan_vien;