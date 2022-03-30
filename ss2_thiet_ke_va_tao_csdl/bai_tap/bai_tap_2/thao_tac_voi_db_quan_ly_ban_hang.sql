use sales_manager;
alter table customer add column age tinyint;
insert into customer (name_customer,age)
values 
("Minh Quan",10),
("Ngoc Oanh",20),
("Hong Ha",50)
;

insert into `order` (id_customer,date_order)
values 
(1,"2006-03-21"),
(2,"2006-03-23"),
(1,"2006-03-16")
;

insert into product(name_product,price_product) values 
("May Giat",3),
("Tu Lanh",5),
("Dieu Hoa",7),
("Quat",1),
("Bep Dien",2)
;

insert into order_detail (id_order,id_product,quantity_order)
values 
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3)
;
select `order`.id_order, `order`.date_order, `order`.total_price_order di
from `order`;

select distinct c.name_customer,p.name_product
from customer c right join `order` o
on c.id_customer = o.id_customer
right join order_detail o_d
on o.id_order  = o_d.id_order
inner join product p
on p.id_product = o_d.id_product;

-- trái là bảng customer phải là order, left lấy bên trái nếu bên phải null ko có thì lấy
select c.name_customer
from customer c left join `order` o
on c.id_customer = o.id_customer
where o.id_customer is null;

select  o.id_order,o.date_order, p.price_product * o_d.quantity_order as total_price
from `order` o right join order_detail o_d
on o.id_order = o_d.id_order
inner join product p
on p.id_product = o_d.id_product;
