use furama;
delimiter //
create trigger tr_cap_nhat_hop_dong after update on hop_dong for each row
begin
set @x = true
select ngay_lam_hop_dong from hop_dong 
delimiter ;