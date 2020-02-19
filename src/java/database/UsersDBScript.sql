DROP DATABASE if exists DogsDB;
CREATE DATABASE DogsDB;

USE DogsDB;

CREATE TABLE users (
    USERNAME VARCHAR(20) PRIMARY KEY,
    PASSWORD VARCHAR(20) NOT NULL,
    FIRST_NAME VARCHAR(20) NOT NULL,
    LAST_NAME VARCHAR(20) NOT NULL,
    EMAIL VARCHAR(40) NOT NULL,
    PHONE_NUMBER VARCHAR(10) NOT NULL,
    EMERGENCY_PHONE VARCHAR(10) NOT NULL,
    EMERGENCY_NAME VARCHAR(40) NOT NULL,
    ISACTIVE BOOLEAN NOT NULL,
    ISDISABLED BOOLEAN NOT NULL
);

CREATE TABLE user_address (
    USERNAME VARCHAR(20),
    BUILDING_NUM VARCHAR(5),
    HOUSE_APT_NUM VARCHAR(10),
    STREET VARCHAR(20),
    CITY VARCHAR(20),
    PROVINCE VARCHAR(20),
    POSTAL VARCHAR(6)
);

Alter Table USER_ADDRESS
Add FOREIGN KEY (USERNAME)
References USERS (USERNAME);

INSERT INTO users
VALUES ('admin', 'password', 'Carsen', 'Johns', 'example@email.com', '4031234567', '4037654321', 'PeepeepoopooMan', true, false);

INSERT INTO user_address
VALUES ('admin', '111a', '123b', 'Senator Burns', 'Calgary', 'Alberta', 'A1A1A1');

COMMIT;
