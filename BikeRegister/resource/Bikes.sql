CREATE DATABASE GCN;
USE GCN;


create table RegisterBikes (
    id int auto_increment primary key,
    Name varchar(45) null,
    BrandName varchar(45) null,
    Component varchar(45) null,
    Weight varchar(45) null,
    Price varchar (45) null
)