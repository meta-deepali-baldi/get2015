/**
 *Console based Survey Application.
 
Modeling of Operations.
 
Read 5-7 Questions (Single Select, Multiple Select, Text), available options from text file.
Ask Participant to fill the survey. Survey will have number of questions.
Participant will answer question one by one.
Single, Multiple choice question will have validation to choose answer from available options only.
All questions are mandatory to answer.
 
Output Reports:
System should be able to generate report that will display percentage distribution of participants’ choice for single select question only. [refer example output A.], .
System should be able to print all the questions and respective answer given by Participants [refer example output B.].
 
Example Data File:
Q1. Overall Rating, Single Select, (1/2/3/4/5)
Q2. Area of improvement, Multi Select, (Service Quality/ Communication/ Delivery Process)
Q3. Feedback, Text
 

Example Output Report:
 
Overall Rating, Single Select, (1/2/3/4/5)
1 - 20%
	2 - 0%
	3 - 50%
	4 - 20%
	5 - 10%
                  
Participant 1:
Q1. Overall Rating, Single Select, (1/2/3/4/5)
4
 
Q2. Area of improvement, Multi Select, (Service Quality/ Communication/ Delivery Process)
Service Quality/ Delivery Process
 
Q3. Feedback, Text
Reported issue was not resolved.
 
 
Participant 2:
Q1. Overall Rating, Single Select, (1/2/3/4/5)
3
 
Q2. Area of improvement, Multi Select, (Service Quality/ Communication/ Delivery Process)
Communication
 
Q3. Feedback, Text
Appreciating Mechanic’s skills.
 
 *
 */
package SurveyManagement;

import java.util.*;

/**
 * @author Deepali
 *
 */
public class SurveyMainManagement {
	
	
	public static void main(String[] args) {
		char choice;
		int count;
		Scanner scanner1=new Scanner(System.in);
		Survey survey=new Survey();
		//Questions
		try {
			survey.readData("./src/SurveyManagement/Questions.txt");
		
		
		do{
			System.out.println("Press 1 for taking survey");
			System.out.println("Press 2 for statistics");
			System.out.println("Press 3 for Viewing Participants Answers");
			count=scanner1.nextInt(); //Taking option
			switch(count) {
			case 1:		survey.takeSurvey();	//for taking survey
				break;
			case 2:    System.out.println("Statistics of Survey");
				survey.statistics();	//Calculate statistics 
				survey.displayStatistics(); //to display Statistics
				break;
			case 3:		System.out.println("Participants answer");
				survey.displayParticipant(); //to display participant answers
			}
			System.out.println("Do you want to continue(Y/N)");	// continuing the procedure
			choice = scanner1.next().toUpperCase().charAt(0);

		} while (choice=='Y');
		scanner1.close();
		} catch (Exception e) {
			System.out.println("TYPE CORRECT OPTION");
		}
	}
	
}
