package TrainManagementByMenu;

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
	 * @param duration :time train will take
	 */
	public GoodsTrain(int trainNumber, String startingPoint,
			String endPoint, double price, double duration, double weight) {
		super(trainNumber, startingPoint, endPoint, price, duration);
		this.weight = weight;
	}


	public double getWeight() {//returning weight
		return weight;
	}

	
	public void setWeight(double weight) {//setting weight
		this.weight = weight;
	}
	
}
