package Assignment1;

/**
 * @author Deepali
 *
 */
public class SeniorMentor extends Approver {

	/*
	 * (non-Javadoc)
	 * 
	 * @see Assignment1.Approver#ProcessRequest(int)
	 */
	@Override
	public void ProcessRequest(int noOfDays) {
		if (noOfDays <= 2) {//if leave less than and equal to 2 then approved
			System.out.println(" Leave Granted by  Senior mentor");
		} else if (successor != null) {//else passed to successor for approval
			successor.ProcessRequest(noOfDays);
		}

	}

}