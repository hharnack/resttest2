DROP DATABASE IF EXISTS DogsDB;
CREATE DATABASE DogsDB;

USE DogsDB;

-- users table
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
    ISDISABLED BOOLEAN NOT NULL,
    ISADMIN BOOLEAN NOT NULL
);

INSERT INTO users
VALUES ('admin', 'password', 'Carsen', 'Johns', 'example@email.com', '4031234567', '4037654321', 'PeepeepoopooMan', true, false, true);

-- user_address table
CREATE TABLE user_address (
    USERNAME VARCHAR(20),
    BUILDING_NUM VARCHAR(5),
    HOUSE_APT_NUM VARCHAR(10),
    STREET VARCHAR(20),
    CITY VARCHAR(20),
    PROVINCE VARCHAR(20),
    POSTAL VARCHAR(6)
);

ALTER TABLE user_address
ADD FOREIGN KEY (USERNAME)
REFERENCES users (USERNAME);

INSERT INTO user_address
VALUES ('admin', '111a', '123b', 'Senator Burns', 'Calgary', 'Alberta', 'A1A1A1');

-- dogs table
CREATE TABLE dogs (
    PET_ID INT AUTO_INCREMENT PRIMARY KEY,
    OWNER VARCHAR(20),
    NAME VARCHAR(20),
    BREED VARCHAR(20),
    WEIGHT DECIMAL(5, 2),
    BIRTH_DATE DATE,
    GENDER VARCHAR(6),
    SPAYED_NEUTERED BOOLEAN,
    STRANGER_FRIENDLY BOOLEAN,
    LARGE_FRIENDLY BOOLEAN,
    SMALL_FRIENDLY BOOLEAN,
    PUPPY_FRIENDLY BOOLEAN,
    PHYS_LIMIT VARCHAR(50),
    PHOTO_PATH VARCHAR(20),
    ACTIVE BOOLEAN,
    TRAINING_DONE BOOLEAN,
    FOREIGN KEY (OWNER) REFERENCES users(USERNAME)
);

INSERT INTO dogs (NAME, OWNER, BREED, WEIGHT, BIRTH_DATE, GENDER, SPAYED_NEUTERED, STRANGER_FRIENDLY, LARGE_FRIENDLY, SMALL_FRIENDLY, PUPPY_FRIENDLY, PHYS_LIMIT, PHOTO_PATH, TRAINING_DONE)
VALUES ('Max', 'admin' ,'Boston Terrier', 4.20, '2019-12-25', 'Male', true, true, true, true, true, 'Fallen and cant get up', '1.png', false);
INSERT INTO dogs (NAME, OWNER, BREED, WEIGHT, BIRTH_DATE, GENDER, SPAYED_NEUTERED, STRANGER_FRIENDLY, LARGE_FRIENDLY, SMALL_FRIENDLY, PUPPY_FRIENDLY, PHYS_LIMIT, PHOTO_PATH, TRAINING_DONE)
VALUES ('Sparky', 'admin' ,'Corgi', 4.20, '2019-12-25', 'Male', true, true, true, true, true, 'Fallen and cant get up', '2.png', true);

-- dogs_allergy table
CREATE TABLE dogs_allergy (
    PET_ID INT PRIMARY KEY,
    ALLERGY VARCHAR(200),
    FOREIGN KEY (PET_ID) REFERENCES dogs(PET_ID)
);

INSERT INTO dogs_allergy
VALUES (1, 'Coffee');

-- dogs_vaccine table
CREATE TABLE dogs_vaccines (
    PET_ID INT PRIMARY KEY,
    DA2PP DATE,
    RABIES DATE,
    BORDETELLA DATE,
    FOREIGN KEY (PET_ID) REFERENCES dogs(PET_ID)
);

INSERT INTO dogs_vaccines (PET_ID, DA2PP, RABIES, BORDETELLA)
VALUES (1, '2020-01-01', '2023-12-25', '2021-01-01');

-- dogs_medication table
CREATE TABLE dogs_medication (
    PET_ID INT PRIMARY KEY,
    MEDICATION VARCHAR(200),
    FOREIGN KEY (PET_ID) REFERENCES dogs(PET_ID)
);

INSERT INTO dogs_medication
VALUES (1, 'Advil');

--boarding
    CREATE TABLE BOARDING(
    BOARDING_ID INT PRIMARY KEY,
    GROOMING BOOLEAN
    );
--training
    CREATE TABLE TRAINING(
    TRAINING_ID int primary key,
    BARKING BOOLEAN,
    CHEWINGDESTRUCTION BOOLEAN,
    COUNTERSURFING BOOLEAN,
    DIGGING BOOLEAN,
    JUMPING BOOLEAN,
    PULLINGONLEASH BOOLEAN,
    BUILDINGCONDFIDENCE BOOLEAN,
    CHEWING BOOLEAN,
    HANDLING BOOLEAN,
    HOUSETRAINING BOOLEAN,
    MOUTHING BOOLEAN,
    SOCIALIZATION BOOLEAN,
    CHILDRENANDDOGS BOOLEAN,
    DISTRACTIONSTRATEGIES BOOLEAN,
    EXERCISE BOOLEAN,
    FOCUSSTRATEGIES BOOLEAN,
    LOOSELEASHWALKING BOOLEAN,
    MATWORK BOOLEAN,
    PLAY BOOLEAN,
    STEALINGITEMSCHASEGAME BOOLEAN,
    NEWHOUSEHOLDMEMBERS BOOLEAN,
    NEWBABY BOOLEAN,
    NEWCAT BOOLEAN,
    NEWDOG BOOLEAN,
    NEWHOME BOOLEAN,
    NEWSIGNIFICANTOTHER BOOLEAN
    );
-- appointments table
CREATE TABLE appointments (
    APPT_ID INT AUTO_INCREMENT PRIMARY KEY,
    Dog_id INT,
    USERNAME VARCHAR(20),
    BOARDING boolean,
    TRAINING boolean,
    DATE_START DATETIME,
    DATE_END DATETIME,
    TOTAL_COST DECIMAL(7, 2),
    AMOUNT_PAID DECIMAL(7, 2),
    ISAPPROVED BOOLEAN,
    ISCANCELLED BOOLEAN,
    ISPAID BOOLEAN,
    COMMENTS VARCHAR(100),
    FOREIGN KEY (USERNAME) REFERENCES USERS(USERNAME)
);

-- veterinarians table
CREATE TABLE veterinarians (
    VET_ID INT AUTO_INCREMENT PRIMARY KEY,
    PET_ID INT,
    NAME VARCHAR(30),
    CLINIC VARCHAR(30),
    PHONE_NUMBER VARCHAR(10),
    FOREIGN KEY (PET_ID) REFERENCES dogs(PET_ID)
);

COMMIT;