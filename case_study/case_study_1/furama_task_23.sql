use furama;
delimiter //
create procedure sp_xoa_khach_hang (in ma_xoa int)
begin
delete from khach_hang
where khach_hang.ma_khach_hang = ma_xoa;
end //
delimiter ;

call sp_xoa_khach_hang(11);

