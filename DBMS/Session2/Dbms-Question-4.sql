-- Creating Database zipcodeDatabase
CREATE DATABASE zipCodeDatabase;
USE zipCodeDatabase;

-- creating table ZipCodeTable
CREATE TABLE zipCodeTable(
    zipCode int PRIMARY KEY AUTO_INCREMENT
);

-- Creating table cityInformation
CREATE TABLE cityInformation(
    zipCode int PRIMARY KEY AUTO_INCREMENT,
    cityName varchar(20),
    FOREIGN KEY (zipCode)
        REFERENCES zipCodeTable (zipCode)
);

-- Creating table stateInformation
CREATE TABLE stateInformation(
    zipCode int PRIMARY KEY AUTO_INCREMENT,
    stateName varchar(20),
    FOREIGN KEY (zipCode)
        REFERENCES zipCodeTable (zipCode)
);
 
 -- Inserting values in zipCodeTable table
INSERT INTO zipCodeTable(zipCode) VALUES (800001);
INSERT INTO zipCodeTable(zipCode) VALUES (800002);
INSERT INTO zipCodeTable(zipCode) VALUES (800003);
 
 -- Inserting values in cityInformation table
INSERT INTO cityInformation(zipCode,cityName) VALUES (800001,'Bhopal');
INSERT INTO cityInformation(cityName) VALUES ('Jaipur');
INSERT INTO cityInformation(cityName) VALUES ('Mumbai');
 
 -- Inserting values in stateInformation table
INSERT INTO stateInformation(zipCode,stateName) VALUES (800001,'Madhya Pradesh');
INSERT INTO stateInformation(stateName) VALUES ('Rajasthan');
INSERT INTO stateInformation(stateName) VALUES ('Maharashtra');
 
 
 -- Query to find the zip code city Name and state Name
SELECT 
    z.zipCode, cityName, stateName
from
    zipCodeTable z,
    cityInformation c,
    stateInformation s
where
    ((z.zipCode = c.zipCode) && (z.zipCode = s.zipCode))
ORDER BY stateName asc ,cityName asc;