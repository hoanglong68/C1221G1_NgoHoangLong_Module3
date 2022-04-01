use classicmodels;
delimiter //
create procedure get_customer_by_id(in customer_number int(11))
begin
select * from customers where customerNumber = customer_number;
end //
delimiter ;

call get_customer_by_id(175);

delimiter //
create procedure get_customer_count_by_city(in in_city varchar(45), out total int)
begin
select count(customerNumber)
into total
from customers
where city = in_city;
end //
delimiter ;
call get_customer_count_by_city("Lyon",@total);
select @total;

delimiter //
create procedure set_counter(inout counter int, in inc int)
begin
set counter = counter + inc;
end //
delimiter ;

set @counter = 1;
call set_counter (@counter,1);
select @counter;

call set_counter (@counter,1);
select @counter;

call set_counter (@counter,5);
select @counter;