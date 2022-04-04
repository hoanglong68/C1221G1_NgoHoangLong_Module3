use furama;
alter table hop_dong
drop constraint hop_dong_ibfk_2;
alter table hop_dong
add constraint hop_dong_ibfk_2 foreign key (ma_khach_hang) references khach_hang(ma_khach_hang)
on delete set null ;
set sql_safe_updates = 0;
delete kh
from khach_hang kh inner join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where year(ngay_lam_hop_dong) < 2021;
set sql_safe_updates = 1;
-- ràng buộc khoá ngoại khi xoá sẽ bị null và tham chiếu sang bảng hợp đồng sẽ bị lỗi
-- cần phải thêm điều kiện nếu xoá khoá ngoại thì set lại khoá ngoại đó là null