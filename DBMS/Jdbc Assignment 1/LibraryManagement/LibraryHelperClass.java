package LibraryManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Deepali
 *
 */
public class LibraryHelperClass {
	private Connection connection;//Connection reference
	private ResultSet resultSet; //result set reference
	private Statement statement; //statement reference
	private Scanner sc = new Scanner(System.in);

	/**
	 * Constructor
	 */
	public LibraryHelperClass() {
		connection = null;
		resultSet = null;
		statement = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		connection = conUtil.getConnection();
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection: the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**To display books Title published by given author
	 * @return :List of Books
	 */
	public List<Title> getBooksDataRelatedToAuthor() {
		System.out.println("Enter Name of Author");
		//Query to get books title related to this Author
		String query = "SELECT t.title_id,t.title_name,t.subject_id,t.publisher_id FROM "
				+ "authors a inner join title_author ta ON a.author_id = ta.author_id "
				+ "inner join titles t where (t.title_id=ta.title_id AND a.author_name='"
				+ sc.nextLine() + "')";
		List<Title> titleList = new ArrayList<Title>();

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query); //query executed
			while (resultSet.next()) {
				Title title = new Title(resultSet.getInt(1),
						resultSet.getString(2), resultSet.getInt(3),
						resultSet.getInt(4));
				titleList.add(title);//adding title to list
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return titleList;
	}
	
	/**Function to get a new member 
	 * @return Member object
	 */
	private Member insertNewMember() {
		Member member = new Member(); 
		Utility utility = new Utility();
		//Getting details of new member
		System.out.println("Enter New Member Name");
		member.setMemberName(sc.nextLine());
		System.out.println("Enter Address Line1 of Member");
		member.setAddressLineFirst(sc.nextLine());
		System.out.println("Enter Address Line2 of Member");
		member.setAddressLineSecond(sc.nextLine());
		System.out.println("Enter Category of Member");
		member.setCategory(utility.checkingCategory());
		System.out.println("Enter Person type of Member");
		member.setPersonType("" + utility.checkingPersonType());
		return member;
	}

	/**Add a new member and issue the given book
	 * @return :true if book issued and false if not issued or book not exist
	 */
	public boolean addNewMemberAndIssueBook() {
		Member member = insertNewMember(); 
		Book book = null;
		boolean flag = false;
		String query;
		//Query to add member
		query = "INSERT INTO Members (member_name,addressLine1,addressLine2,category,person_type)"
				+ "VALUES( '"
				+ member.getMemberName()
				+ "','"
				+ member.getAddressLineFirst()
				+ "','"
				+ member.getAddressLineSecond()
				+ "','"
				+ member.getCategory()
				+ "','" + member.getPersonType() + "')";
		try {
			statement = connection.createStatement();
			int i = statement.executeUpdate(query);//Member insertion 
			if (i == 1) {
				System.out.println("Member inserted");
				//To get id of this member
				query = "Select max(member_id) from members where member_name='"
						+ member.getMemberName() + "'";
				resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					member.setMemberId(resultSet.getInt(1));
				}
				//Taking book which user want to issue
				System.out.println("Enter Name of Book for issue");
				String bookName = sc.nextLine();
				//Getting book details
				String query1 = "SELECT t.title_id,b.accession_no,b.purchase_date,b.price,b.status from Titles t inner join books b where (t.title_id=b.title_id AND t.title_name='"
						+ bookName + "')";

				resultSet = statement.executeQuery(query1);
				if (resultSet.next()) {
					book = new Book(resultSet.getInt(2), resultSet.getInt(1),
							resultSet.getString(3), resultSet.getDouble(4),
							resultSet.getInt(5));
				} else {//if no such book is available
					return false;
				}

				if (book.getStatus() == 0) { //if book is not issued by anyone then can issue
					query = "INSERT INTO Book_issue (accession_no,member_id)"
							+ "VALUES(" + book.getAccessionNo() + ","
							+ member.getMemberId() + ")";
					i = statement.executeUpdate(query);
					if (i == 1) {//book issued
						System.out.println("Member inserted into book issue");
						query = "Update books Set status=1 where accession_no="
								+ book.getAccessionNo();
						i = statement.executeUpdate(query);
						if (i == 1) { //book table updated
							System.out.println("Book Updated");
							flag = true;
							return flag;
						}
					} else {
						System.out.println("Member not inserted in book issue");
						return flag;
					}
				} else { //book is already issued by someone
					System.out.println("Book cannot be issued");
					return flag;
				}
			} else {
				System.out.println("Member not inserted");
				return flag;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

	/**Delete all those books which were not issued in last 1 year
	 * @return :Number of books deleted
	 */
	public int getNumberOfBooksNotUseful() {
		PreparedStatement preparedStatement = null;
		int noOfBooks = 0;
		//query to get books not issued
		String query = "select distinct b.accession_no from book_issue bi right join books b on b.accession_no=bi.accession_no "
				+ "AND bi.Issue_date=(Select max(Issue_date) from book_issue bi1  "
				+ "where bi1.accession_no=bi.accession_no group by (bi1.accession_no)) "
				+ "Where((DATEDIFF( NOW(), bi.Issue_date)>=365) or bi.issue_date is null)";
		// query to delete this books
		String query1 = "Delete from books where accession_no=?";
		String query2 = "Delete from book_issue where accession_no=?";
		String query3 = "Delete from book_return where accession_no=?";
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				preparedStatement = connection.prepareStatement(query2);
				preparedStatement.setInt(1, resultSet.getInt(1));
				preparedStatement.executeUpdate();
				preparedStatement = connection.prepareStatement(query3);
				preparedStatement.setInt(1, resultSet.getInt(1));
				preparedStatement.executeUpdate();
				preparedStatement = connection.prepareStatement(query1);
				preparedStatement.setInt(1, resultSet.getInt(1));

				noOfBooks = noOfBooks + preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return noOfBooks;

	}
}
