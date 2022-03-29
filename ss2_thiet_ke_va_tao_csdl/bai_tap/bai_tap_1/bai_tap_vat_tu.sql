create database quan_li_vat_tu;
use quan_li_vat_tu;
create table nha_cung_cap(
ma_nha_cung_cap int auto_increment,
ten_nha_cung_cap varchar(50),
dia_chi varchar(100),
primary key (ma_nha_cung_cap)
);
create table sdt(
ma_nha_cung_cap int,
sdt varchar(10),
primary key (sdt),
foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);
create table don_dat_hang(
so_dat_hang int auto_increment,
ngay_dat_hang date,
ma_nha_cung_cap int,
primary key (so_dat_hang),
foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);
create table vat_tu(
ma_vat_tu int auto_increment,
ten_vat_tu varchar(50),
primary key (ma_vat_tu)
);
create table chi_tiet_don_dat_hang(
so_dat_hang int ,
ngay_dat_hang date,
ma_vat_tu int ,
ten_vat_tu varchar(50),
primary key (so_dat_hang,ma_vat_tu),
foreign key (so_dat_hang) references don_dat_hang(so_dat_hang),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
create table phieu_xuat(
so_phieu_xuat int auto_increment,
ngay_xuat date,
primary key (so_phieu_xuat)
);
create table chi_tiet_phieu_xuat(
ma_vat_tu int,
so_phieu_xuat int,
don_gia_xuat double,
so_luong_xuat int,
primary key (ma_vat_tu,so_phieu_xuat),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key (so_phieu_xuat) references phieu_xuat(so_phieu_xuat)
);
create table phieu_nhap(
so_phieu_nhap int auto_increment,
ngay_nhap date,
primary key (so_phieu_nhap)
);
create table chi_tiet_phieu_nhap(
ma_vat_tu int,
so_phieu_nhap int,
don_gia_nhap double,
so_luong_nhap int,
primary key(ma_vat_tu,so_phieu_nhap),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu),
foreign key (so_phieu_nhap) references phieu_nhap(so_phieu_nhap)
);





