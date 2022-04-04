use furama;
update khach_hang
set ma_loai_khach = 1
where ma_khach_hang in (
    select khach_hang_can_sua
    from (
             select kh.ma_khach_hang as khach_hang_can_sua
             from khach_hang kh
                      inner join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
                      left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
                      left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
                      left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
                      left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
             where year(hd.ngay_lam_hop_dong) = 2021
               and lk.ma_loai_khach = 2
             group by kh.ma_khach_hang
             having (sum((dv.chi_phi_thue + coalesce(dvdk.gia * hdct.so_luong, 0))) > 10000000)) as ma_loai_khach)