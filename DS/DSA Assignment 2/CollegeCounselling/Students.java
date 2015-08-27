package CollegeCounselling;

import java.util.Arrays;

/**
 * @author Deepali
 *
 */

public class Students {
	private int front = -1; //position where element to be deleted
	private int rear = -1; //position where element to be entered
	private String[] studentNameList;
	private int[] studentRanklist;

	
	/**constructor to initialize limit of list
	 * @param length :no of student
	 */
	Students(int length) {
		studentNameList = new String[length];
		studentRanklist = new int[length];
	}

	
	
	
	/**
	 * @return the rear
	 */
	public int getRear() {
		return rear;
	}




	/**
	 * @param rear the rear to set
	 */
	public void setRear(int rear) {
		this.rear = rear;
	}




	/**
	 * @param front the front to set
	 */
	public void setFront(int front) {
		this.front = front;
	}




	/**
	 * @return the studentNameList
	 */
	public String[] getStudentNameList() {
		return studentNameList;
	}




	/**
	 * @param studentNameList the studentNameList to set
	 */
	public void setStudentNameList(String[] studentNameList) {
		this.studentNameList = studentNameList;
	}




	/**
	 * @return the studentRanklist
	 */
	public int[] getStudentRanklist() {
		return studentRanklist;
	}




	/**
	 * @param studentRanklist the studentRanklist to set
	 */
	public void setStudentRanklist(int[] studentRanklist) {
		this.studentRanklist = studentRanklist;
	}




	/**to add student
 	 * @param name :name of student to add
	 * @param rank :rank of that student
	 */
	public void enqueue(String name, int rank) {
		if (front < 20) {
			if (front == -1 && rear == -1) {
				front++;
				rear++;

			} else {
				rear++;
			}
			studentRanklist[rear] = rank;
			studentNameList[rear] = name;
		} else {
			studentNameList = Arrays.copyOf(studentNameList,
					studentNameList.length + 10);
			rear++;
			studentNameList[rear] = name;
			studentRanklist[rear] = rank;
		}

	}

	
	/**to remove student
	 * @return name of student removed
	 */
	public String dequeue() {
		String name;
		if (rear != -1) {
			name = studentNameList[front];
			front++;
		} else {
			System.out.println("queue empty");
			name = "";
		}
		return name;
	}


	/**
	 * to clear list 
	 */
	public void makeEmpty() {
		studentNameList = null;
		front = -1;
		rear = -1;
		studentRanklist = null;
	}

	
	/**to get name at top of queue
	 * @return :element at top
	 */
	public String getFront() {
		if(front!=-1){
		return studentNameList[front];
		}
		else{
		return "noName";
		}
	}
		

	
	/**
	 * for sorting student list according to their rank
	 */
	public void sortingByRank() {
		String forName = "";
		int forRank;

		for (int i = 0; i < (studentNameList.length); i++) {
			for (int j = i; j < studentNameList.length - 1; j++) {
				if (studentRanklist[j] > studentRanklist[j + 1]) {
					forName = studentNameList[j + 1];
					studentNameList[j + 1] = studentNameList[j];
					studentNameList[j] = forName;

					forRank = studentRanklist[j + 1];
					studentRanklist[j + 1] = studentRanklist[j];
					studentRanklist[j] = forRank;
				}

			}

		}

	}


	
}
