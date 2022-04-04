use furama;
select month(h_d.ngay_lam_hop_dong) as thang, count(month(h_d.ngay_lam_hop_dong)) as so_lan_dat
from hop_dong h_d
where year(h_d.ngay_lam_hop_dong) = "2021"
group by thang
order by thang;