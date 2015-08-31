package PrinterRequestManagement;

/**
 *  @author Deepali
 *
 */
public class Professor extends Jobs {
	private String specification; 
	private String address;
	private String contactNumber;
	private String department;
	private double salary;

	
	/**
	 * @param priority :priority of professor
	 * @param name :name of professor
	 * @param specification :specification of professor
	 * @param address :address of professor
	 * @param contactNumber :contact number of professor
	 * @param department :department of professor
	 * @param salary :salary of professor
	 */
	public Professor(int priority, String name, String specification,
			String address, String contactNumber, String department,
			double salary) {
		super(priority, name);
		this.specification = specification;
		this.address = address;
		this.contactNumber = contactNumber;
		this.department = department;
		this.salary = salary;
	}
	/**
	 * @return the specification
	 */
	public String getSpecification() {
		return specification;
	}
	/**
	 * @param specification the specification to set
	 */
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}
	/**
	 * @param contactNumber the contactNumber to set
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
