-- creating database electroniclist
CREATE  DATABASE eCommerceApplication;

USE eCommerceApplication;

-- Creating table categories 
CREATE TABLE Category(
    id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    parentId INTEGER NULL,
    FOREIGN KEY (parentId)
        REFERENCES Category (id)
);

-- Inserting the Top category
INSERT INTO Category(id,name) VALUES (1,'Mobiles & Tablets');
INSERT INTO Category(name) VALUES ('Computers');
INSERT INTO Category(name) VALUES ('Home Appliances');

-- Inserting the sub category
INSERT INTO Category(name,parentId) VALUES('MOBILES',1);
INSERT INTO Category(name,parentId) VALUES('TABLETS',1);
INSERT INTO Category(name,parentId) VALUES('Smart Phones',4);
INSERT INTO Category(name,parentId) VALUES('Featured Phones',4);

-- Inserting the sub category
INSERT INTO Category(name,parentId) VALUES('2G',5);
INSERT INTO Category(name,parentId) VALUES('3G',5);
INSERT INTO Category(name,parentId) VALUES('ACCESSORIES',1);
INSERT INTO Category(name,parentId) VALUES('CASE & COVERS',1);

-- Inserting the sub category
INSERT INTO Category(name,parentId) VALUES('DESKTOP',2);
INSERT INTO Category(name,parentId) VALUES('LAPTOP',2);
INSERT INTO Category(name,parentId) VALUES('LAPTOP ACCESSORIES',2);
INSERT INTO Category(name,parentId) VALUES('PRINTERS',2);

-- Inserting the sub category
INSERT INTO Category(name,parentId) VALUES('Keyboard',14);
INSERT INTO Category(name,parentId) VALUES('Mouse',14);
INSERT INTO Category(name,parentId) VALUES('Headphones',14);
INSERT INTO Category(name,parentId) VALUES('Inkjet',15);
INSERT INTO Category(name,parentId) VALUES('Laser',15);
INSERT INTO Category(name,parentId) VALUES('TVs',3);
INSERT INTO Category(name,parentId) VALUES('Air Conditioners',3);
INSERT INTO Category(name,parentId) VALUES('Washing Machines',3);

-- Inserting the sub category
INSERT INTO Category(name,parentId) VALUES('LED',21);
INSERT INTO Category(name,parentId) VALUES('LCD',21);
INSERT INTO Category(name,parentId) VALUES('PLASMA',21);

-- Inserting the sub category
INSERT INTO Category(name,parentId) VALUES('Full Automatic',23);
INSERT INTO Category(name,parentId) VALUES('Semi Automatic',23);
INSERT INTO Category(name,parentId) VALUES('Top Load',27);
INSERT INTO Category(name,parentId) VALUES('Front Load',27);


-- Query to display all the categories along with its Parent category.
-- Result is  sorted on Parent Category.
-- Implementing self join and left outer join
select 
    child.name as category_name,
    IFNULL(parent1.name, 'Top Category') as parent1_name,
    parent2.name as parent2_name,
    parent3.name as parent3_name
from
    Category as child
        left outer join
    Category as parent1 ON parent1.id = child.parentId
        left outer join
    Category as parent2 ON parent2.id = parent1.parentId
        left outer join
    Category as parent3 ON parent3.id = parent2.parentId;
    
    
-- To select categories if it is top category
SELECT 
    name
FROM
    Category
where
    parentId is null ;
