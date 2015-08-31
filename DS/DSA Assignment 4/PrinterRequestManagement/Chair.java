package PrinterRequestManagement;

/**
 *  @author Deepali
 *
 */
public class Chair extends Jobs {
	private String color; //color of chair
	private String companyName; //company name of chair
	private String price; //price of chair
	private String adjustableChair; //if adjustable or not
	private double height; //height of chair
	/**
	 * @param priority :priority of chair
	 * @param name :name of chair
	 * @param color :color of chair
	 * @param companyName :company name of chair
	 * @param price :price of chair
	 * @param adjustableChair :if adjustable or not
	 * @param height :height of chair
	 */
	public Chair(int priority, String name, String color, String companyName,
			String price, String adjustableChair, double height) {
		super(priority, name);
		this.color = color;
		this.companyName = companyName;
		this.price = price;
		this.adjustableChair = adjustableChair;
		this.height = height;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the adjustableChair
	 */
	public String getAdjustableChair() {
		return adjustableChair;
	}
	/**
	 * @param adjustableChair the adjustableChair to set
	 */
	public void setAdjustableChair(String adjustableChair) {
		this.adjustableChair = adjustableChair;
	}
	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
}
