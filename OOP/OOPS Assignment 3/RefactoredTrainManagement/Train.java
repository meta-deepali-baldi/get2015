
package RefactoredTrainManagement;

/**
 * @author Deepali
 *
 */

public class Train {
	int trainNumber;//train Number
	String startingPoint;//source
	String endPoint;//destination
	double price; //price for a seat
	double duration;//duration of train
	
	enum trainType{//type of train
		passengerTrain,goodsTrain
	};
	
	/**
	 * @param trainNumber: train Number
	 * @param startingPoint :source
	 * @param endPoint :destination
	 * @param price: price for a seat
	 * @param duration :time train will take
	 */
	public Train(int trainNumber, String startingPoint, String endPoint,
			double price, double duration) {
		super();
		this.trainNumber = trainNumber;
		this.startingPoint = startingPoint;
		this.endPoint = endPoint;
		this.price = price;
		this.duration = duration;
	}
	

	/**
	 * @return the trainNumber
	 */
	public int getTrainNumber() {
		return trainNumber;
	}


	/**
	 * @param trainNumber the trainNumber to set
	 */
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}


	/**
	 * @return source
	 */
	public String getStartingPoint() {
		return startingPoint;
	}
	public void setStartingPoint(String startingPoint) {//setting source
		this.startingPoint = startingPoint;
	}
	
	/**
	 * @return destination
	 */
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {//setting destination
		this.endPoint = endPoint;
	}
	/**
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {//setting price
		this.price = price;
	}

	/**
	 * @return the duration
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	
}
