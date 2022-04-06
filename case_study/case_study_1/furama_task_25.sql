use furama;
delimiter //
create trigger tr_xoa_hop_dong after delete on hop_dong for each row
begin
set @x  = (select count(hop_dong.ma_hop_dong) as count from hop_dong);
end //
delimiter ;
set @x = 0;
delete from hop_dong where hop_dong.ma_hop_dong = 10;
select @x as "số hợp đồng còn lại" ;
drop trigger tr_xoa_hop_dong;