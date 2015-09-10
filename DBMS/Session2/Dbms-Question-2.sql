-- Assignment 2
-- Query to  display results in ascending order of issue date and within issue date in ascending order of members name.

use library_database;

SELECT 
    f.issue_date,
    f.member_id,
    f.accession_no,
    IF(e.status = 0, return_date, ' ') as Book_Returned
from
    Books e,
    Book_return f,
    Members m
WHERE
    ((e.accession_no = f.accession_no) AND (f.member_id = m.member_id))
ORDER BY issue_date asc ,member_name asc;

