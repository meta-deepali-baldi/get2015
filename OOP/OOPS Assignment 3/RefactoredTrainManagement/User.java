package RefactoredTrainManagement;

//program to store user deatils

/**
 * @author Deepali
 *
 */
public class User {
	String username; //username of user
	String toPlace; //destination
	String fromPlace; //source
	int seats; //no of seats required
	double price; //price for ticket

	/**
	 * @param username :username of user
	 * @param toPlace:destination
	 * @param fromPlace:source
	 * @param seats:no of seats required
	 * @param price:price for ticket
	 */
	public User(String username, String toPlace, String fromPlace, int seats,
			double price) {
		super();
		this.username = username;
		this.toPlace = toPlace;
		this.fromPlace = fromPlace;
		this.seats = seats;
		this.price = price;
	}

	public String getUsername() {//returning username
		return username;
	}

	public void setUsername(String username) {//setting username
		this.username = username;
	}

	public String getToPlace() {//returning destination
		return toPlace;
	}

	public void setToPlace(String toPlace) {//setting destination
		this.toPlace = toPlace;
	}
//returning source
	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {//setting sorce
		this.fromPlace = fromPlace;
	}

	public int getSeats() {//returning seats
		return seats;
	}

	public void setSeats(int seats) {//setting seats
		this.seats = seats;
	}

	public double getPrice() {//returning price
		return price;
	}

	public void setPrice(double price) {//setting price
		this.price = price;
	}
}
