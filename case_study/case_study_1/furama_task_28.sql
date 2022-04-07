use furama;
drop procedure if exists sp_xoa_dich_vu_va_hd_room;
delimiter //
create procedure sp_xoa_dich_vu_va_hd_room ()
begin
declare dich_vu int default 0;
declare da_xong int default 0;
declare con_tro cursor for
select dich_vu.ma_dich_vu
from dich_vu inner join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
inner join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
where loai_dich_vu.ten_loai_dich_vu = "room" and year(hop_dong.ngay_lam_hop_dong) between "2015" and "2025";
declare continue handler for not found set da_xong = 1;
open con_tro;
get_list: loop
fetch from con_tro into dich_vu;
if da_xong = 1 then
leave get_list;
end if;
delete from hop_dong where hop_dong.ma_dich_vu = dich_vu;
delete from dich_vu where dich_vu.ma_dich_vu = dich_vu;
delete from hop_dong_chi_tiet where (hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong) and (hop_dong_chi_tiet.ma_dich_vu = dich_vu.ma_dich_vu);
fetch next from con_tro into dich_vu;
end loop get_list;
close con_tro;
end //
delimiter ;

call sp_xoa_dich_vu_va_hd_room;
