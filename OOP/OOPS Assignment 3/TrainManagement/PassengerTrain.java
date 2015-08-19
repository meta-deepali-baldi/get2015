package TrainManagement;

/**
 * @author Deepali
 *
 */
public class PassengerTrain extends Train{

	int seats;//seats in passenger train
	
	/**
	 * @param trainNumber :train number
	 * @param startingPoint :source station
	 * @param endPoint :destination station
	 * @param price :price of a seat 
	 * @param weight :seat available in this train
	 */
	public PassengerTrain(String trainNum, String startingPoint,
			String endPoint, double price, int seats) {
		super(trainNum, startingPoint, endPoint, price);
		this.seats = seats;
	}

	public int getSeats() {//returning seats
		return seats;
	}

	public void setSeats(int seats) {//setting seats
		this.seats = seats;
	}

	
}
