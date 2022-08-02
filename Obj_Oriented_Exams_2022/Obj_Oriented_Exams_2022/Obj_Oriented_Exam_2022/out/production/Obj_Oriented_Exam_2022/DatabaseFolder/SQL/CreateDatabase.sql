/*
 ---------
 IMPORTANT
 ---------
 Remember to chose MySQL as datasource in the database tab in IntelliJ.
 Press the + on the top of the database tab, select Data Source, Select MySQL,
 Press Apply and sign in with your root username and root password

---------
IMPORTANT
---------
 - Run CREATE DATABASE IF NOT EXISTS quizDb; by itself
 - Run USE quizDb; by itself
 - The rest of the CREATE TABLE IF NOT EXISTS can be run together

 - If you meet the error that the database will not show on the right hand menu,
 drop the database with DROP DATABASE quizdb;
 */

#ONLY USE IF NECESSARY
DROP database quizdb;

CREATE DATABASE IF NOT EXISTS quizDb;

USE quizDb;

CREATE TABLE IF NOT EXISTS quizdb.binaryquiz
(
    ID            int auto_increment
        primary key,
    question      varchar(100) null,
    correctAnswer varchar(45) null
);

CREATE TABLE IF NOT EXISTS quizdb.multichoicequiz
(
    ID            int auto_increment
        primary key,
    question      varchar(100) null,
    answerA       varchar(45) null,
    answerB       varchar(45) null,
    answerC       varchar(45) null,
    answerD       varchar(45) null,
    correctAnswer varchar(45) null
);

CREATE TABLE IF NOT EXISTS quizdb.scorehistory
(
    ID    int auto_increment
        primary key,
    user  varchar(45) null,
    score int         null,
    topic varchar(20) null
);
