package PrinterRequestManagement;

/**
 *   @author Deepali
 *
 */
public class GraduateStudent extends Jobs {
	private String course;
	private String batch;
	private String aggregatePercentage;
	private String address;
	private String employed;
	private String contactNumber;
	
	
	/**
	 * @param priority :priority of student
	 * @param name :name of student
	 * @param course :course of student
	 * @param batch :batch of student
	 * @param percentage :percentage of student
	 * @param address :address of student
	 * @param employed :employed or not
	 * @param contactNumber :contact number of student
	 */
	public GraduateStudent(int priority, String name, String course,
			String batch, String percentage, String address, String employed,
			String contactNumber) {
		super(priority, name);
		this.course = course;
		this.batch = batch;
		this.aggregatePercentage = percentage;
		this.address = address;
		this.employed = employed;
		this.contactNumber = contactNumber;
	}
	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}
	/**
	 * @return the batch
	 */
	public String getBatch() {
		return batch;
	}
	/**
	 * @param batch the batch to set
	 */
	public void setBatch(String batch) {
		this.batch = batch;
	}
	/**
	 * @return the percentage
	 */
	public String getPercentage() {
		return aggregatePercentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(String percentage) {
		this.aggregatePercentage = percentage;
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
	 * @return the employed
	 */
	public String getEmployed() {
		return employed;
	}
	/**
	 * @param employed the employed to set
	 */
	public void setEmployed(String employed) {
		this.employed = employed;
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
	
	
}
