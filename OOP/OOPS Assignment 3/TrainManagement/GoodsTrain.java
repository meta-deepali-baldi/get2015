package TrainManagement;

/**
 * @author Deepali
 *
 */
public class GoodsTrain extends Train {
	
	double weight;// weight in goods train
	
	/**
	 * @param trainNumber :train number
	 * @param startingPoint :source station
	 * @param endPoint :destination station
	 * @param price :price of a weight 
	 * @param weight :weight available in this train
	 */
	public GoodsTrain(String trainNumber, String startingPoint, String endPoint,
			double price, double weight) {
		super(trainNumber, startingPoint, endPoint, price);
		this.weight = weight;
	}

	public double getWeight() {//returning weight
		return weight;
	}

	public void setWeight(double weight) {//setting weight
		this.weight = weight;
	}
	
}
