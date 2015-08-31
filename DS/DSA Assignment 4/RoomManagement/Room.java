package RoomManagement;

/**
 * @author Deepali
 *
 */
public class Room {
	private int available = 0; //room availability
	private Guest guest; //instance of guest

	/**
	 * default constructor
	 */
	public Room() {
		available = 0;
		guest = null;
	}

	/**
	 * @param guest :instance of guest
	 */
	public Room(Guest guest) {

		this.available = 1;
		this.guest = guest;
	}

	/**
	 * @return the available
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	/**
	 * @return the guest
	 */
	public Guest getGuest() {
		return guest;
	}

	/**
	 * @param guest the guest to set
	 */
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
	

}
