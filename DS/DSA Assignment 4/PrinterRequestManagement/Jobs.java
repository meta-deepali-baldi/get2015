package PrinterRequestManagement;

/**
 *  @author Deepali
 * 
 */
public class Jobs {
	private int priority; //priority of each job
	private String name; //name of job
	/**
	 * @param priority :priority of job
	 * @param name :name of job
	 */
	public Jobs(int priority, String name) {
		this.priority = priority;
		this.name = name;
	}
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
