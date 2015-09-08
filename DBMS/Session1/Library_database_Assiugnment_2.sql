/*Create Database */
CREATE DATABASE Library_Database;
/*Use Database*/
USE Library_Database;

/*Create Member Table */
CREATE TABLE Members(
member_id INT PRIMARY KEY AUTO_INCREMENT,
member_name VARCHAR(20),
addressLine1 VARCHAR(20),
addressLine2 VARCHAR(20),
category CHAR);

/*Create Author Table */
CREATE TABLE Authors(
author_id INT PRIMARY KEY AUTO_INCREMENT,
author_name VARCHAR(20));

/*Create Publisher Table */
CREATE TABLE Publishers(
publisher_id INT PRIMARY KEY AUTO_INCREMENT,
publisher_name VARCHAR(20));

/*Create Subject Table */
CREATE TABLE Subjects(
subject_id INT PRIMARY KEY AUTO_INCREMENT,
subject_name VARCHAR(20));

/*Create Title table */
CREATE TABLE Titles(
title_id INT PRIMARY KEY AUTO_INCREMENT,
title_name VARCHAR(20),
subject_id INT,
publisher_id INT,
FOREIGN KEY(subject_id) REFERENCES subjects(subject_id),
CONSTRAINT publisher_id_first
FOREIGN KEY(publisher_id)REFERENCES publishers(publisher_id)
ON DELETE CASCADE
);

/*Create Title_author Table */
CREATE TABLE Title_author(
title_id INT,
author_id INT,
PRIMARY KEY(title_id,author_id),
FOREIGN KEY(title_id) REFERENCES titles(title_id),
FOREIGN KEY(author_id) REFERENCES authors(author_id));

/*Create Books Table */
CREATE TABLE Books(
accession_no INT PRIMARY KEY AUTO_INCREMENT,
title_id INT,
purchase_date DATE,
price INT,
status INT,
FOREIGN KEY(title_id) REFERENCES titles(title_id) ON DELETE CASCADE
);

/*Create Books_issue Table */
CREATE TABLE Book_issue(
issue_date DATE,
accession_no INT,
member_id INT,
due_date DATE,
PRIMARY KEY(issue_date,accession_no,member_id),
FOREIGN KEY(accession_no) REFERENCES books(accession_no),
CONSTRAINT member_id_first
FOREIGN KEY(member_id) REFERENCES members(member_id)
ON DELETE CASCADE
);

/*Create Book_return table */
CREATE TABLE Book_return(
return_date DATE,
issue_date DATE,
accession_no INT,
member_id INT,
PRIMARY KEY(return_date,accession_no,member_id),
FOREIGN KEY(accession_no) REFERENCES books(accession_no),
CONSTRAINT member_id_second
FOREIGN KEY(member_id) REFERENCES members(member_id)
ON DELETE CASCADE
);

/*Alter definitions of following LIS tables to provide the default constraints as :
issue_date and due_date
*/
ALTER TABLE Book_issue
MODIFY COLUMN issue_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP();

/*Creating Trigger for due_date*/
CREATE TRIGGER BookTrigger
BEFORE
INSERT 
ON Book_issue  
FOR EACH ROW 
SET NEW.due_date = NOW() + INTERVAL 15 day;

/*Write a command to display all the table names present in LIS.*/
SHOW CREATE TABLE Book_issue;

/*Write a command to remove Members table of the LIS database.*/
ALTER TABLE Book_issue
DROP FOREIGN KEY member_id_first;

ALTER TABLE Book_return
DROP FOREIGN KEY member_id_second;

DROP TABLE Members;

/*Create the members table again.*/
CREATE TABLE Members(
member_id INT PRIMARY KEY AUTO_INCREMENT,
member_name VARCHAR(20),
addressLine1 VARCHAR(20),
addressLine2 VARCHAR(20),
category CHAR);

ALTER TABLE Book_issue
ADD CONSTRAINT member_id_first
FOREIGN KEY (member_id)
REFERENCES Members(member_id);

ALTER TABLE Book_return
ADD CONSTRAINT member_id_second
FOREIGN KEY (member_id)
REFERENCES Members(member_id);



