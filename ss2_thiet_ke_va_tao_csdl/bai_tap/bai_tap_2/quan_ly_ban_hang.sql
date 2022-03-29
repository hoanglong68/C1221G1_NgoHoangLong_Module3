create database sales_manager;
use sales_manager;
create table customer(
id_customer int auto_increment,
name_customer varchar(50),
date_of_birth_customer date,
primary key (id_customer)
);
create table `order`(
id_order int auto_increment,
id_customer int,
date_order date,
total_price_order double,
primary key (id_order),
foreign key (id_customer) references customer(id_customer)
);
create table product(
id_product int auto_increment,
name_product varchar(50),
price_product double,
primary key (id_product)
);
create table order_detail(
id_order int,
id_product int,
quality_order varchar(50),
primary key(id_order,id_product),
foreign key (id_order) references `order`(id_order),
foreign key (id_product) references product(id_product)
);