package PrinterRequestManagement;

/**
 *  @author Deepali
 *
 */
public class UndergraduateStudent extends Jobs {
	private String course;
	private String batch;
	private String aggregatePercentage;
	private String address;
	private String contactNumber;
	/**
	 * @param priority :priority of student
	 * @param name :name of student
	 * @param course :course of student
	 * @param batch :batch of student
	 * @param percentage :percentage of student
	 * @param address :address of student
	 * @param contactNumber :contact number of student
	 */
	public UndergraduateStudent(int priority, String name, String course,
			String batch, String aggregatePercentage, String address,
			String contactNumber) {
		super(priority, name);
		this.course = course;
		this.batch = batch;
		this.aggregatePercentage = aggregatePercentage;
		this.address = address;
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
	 * @return the aggregatePercentage
	 */
	public String getAggregatePercentage() {
		return aggregatePercentage;
	}
	/**
	 * @param aggregatePercentage the aggregatePercentage to set
	 */
	public void setAggregatePercentage(String aggregatePercentage) {
		this.aggregatePercentage = aggregatePercentage;
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
	
	
}
