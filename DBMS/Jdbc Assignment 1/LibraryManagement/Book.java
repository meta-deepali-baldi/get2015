package LibraryManagement;

/**
 * @author Deepali
 *
 */
public class Book {
	private int accessionNo; //book number
	private int titleIdOfBook; //title id of book
	private String purchaseDate; //purchase date of book
	private double price; //price of book
	private int status; //status of book whether issued or not
	
	/**
	 * @param accessionNo :book number
	 * @param titleIdOfBook :title id of book
	 * @param purchaseDate :purchase date of book
	 * @param price :price of book
	 * @param status :status of book whether issued or not
	 */
	public Book(int accessionNo, int titleIdOfBook, String purchaseDate,
			double price, int status) {
		super();
		this.accessionNo = accessionNo;
		this.titleIdOfBook = titleIdOfBook;
		this.purchaseDate = purchaseDate;
		this.price = price;
		this.status = status;
	}
	/**
	 * @return the accessionNo
	 */
	public int getAccessionNo() {
		return accessionNo;
	}
	/**
	 * @param accessionNo the accessionNo to set
	 */
	public void setAccessionNo(int accessionNo) {
		this.accessionNo = accessionNo;
	}
	
	/**
	 * @return the titleIdOfBook
	 */
	public int getTitleIdOfBook() {
		return titleIdOfBook;
	}
	/**
	 * @param titleIdOfBook the titleIdOfBook to set
	 */
	public void setTitleIdOfBook(int titleIdOfBook) {
		this.titleIdOfBook = titleIdOfBook;
	}
	/**
	 * @return the purchaseDate
	 */
	public String getPurchaseDate() {
		return purchaseDate;
	}
	/**
	 * @param purchaseDate the purchaseDate to set
	 */
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
