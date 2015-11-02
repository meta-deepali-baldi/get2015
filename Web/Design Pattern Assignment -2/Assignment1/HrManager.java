package Assignment1;

/**
 * @author Deepali
 *
 */
public class HrManager extends Approver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see Assignment1.Approver#ProcessRequest(int)
	 */
	@Override
	public void ProcessRequest(int noOfDays) {
		if (noOfDays <= 5) {//if leave is of less than and equal to 5 days then approved
			System.out.println(" Leave Granted by  Hr manager ");
		} else {//else require valid reasons
			System.out.println("Valid reasons should be provided");
		}

	}

}