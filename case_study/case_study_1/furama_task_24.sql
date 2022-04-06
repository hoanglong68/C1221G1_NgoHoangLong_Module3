use furama;
delimiter //
create procedure sp_them_moi_hop_dong (
in ngay_lam_hop_dong datetime, 
in ngay_ket_thuc datetime, 
in tien_dat_coc double,
in ma_nhan_vien int,
in ma_khach_hang int,
in ma_dich_vu int
)
begin
if
( (select ma_nhan_vien from nhan_vien where nhan_vien.ma_nhan_vien = ma_nhan_vien)
and (select ma_khach_hang from khach_hang where khach_hang.ma_khach_hang = ma_khach_hang)
and (select ma_dich_vu from dich_vu where ma_dich_vu = dich_vu.ma_dich_vu)
and (ngay_ket_thuc > ngay_lam_hop_dong)) then 
insert into hop_dong (ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
values(
ngay_lam_hop_dong,
ngay_ket_thuc,
tien_dat_coc,
ma_nhan_vien,
ma_khach_hang,
ma_dich_vu
);
else signal sqlstate "45000" set message_text = "sai dữ liệu";
end if;
end //
delimiter ;
drop procedure sp_them_moi_hop_dong;
call sp_them_moi_hop_dong ("2020-02-02","2020-02-05",200000,1,1,1);