CREATE DATABASE quizDb;
USE quizDb;

create table score
(
    id    int auto_increment,
    user  varchar(45) not null,
    score int default 0 not null,
    topic varchar(45) null,
    constraint score_pk
        primary key (id)
);
#need to ask preben about line 10, 15, 16

create unique index score_user_uindex
    on score (user);


create table multichoiceQuiz
(
    id            int auto_increment,
    question      varchar(80) not null,
    answerA       varchar(45) null,
    answerB       varchar(45) null,
    answerC       varchar(45) null,
    answerD       varchar(45) null,
    correctAnswer varchar(45) null,

    #need to check this section line

    constraint multichoiceQuiz_pk
        primary key (id)
);

create table binaryQuiz
(
    id            int auto_increment,
    question   varchar(90) null,
    correctAnswer varchar(45) null,
    constraint binaryQuiz_pk
        primary key (id)
);

create unique index binaryQuiz_id_uindex
    on binaryQuiz (id);

