use furama;
delimiter //
create trigger tr_cap_nhat_hop_dong after update on hop_dong for each row
begin
 if datediff(new.ngay_ket_thuc,old.ngay_lam_hop_dong) < 2 then
 signal sqlstate "45000" set message_text = "ngày kết thúc phải lớn hơn ngày làm ít nhất 2 ngày ";
 end if;
 end //
delimiter ;
update hop_dong set ngay_ket_thuc = "2021-12-31" where hop_dong.ma_hop_dong = 3;