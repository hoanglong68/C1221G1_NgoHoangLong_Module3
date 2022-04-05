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
insert into hop_dong values(
ngay_lam_hop_dong,
ngay_ket_thuc,
tien_dat_coc,
ma_nhan_vien,
ma_khach_hang,
ma_dich_vu
);
end //
delimiter ;

call sp_them_moi_hop_dong ("2020-02-02","2020-02-05",200000,1,3,2);