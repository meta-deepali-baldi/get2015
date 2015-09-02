/**
 * Create a custom class say Employee with fields as empId, name and address. Create a collection of this employee class. EmpId of the class with be unique.

- Perform sorting on this collection i.e natural order.

- Perform sorting on this collection based on the employee Name. (ascending order by Employee Name)

- Create a collection for these employees to avoid any duplicate employee entry. (Employee having same empId will consider as duplicate. If one try to add the same employe again it should avoid that.)

Note: Add at least 5 employees to the collection. Create a separate programme for the above three points.
 */
package Session6;

import java.util.Collections;
import java.util.Comparator;

/**
 * @author deepali
 *
 */
public class EmployeeNameSort implements Comparator {
	public static void main(String args[]) {

		int choice = 0;
		char mainChoice = 0;
		Utility utility=new Utility();
		EmployeeOperations operations = new EmployeeOperations();
		do {
			System.out.println("1.Enter employee details");
			System.out.println("2.Sort employee details");
			System.out.println("3.Display employee details");
			choice =utility.checkingInteger(choice);
			switch (choice) {
			case 1:
				operations.insertEmployee();
				break;
			case 2:
				Collections.sort(operations.getEmployeeList(),new EmployeeNameSort());
				break;
			case 3:
				operations.displayEmployeeList();
				break;
			default:
				System.out.println("Enter correct choice");
				break;
			}
			mainChoice = utility.checkingString(mainChoice);
		} while (mainChoice == 'Y');
	}

	/*Compare on the basis of name
	 *  (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Object arg0, Object arg1) {

		return ((Employee) arg0).getName().compareTo(
				((Employee) arg1).getName());
	}

}
