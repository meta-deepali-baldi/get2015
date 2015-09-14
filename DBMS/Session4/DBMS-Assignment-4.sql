use library_database;

/* Assignment 1: */
/* 1. Write a SELECT command to display name of those members
who belong to the category as to which member
“pragati” belongs.
Note: Solve the problem using subquery. */

Select 
    member_name
from
    members
where
    person_type in (Select 
        person_type
    from
        members
    where
        member_name = 'pragati');

/*2. Write a SELECT command to display information on the books
that have not been returned till date. The information should
include book issue date, title, member name and due date.
Note: Use Correlated Subquery. */

/*Insertion in Book_issue Table */
INSERT INTO Book_issue (accession_no,member_id)
VALUES((SELECT accession_no FROM books where title_id=ALL(SELECT title_id FROM Titles where title_name='DBMS')),
(SELECT member_id FROM Members where member_name='arushi'));


SELECT 
    bi.issue_date, bi.due_date, m.member_name, t.title_name
from
    book_issue bi
        inner join
    books b ON bi.accession_no = b.accession_no 
        inner join
    titles t ON b.title_id = t.title_id
        inner join
    members m ON bi.member_id = m.member_id
where
    bi.accession_no = (SELECT 
        bi1.accession_no
    from
        book_issue bi1
    where
        bi1.accession_no = bi.accession_no AND bi1.accession_no NOT IN (SELECT 
            br.accession_no
        from
            book_return br));
            

/* 3. Write a SELECT command to display information on the books
that have been returned after their due dates. The information
should include book issue date, title, member name and due
date.
Note: Use Correlated Subquery.*/
SELECT 
    bi.issue_date, t.title_name, m.member_name, bi.due_date
FROM
    book_issue bi
        INNER JOIN
    books b ON b.accession_no = bi.accession_no
        INNER JOIN
    titles t ON t.title_id = b.title_id
        INNER JOIN
    members m ON m.member_id = bi.member_id
WHERE
    EXISTS( SELECT 
        br.member_id, br.issue_date, br.accession_no
    FROM
        book_return br
    WHERE
        br.issue_date = DATE(bi.issue_date) AND br.member_id = bi.member_id AND br.accession_no = bi.accession_no AND br.return_date > bi.due_date);

/* 4. Write a SELECT command to display information of those books
whose price is equal to the most expensive book purchase so far.*/
SELECT 
    title_name
FROM
    titles t,
    books b1
WHERE
    t.title_id = b1.title_id && b1.price = (SELECT 
        MAX(b.price)
    FROM
        books b);
        
/*5. Write a SELECT command to display the second maximum price
of a book. */
SELECT 
    price
FROM
    books
WHERE
    price = (SELECT 
        MAX(price)
    FROM
        books
    WHERE
        price < (SELECT 
            MAX(price)
        FROM
            books));
        
/* Assignment 2: */

/*
1. Create a View which can be used to display member name and
all issue details of the member using a simple SELECT command.
*/        
CREATE VIEW member_issue
AS
SELECT m.member_name, bi.member_id, bi.issue_date, bi.accession_no, bi.due_date
FROM  book_issue bi inner join members m
WHERE m.member_id=bi.member_id;


SELECT 
    *
FROM
    member_issue;

/* 2. Create a View which contains three columns, member name,
member id and full description of category, i.e., Faculty, Students
and Others instead of F,S and O.*/
CREATE VIEW member_description
AS
SELECT member_name, member_id, IF (person_type='P','Faculty',(IF(person_type='S','Student','Other'))) AS full_description
FROM  members;

SELECT 
    *
FROM
    member_description;

/*Create a View which contains the information – subject name,
title, member name, category, issue date, due date and return
date. If the books have not been returned, NULL should be
displayed instead of return date. */
CREATE VIEW book_return_details
AS
SELECT s.subject_name,t.title_name,m.member_name,m.person_type,bi.issue_date,bi.due_date,IF(b.status = 0, br.return_date, 'NULL') as Book_Returned
FROM  Subjects s inner join titles t ON s.subject_id=t.subject_id 
inner join books b ON t.title_id=b.title_id 
inner join book_issue bi ON bi.accession_no=b.accession_no 
inner join book_return br ON (br.accession_no=b.accession_no AND br.issue_date=DATE(bi.issue_date)) 
inner join members m ON m.member_id=br.member_id;


SELECT 
    *
FROM
    book_return_details;
