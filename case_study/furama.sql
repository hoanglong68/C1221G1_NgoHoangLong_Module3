create database furama;
use furama;
create table customer_type(
id_customer_type int auto_increment,
name_customer_type varchar(45),
primary key (id_customer_type)
);
create table customer(
id_customer int auto_increment,
id_customer_type int not null,
name_customer varchar(45)not null,
date_of_birth date not null,
gender bit(1) not null,
id_card varchar(45) not null,
phone_number varchar(45) not null,
email varchar(45),
address varchar(45),
primary key (id_customer),
foreign key (id_customer_type) references customer_type(id_customer_type)
);
create table `position`(
id_position int auto_increment,
name_position varchar(45),
primary key (id_position)
);
create table degree(
id_degree int auto_increment,
name_degree varchar(45),
primary key (id_degree)
);
create table department(
id_department int auto_increment,
name_department varchar(45),
primary key (id_department)
);
create table employee(
id_employee int auto_increment,
name_employee varchar(45) not null,
date_of_birth date not null,
id_card varchar(45) not null,
salary double not null,
phone_number varchar(45) not null,
email varchar(45),
address varchar(45),
id_position int not null,
id_degree int not null,
id_department int not null,
primary key (id_employee),
foreign key (id_position) references `position`(id_position),
foreign key (id_degree) references degree(id_degree),
foreign key (id_department) references department(id_department)
);
create table rent_type(
id_rent_type int auto_increment,
name_rent_type varchar(45),
primary key (id_rent_type)
);
create table service_type(
id_service_type int auto_increment,
name_service_type varchar(45),
primary key (id_service_type)
);
create table service(
id_service int auto_increment,
name_service varchar(45) not null,
area int,
cost double not null,
person_capacity int,
id_rent_type int not null,
id_service_type int not null,
standard_of_room varchar(45),
other_service varchar(45),
pool_area double,
floors int,
primary key (id_service),
foreign key (id_rent_type) references rent_type (id_rent_type),
foreign key (id_service_type) references service_type (id_service_type)
);
create table accompanied_service (
id_accompanied_service int auto_increment,
name_accompanied_service varchar(45) not null,
price double not null,
unit varchar(10) not null,
`status` varchar(45),
primary key (id_accompanied_service)
);
create table contract (
id_contract int auto_increment,
start_date datetime not null,
end_date datetime not null,
deposit double not null,
id_employee int not null,
id_customer int not null,
id_service int not null,
primary key (id_contract),
foreign key (id_employee) references employee(id_employee),
foreign key (id_customer) references customer(id_customer),
foreign key (id_service) references service(id_service)
);
create table details_contract(
id_details_contract int auto_increment,
id_contract int not null,
id_accompanied_service int not null,
quantity int not null,
primary key (id_details_contract),
foreign key (id_contract) references contract(id_contract),
foreign key (id_accompanied_service) references accompanied_service(id_accompanied_service)
);