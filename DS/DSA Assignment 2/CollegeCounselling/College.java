package CollegeCounselling;


/**
 * @author Deepali
 *
 */
public class College {
	private int[] allocatedSeats; //No of Seats filled in each college
	private String[] collegeList = { "MLV", "MIT", "JCERC", "ARYA", "TINJR" }; //List of college
	private static String[][] allotmentList; //Name of person stored for a seat in a college
	private int seatsFulled;//no of seats filled  in total vacancies
	
	/**
	 * Allocation of instance variaables
	 */
	public College() {
		seatsFulled=0;
		allocatedSeats = new int[5];
		allotmentList = new String[5][4];
	}

	
	

	/**
	 * @return the seatsFulled
	 */
	public int getSeatsFulled() {
		return seatsFulled;
	}




	/**
	 * @param seatsFulled the seatsFulled to set
	 */
	public void setSeatsFulled(int seatsFulled) {
		this.seatsFulled = seatsFulled;
	}




	/** checks if allocation of saet possible or not
	 * @param name :Name of student to be allocated
	 * @param choice :choice for which college
	 * @return :return 1 if allocated
	 */
	public int  allotToStudent(String name, int choice) {
		if (allocatedSeats[choice-1] < 4) {// check for seat if available or not
			allotmentList[choice-1][(allocatedSeats[choice-1])] = name;
			allocatedSeats[choice-1] = allocatedSeats[choice-1] + 1;
			System.out.println(allocatedSeats[choice-1]);
			seatsFulled++;
			return 1;// if alloted
		} else {
			System.out.println("Seats Full");
			return 0;// if not alloted
		}
	}
	


		/**
		 *print list of colleges with available seats 
		 */
		public void listOfCollegesWithAvailableSeats() {
			System.out.println("List of college        Seats Available");
			System.out.println("MLV   	           " + (4 - allocatedSeats[0]));
			System.out.println("MIT    		       " + (4 - allocatedSeats[1]));
			System.out.println("JCERC  		       " + (4 - allocatedSeats[2]));
			System.out.println("ARYA  		       " + (4 - allocatedSeats[3]));
			System.out.println("TINJR  		       " + (4 - allocatedSeats[4]));

		}

		/**
		 * 	print choices
		 */
		public void selectCollege() {
			System.out.println("Enter choice 1 for MLV, 2 for MIT, 3 for JCERC, 4 for ARYA, 5 for TINJR");
		}

		
		/**
		 * print list of students alloted to each college
		 */
		public void printListOfNamesOfStudentsAlloted(Students student) {
			
			System.out.println("College name and  Names of Students alloted to them");
			
			
		
			for (int i = 0; i < 5; i++) {
				System.out.println("List of students admitted in  "+ collegeList[i]);
				if( allocatedSeats[i]==0 || student.getRear()==-1 ){
				System.out.println("No seats allocated");
				}
				else{
					for (int j = 0; j < allocatedSeats[i]; j++) {
						System.out.println(allotmentList[i][j]);
					}
				}
			}
		}

}
