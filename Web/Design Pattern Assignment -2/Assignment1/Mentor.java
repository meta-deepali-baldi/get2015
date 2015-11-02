package Assignment1;

/**
 * @author Deepali
 *
 */
public class Mentor extends Approver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see Assignment1.Approver#ProcessRequest(int)
	 */
	@Override
	public void ProcessRequest(int noOfDays) {
		if (noOfDays == 1) {//if leave equal to 1 then approved
			System.out.println("1 Day Leave Granted by mentor");
		} else if (successor != null) {//else passed to successor
			successor.ProcessRequest(noOfDays);
		}

	}

}
