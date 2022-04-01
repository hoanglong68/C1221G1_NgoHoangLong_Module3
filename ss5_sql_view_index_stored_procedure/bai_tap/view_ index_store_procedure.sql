use products;
create table products (
id int auto_increment,
`name` varchar(45),
price double,
amount int,
`description` varchar(50),
`status` bit(1),
primary key (id)
);

insert into products (`name`,price,amount,`description`,`status`)
values
("ban",100,2,"mau den",1),
("ghe",70,8,"mau do",0),
("quat",80,4,"tu dong",0),
("den",20,10,"huynh quang",1);

explain select * from products where products.id = 3;
-- type: const
explain select * from products where products.name = "quat";
-- type: all

create unique index id_idx
on products (id);

create index info_idx
on products (`name`,price);
explain select * from products where products.id = 3;
-- type: const
explain select * from products where products.name = "quat";
-- type: ref

create view products_view as
select id,`name`,price,`status` 
from products;

select * from products_view;

alter view products_view as
select id,`name`,price
from products;

select * from products_view;

delimiter //
create procedure show_all_info_product()
begin
select * from products;
end //
delimiter ;
 
call show_all_info_product();

delimiter //
create procedure add_new_product(
in `name` varchar(45),
in price double,
in amount int,
in `description` varchar(45),
`status` bit(1)
)
begin
insert into products (`name`,price,amount,`description`,`status`)
values
(`name`,price,amount,`description`,`status`);
end //
delimiter ;

call add_new_product("may bay",5000,1,"dung de bay",1);

call show_all_info_product();

delimiter //
create procedure edit_product(
in id int,
in `name` varchar(45),
in price double,
in amount int,
in `description` varchar(45),
`status` bit(1)
)
begin
update products
set products.`name` = `name`,
products.price = price,
products.amount = amount,
products.`description` = `description`,
products.`status` = `status`
where products.id = id;
end //
delimiter ;

call edit_product(3,"quat dien",120,5,"nang cap",1);

call show_all_info_product;

delimiter //
create procedure delete_product(in id int)
begin
delete from products
where products.id = id;
end //
delimiter ;

call show_all_info_product;

call delete_product(4);

call show_all_info_product;