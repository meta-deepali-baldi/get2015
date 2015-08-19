/**
 * 
 */
package TrainManagement;

/**
 * @author Deepali
 *
 */
/**
 * @author Deepali
 *
 */
public class Train {
	String trainNumber;//train Number
	String startingPoint;//source
	String endPoint;//destination
	double price; //price for a seat
	
	enum trainType{//type of train
		passengerTrain,goodsTrain
	};
	
	/**
	 * @param trainNumber: train Number
	 * @param startingPoint :source
	 * @param endPoint :destination
	 * @param price: price for a seat
	 */
	public Train(String trainNumber, String startingPoint, String endPoint,
			double price) {
		this.trainNumber = trainNumber;
		this.startingPoint = startingPoint;
		this.endPoint = endPoint;
		this.price = price;
	}
	
	/**
	 * @return trainnumber
	 */
	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {//setting train number
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
	
}
