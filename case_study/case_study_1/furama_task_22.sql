use furama;
select * from v_nhan_vien;
set sql_safe_updates = 0;
update v_nhan_vien
set v_nhan_vien.dia_chi = "Liên Chiểu"
where v_nhan_vien.dia_chi like "% Hải Châu%";
set sql_safe_updates = 1;