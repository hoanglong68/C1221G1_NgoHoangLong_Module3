use furama;
drop function if exists func_dem_dich_vu;

delimiter //
create function func_dem_dich_vu() returns int
deterministic
begin
declare tong_cong int;
set tong_cong = (select count(*) as count from (select sum((dich_vu.chi_phi_thue + coalesce((dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong),0))) as tong_tien
from dich_vu inner join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_hop_dong
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by dich_vu.ma_dich_vu having tong_tien > 2000000 ) as temp_table);
return (tong_cong);
end //
delimiter ;
select func_dem_dich_vu() as "số lượng có tổng dịch vụ trên 2 củ"

drop function if exists (ma_khach_hang int)
