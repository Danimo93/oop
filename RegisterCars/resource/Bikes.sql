CREATE DATABASE GCN;
USE GCN;

create table RoadBike(
  id int auto_increment primary key,
  Name varchar(255) null,
  BrandName varchar(255) null,
  Component varchar(255) null,
  Weight varchar(255) null,
  Price varchar (255) null
);

create table MountainBike(
id int auto_increment primary key,
  Name varchar(255) null,
  BrandName varchar(255) null,
  Component varchar(255) null,
  Weight varchar(255) null,
  Price varchar (255) null
);



create table RegisterBikes (
    id    int auto_increment
        primary key,
    user  varchar(45) not null,
    score int default 0 not null,
    topic varchar(45) null,
    constraint score_user_uindex
        unique (user)
)