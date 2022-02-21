# create a database
create database inventory;
use inventory;

# create database store
create table products(
	prod_id int auto_increment primary key,
    prod_name varchar(255),
    prod_price float,
    
);