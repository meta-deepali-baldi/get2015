/**
 * Assignment 2: Create a program for leave approval includes mentor,Senior mentor and HR manager.
 *  The Mentor ,senior mentor and HR manager can approve 1,2,5 days leaves respectively.(Chain of Responsibility)

 */
package Assignment1;

import Assignment2.Utility;

/**
 * @author Deepali
 *
 */
public class ChainOfResponsiblity {

	public static void main(String[] args) 
	{
		char mainChoice = 0;
		Approver mentor = new Mentor();//set approver
		Approver seniorMentor = new SeniorMentor();
		Approver hrManager = new HrManager();

		mentor.SetSuccessor(seniorMentor);//set successor of approver
		seniorMentor.SetSuccessor(hrManager);//set successor of approver
		do{
			
		System.out.println("Enter number of days for Leave");
		int leave = Utility.checkingInteger();

		mentor.ProcessRequest(leave);
		
		mainChoice=Utility.checkingString();
		}while(mainChoice=='Y');
		}

}
