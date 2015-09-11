use library_database;

-- Assignment-1

/*  Question 1 : display information on books issued for more than two months
    The Information should include member_Name, member_Id, title_Name, accession_No, issue_Date,
    due_Date, and Issued for how many months and be sorted on member_Name, and within member_Name on title_Name
*/

INSERT INTO book_issue (accession_no,member_id)
VALUES((SELECT accession_no FROM books where title_id=ALL(SELECT title_id FROM titles where title_name='PAPER TOWN')),
(SELECT member_id FROM members where member_name='sumitra'));

INSERT INTO book_issue (accession_no,member_id)
VALUES((SELECT accession_no FROM books where title_id=ALL(SELECT title_id FROM titles where title_name='PAPER TOWN')),
(SELECT member_id FROM members where member_name='deepali'));
 

INSERT INTO book_return(return_date,issue_date,accession_no,member_id)
VALUES((SELECT due_date from book_issue where member_id =1),
(SELECT issue_date from book_issue where member_id=1),
(SELECT accession_no FROM book_issue where member_id=1),1);

INSERT INTO book_return(return_date,issue_date,accession_no,member_id)
VALUES("2015-11-23",
(SELECT issue_date from book_issue where member_id=3),
(SELECT accession_no FROM book_issue where member_id=3),3);

INSERT INTO book_return(return_date,issue_date,accession_no,member_id)
VALUES("2015-11-24",
(SELECT issue_date from book_issue where member_id=4),
(SELECT accession_no FROM book_issue where member_id=4),4);

SELECT 
    m.member_name,
    m.member_id,
    t.title_name,
    b.accession_no,
    bi.issue_date,
    bi.due_date,
    TIMESTAMPDIFF(MONTH,
        br.issue_date,
        br.return_date) AS months_duration
FROM
    members m,
    titles t,
    books b,
    book_return br,
    book_issue bi
where
    m.member_id = bi.member_id && bi.accession_no = b.accession_no && b.title_id = t.title_id && m.member_id = br.member_id && b.status = 0;



/*   Question 2 : display those rows from members table having maximum length for member_Name
    Information should contain member_Name and length of member_Name 
*/

SELECT 
    member_name, CHAR_LENGTH(member_name) AS Length
FROM
    members
WHERE
    CHAR_LENGTH(member_name) = (SELECT 
        max(CHAR_LENGTH(member_name))
    FROM
        members);
  
  
/*  Question 3 : display count of numebr of books issued so far.*/

SELECT 
    COUNT(DISTINCT accession_no)
from
    book_issue;

        

-- Assignment-2


/*  Question 1 : display subject_wise information on numebr of books purchased.
    The information should include subject_Name, subject_id, number of books purchased.
*/
Update titles Set subject_id=1 where title_id=1;
Update titles Set subject_id=3 where title_id=3;
Update titles Set subject_id=4 where title_id=4;


SELECT 
    s.subject_id,
    s.subject_name,
    COUNT(s.subject_id) AS TOTAL_BOOKS
from
    books b
        inner join
    titles t
        inner join
    subjects s
where
    ((b.title_id = t.title_id) AND (t.subject_id = s.subject_id))
group by s.subject_id ;


/*  Question 2 : display those rows from the book_issue table where a book can be returned after two months.
    That is the difference in due_date and issue_Date is greater than two months
*/

Update book_issue Set due_date='2015-11-30' where member_id=1;

Select 
    *
from
    book_issue bi
where
    (DATEDIFF(bi.due_date, bi.issue_date)/30) > 2;


/*  Question 3 : select the list of books having price greater than the minimum price of books purchased so far
*/
SELECT 
    title_name
FROM
    titles t,
    books b1
WHERE
    t.title_id = b1.title_id && b1.price > (SELECT 
        MIN(b.price)
    FROM
        books b);
      

-- Assignment-3


/*  Question 1 : Query to display total number of students, total number of faculty
    and total number of others in library information system in a single row.
*/

ALTER TABLE members ADD person_type char;

Update Members Set person_type='S' where member_id=1;
Update Members Set person_type='O' where member_id=2;
Update Members Set person_type='P' where member_id=3;
Update Members Set person_type='S' where member_id=4;
Update Members Set person_type='P' where member_id=5;
        
SELECT 
    COUNT(if(person_type = 'P', person_type, null)) AS NO_OF_PROFESSORS,
    COUNT(if(person_type = 'S', person_type, null)) AS NO_OF_STUDENTS,
    COUNT(if(person_type = 'O', person_type, null)) AS NO_OF_OTHERS
from
    members;


/*  Question 2: Query to display the information of those titles that have been issued more than 2 times
*/

SELECT 
    t.title_id, t.title_name, t.subject_id, t.publisher_id
FROM
    titles t,
    books b,
    book_issue bi
where
    (bi.accession_no = b.accession_no AND b.title_id = t.title_id)
group by bi.accession_no
HAVING (count(bi.accession_no) >= 2);

/*  Question 3: Query to display information on books issued to members of category other than "P"
*/

SELECT 
    b.accession_no as accession_no,
    b.title_id as title_id,
    b.purchase_date as purchase_date,
    b.price as price
from
    books b,
    members m,
    book_issue bi
where
    bi.member_id = m.member_id AND m.person_type != 'P' AND bi.accession_no = b.accession_no AND b.status = 1;


/*  Question 4: Query to display information on those authors for which
    at least one book has been purchased
*/

SELECT 
    b.accession_no as accession_no,
    a.author_name as author_name,
    t.title_name as title_name
from
    books b,
    title_author ta,
    authors a,
    titles t
where
    a.author_id = ta.author_id and ta.title_id = b.title_id and b.title_id = t.title_id;
