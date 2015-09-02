package Session6;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author deepali
 *
 */
public class EmployeeOperations {
	private List<Employee> employeeList = new LinkedList<Employee>();
	private Scanner scanner = new Scanner(System.in);
	
	
	/**
	 * @return the employeeList
	 */
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	/**
	 * @param employeeList the employeeList to set
	 */
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	
	/**
	 * Insert employee within List of employee
	 */
	public void insertEmployee() {
		Utility utility=new Utility();
		int count = 0;
		int employeeId=0;
		String name;
		String address;
		System.out.println("1.Enter employee ID");
		employeeId =utility.checkingInteger(employeeId);
		System.out.println("2.Enter employee name");
		name = scanner.next();
		System.out.println("3.Enter employee address");
		address =scanner.next();
		Employee employee = new Employee(employeeId, name, address);
		if (employeeList.size() == 0) {//when no element in list
			employeeList.add(employee);
			return;
		} else { //checking if element exist in list or not
			Iterator<Employee> employeeIterator = employeeList.iterator();
			while (employeeIterator.hasNext()) {
				Employee employeeSecond = employeeIterator.next();
				if (employee.equals(employeeSecond)) {
					System.out.println("This Id already exists!!!");
					break;
				}
				count++;
			}
			if (count == employeeList.size()) {//if not exist then  add element at end of list
				employeeList.add(employee);
			}

		}
	}
	
	/**
	 * To display Employee Details
	 */
	public void displayEmployeeList(){
		Iterator<Employee> employIterator = employeeList.iterator();
		while (employIterator.hasNext()) {
			Employee employ = employIterator.next();
			System.out.println(employ);
		}
	}
}
