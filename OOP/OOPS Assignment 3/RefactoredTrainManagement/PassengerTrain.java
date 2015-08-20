package RefactoredTrainManagement;

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
	 * @param duration :time train will take
	 */
	public PassengerTrain(int trainNumber, String startingPoint,
			String endPoint, double price, double duration, int seats) {
		super(trainNumber, startingPoint, endPoint, price, duration);
		this.seats = seats;
	}

	public int getSeats() {//returning seats
		return seats;
	}

	

	public void setSeats(int seats) {//setting seats
		this.seats = seats;
	}

	
}
