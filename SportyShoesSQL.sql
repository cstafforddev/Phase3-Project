create database ss;
use ss;

create table Mens_Running_Shoes(size double, quantity int);
create table Mens_Stylish_Shoes(size double, quantity int);
create table Womens_Running_Shoes(size double, quantity int);
create table Womens_Stylish_Shoes(size double, quantity int);

create table PurchaseHistory(category varchar(60), size varchar(60), name varchar(60), email varchar(60), date varchar(60) PRIMARY KEY);

create table admin(email varchar(60), password varchar(60));
insert into admin values("admin@gm.c", "admin123");

create table user(name varchar(60), email varchar(60), password varchar(60));
insert into user values("Chaz", "C@gm.c", "password123");

select * from admin;
select * from user;
drop table user;
select * from womens_running_shoes;
select * from womens_stylish_shoes;
select * from PurchaseHistory;
drop table purchase_history;

select * from Mens_Running_Shoes;
select * from Mens_Stylish_Shoes;
select * from Womens_Running_Shoes;
select * from Womens_Stylish_Shoes;
drop Table womens_Shoes;

insert into Mens_Running_Shoes values(9,4);
insert into Mens_Running_Shoes values(9.5,7);
insert into Mens_Running_Shoes values(10,10);
insert into Mens_Running_Shoes values(10.5,9);
insert into Mens_Running_Shoes values(11, 13);
insert into Mens_Running_Shoes values(11.5, 6);
insert into Mens_Running_Shoes values(12, 5);

insert into Mens_Stylish_Shoes values(9,3);
insert into Mens_Stylish_Shoes values(9.5,5);
insert into Mens_Stylish_Shoes values(10,8);
insert into Mens_Stylish_Shoes values(10.5,8);
insert into Mens_Stylish_Shoes values(11, 10);
insert into Mens_Stylish_Shoes values(11.5, 9);
insert into Mens_Stylish_Shoes values(12, 7);

insert into Womens_Running_Shoes values(9,15);
insert into Womens_Running_Shoes values(9.5,13);
insert into Womens_Running_Shoes values(10,9);
insert into Womens_Running_Shoes values(10.5,9);
insert into Womens_Running_Shoes values(11, 6);
insert into Womens_Running_Shoes values(11.5, 6);
insert into Womens_Running_Shoes values(12, 2);

insert into Womens_Stylish_Shoes values(9,11);
insert into Womens_Stylish_Shoes values(9.5,10);
insert into Womens_Stylish_Shoes values(10,9);
insert into Womens_Stylish_Shoes values(10.5,10);
insert into Womens_Stylish_Shoes values(11, 7);
insert into Womens_Stylish_Shoes values(11.5, 6);
insert into Womens_Stylish_Shoes values(12, 3);