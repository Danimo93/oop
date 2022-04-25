USE uniUsers;

CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    personnummer VARCHAR(15),
    name VARCHAR(45),
    dob DATE,
    campus VARCHAR(45),
    school VARCHAR(45),
    primary key (id)
);