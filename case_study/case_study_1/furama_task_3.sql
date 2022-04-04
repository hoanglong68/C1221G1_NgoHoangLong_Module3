use furama;
select k_h.*, round(datediff(curdate(), k_h.ngay_sinh) / 365) as age
from khach_hang k_h
where (round(datediff(curdate(), k_h.ngay_sinh) / 365) between 18 and 50)
  and (
    k_h.dia_chi like "% Đà Nẵng" or k_h.dia_chi like "% Quảng Trị"
    )
;