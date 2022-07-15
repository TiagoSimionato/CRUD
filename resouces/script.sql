create database clientes;

create table clients (
	id int not null auto_increment primary key,
	name varchar(40),
	age int,
	email varchar(60)
)