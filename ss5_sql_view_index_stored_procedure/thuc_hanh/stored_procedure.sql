use classicmodels;
delimiter //
create procedure find_all_customers()
begin
select * from customers;
end //
delimiter ;

call find_all_customers();

delimiter //
drop procedure if exists find_all_customers //

create procedure find_all_customers()
begin
select * from customers where customerNumber = 175;
end //

call find_all_customers();