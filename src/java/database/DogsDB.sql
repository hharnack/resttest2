DROP DATABASE if exists DogsDB;
CREATE DATABASE DogsDB;

USE DogsDB;

CREATE TABLE users (
    username VARCHAR(20) NOT NULL, 
    password VARCHAR(20) NOT NULL, 
    firstname VARCHAR(20), 
    lastname VARCHAR(20), 
    email VARCHAR(40), 
    CONSTRAINT PK_username PRIMARY KEY (username));

INSERT INTO users(username, password)
VALUES("admin","password");
COMMIT;
