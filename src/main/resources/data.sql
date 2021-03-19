DROP table User if exists;
CREATE TABLE User (
    id INT IDENTITY NOT NULL,
    name VARCHAR(255) NOT NULL,
    birthdate Date NOT NULL,
    PRIMARY KEY (id)
);
insert into user(birthdate, name) values (sysdate(),'AB');
insert into user(birthdate, name) values (sysdate(),'Jill');
insert into user(birthdate, name) values (sysdate(),'Jam');
