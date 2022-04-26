drop database if exists products_management;
create database if not exists products_management;
use products_management;
create table color(
id_color int auto_increment,
name_color varchar(45),
primary key (id_color)
);
create table category(
id_category int auto_increment,
name_category varchar(45),
primary key (id_category)
);
create table products (
id_product  int auto_increment,
    name_product varchar(45),
    price double,
    quantity int,
    id_color int,
    id_category int,
    primary key (id_product),
    foreign key (id_color) references color (id_color) on delete set null,
    foreign key (id_category) references category (id_category) on delete set null
);