use library_database;

-- 1 Query to display the columns of table members
SELECT * FROM members;

-- 2 Query to display the member id,member name,category of table members
SELECT member_id,member_name, category FROM members;

-- 3 Query to display the member id,member name,category of table members whose category = "f"
SELECT member_id,member_name, category FROM members WHERE category = 'f';

-- 4 Query to display distinct category of table members
SELECT DISTINCT(category) FROM members;

-- 5 Query to display the member name of table members order by desc
SELECT member_name, category FROM members ORDER BY member_name DESC;

-- 6 Query to display the title name,publisher name, subject id of table
SELECT 
    title_name, p.publisher_name, s.subject_name
FROM
    Titles t,
    Publishers p,
    Subjects s
WHERE
    ((t.publisher_id = p.publisher_id) AND (t.subject_id = s.subject_id));

-- 7 Query to display the count of members of category
SELECT category,COUNT(*) From members GROUP BY category;

-- 8 Query to display name of members to which pragati belongs
SELECT m1.member_name FROM members AS m1 JOIN members AS m2 ON m1.category = m2.category WHERE m2.member_name ="pragati";

-- 9 Query to display the status of return book and if returned  then place blank

SELECT 
    issue_Date,
    member_id,
    e.accession_no,
    IF(status = 0, return_date, ' ') as Book_Returned
FROM
    Books e,
    Book_return f
WHERE
    e.accession_no = f.accession_no;
