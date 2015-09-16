/**
 * Prerequisites : Library database in MySQL (done in DBMS sessions/assigments)

 ** All the queries should be at one place. Result should be wrapped in POJOs.
Helper class should be there for querying the database and wrapping the results.

Assignment 1.

Fetch all the books published by author, given the name of the author. 
Return the books data (List of Titles).

Assignment 2.

Add a new member who has issued a book, given the name of the book. Return flag to indicate whether the  the book has been issued or not.

Assignment 3.

Delete all those books which were not issued in last 1 year. Return the number of books deleted.
 */
package LibraryManagement;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Deepali
 */
public class LibraryManagement {

	public static void main(String[] args) throws SQLException {
		int choice;
		char mainChoice;

		MenuClass menuClass = new MenuClass();
		Utility utility = new Utility();
		LibraryHelperClass libraryHelperClass = new LibraryHelperClass();
		do {
			// Menu
			menuClass.menuForLibraryManagement();
			// Taking choice
			choice = utility.checkingChoice();
			switch (choice) {
			case 1:// To display books published by given author
				List<Title> titleList = libraryHelperClass
						.getBooksDataRelatedToAuthor();

				if (titleList.size() != 0) {
					System.out.println("List of Books:");
					for (Title title : titleList) {
						System.out.println(title.getTitleName());
					}
				} else {
					System.out.println("No Book Purchased of this author");
				}

				break;
			case 2:// Add a new member and issue the given book
				boolean flag = libraryHelperClass.addNewMemberAndIssueBook();
				if (flag == true) {
					System.out.println("Member inserted and book is issued");
				} else {
					System.out.println("Book Doesn't Exist ");
				}
				break;
			case 3:// Delete all those books which were not issued in last 1
					// year and display no of books deleted
				int numberOfBooks = libraryHelperClass
						.getNumberOfBooksNotUseful();

				System.out
						.println("Number of Books not issued since one year :"
								+ numberOfBooks);
				break;
			default:
				System.out.println("Enter correct choice");
			}
			mainChoice = utility.checkingString();
		} while (mainChoice == 'Y');
		libraryHelperClass.getConnection().close(); // close connection
	}
}
