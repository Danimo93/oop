CREATE DATABASE quizDb;
USE quizDb;

create table binaryquiz
(
    id int auto_increment primary key,
    question      varchar(90) null,
    correctAnswer varchar(45) null,
    constraint binaryQuiz_id_uindex unique (id)
);

create table multichoicequiz
(
    id            int auto_increment
        primary key,
    question      varchar(80) not null,
    answerA       varchar(45) null,
    answerB       varchar(45) null,
    answerC       varchar(45) null,
    answerD       varchar(45) null,
    correctAnswer varchar(45) null
);

create table score
(
    id    int auto_increment
        primary key,
    user  varchar(45)   not null,
    score int default 0 not null,
    topic varchar(45)   null,
    constraint score_user_uindex
        unique (user)
);

