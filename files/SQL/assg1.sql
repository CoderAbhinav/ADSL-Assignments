#---1---
#create a database
create database inventory;
use inventory;

# create database store
create table products(
	prod_id int auto_increment,
    prod_name varchar(255),
    prod_price float,
    prod_qty int,
    prod_location varchar(10),
    brand int,
    distributer int,
    unique key prod_id(prod_id)
);

# changing auto increment value
alter table products auto_increment=10000;

# adding entries
insert into products values
(default, 'Dairymilk', 5, 100,'l1', 1, 1),
(default, 'Dairymulk', 10, 100,'l1', 1, 1),
(default, 'Perk', 10, 100, 'l2', 1, 1),
(default, 'Kitkat', 10, 100, 'l2', 2, 2),
(default, 'Oreo', 10, 100, 'l3', 1, 3),
(default, 'Haldiram Banana Chips', 15, 50, 'l5', 4, 4),
(default, 'Haldiram Potato Wafers', 10, 50, 'l5', 4, 4),
(default, 'Lays Chips', 10, 50, 'l5', 5, 5),
(default, 'Chitale Bakarwadi', 85, 50, 'l6', 6, 6),
(default, 'Amul Mithai Made', 100, 50, 'l10', 7, 7),
(default, 'Go Cheeze', 10, 100, 'l10', 8, 8),
(default, 'Go Cheeze', 110, 100, 'l10', 8, 8),
(default, 'Gowardhan Ghee', 250, 30, 'l10', 8, 8),
(default, 'wrong', 222, 22, '22', 10, 10)
;

#---2---
# altering table
alter table products add offer int;

# updating values
update products set offer=11 where prod_id > 10000;

# deleting an entry
delete from products where prod_id=10013;

#---3---
desc products;
show indexes from products;
select * from products;

#---4---
# sql functions
# sum : displaying total inventry items
select sum(prod_qty) from products;

# count : number of rows based on specific condition
select count(prod_id) from products where brand=8;

# average : average of values in column
select avg(prod_price) from products;

# min : minimum value in column
select min(prod_price) from products;

# max : maximum value in column
select max(prod_price) from products;

# first : first value of the column
select * from products limit 2;

#---5---

# union
select prod_id from products union select prod_price from products;

# intersection
select prod_price from products where prod_price in  (select prod_qty from products);

#---6---
drop table products;
drop database inventory;