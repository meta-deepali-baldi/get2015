package PrinterRequestManagement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Deepali
 * 
 */
public class Printer {
	private List<Jobs> priorityQueue = new ArrayList<Jobs>(); // List of jobs
	private int timeForADocumentPrinting = 1; // duration for a document
	private Scanner sc = new Scanner(System.in);

	/**
	 * for inserting new jobs
	 */
	public void insertingNewJobs() {
		int choice = 0;
		char mainChoice = 0;
		String name, course, batch, aggregate, contactNumber;

		System.out.println("Enter Data to print");
		do {
			// menu
			System.out.println("enter 1 for Chair Information printing,"
					+ "\n2 for Professor Information printing,"
					+ "\n3 for Graduate Student Information printing,"
					+ "\n4 for Undergraduate Student Information printing,"
					+ "\n5 for displaying Jobs");
			choice = checkingInteger(choice);
			switch (choice) {
			case 1:
				// for chair information
				System.out.println("Enter Name of chair");
				name = sc.next();
				System.out.println("Enter Color of chair");
				String color = sc.next();
				System.out.println("Enter Company Name of chair");
				String companyName = sc.next();
				System.out.println("Enter Price of chair");
				String price = sc.next();
				System.out.println("Enter Yes/No if chair is adjustable or not");
				String answer = sc.next();
				double height = 0;
				System.out.println("Enter height of chair");
				height = checkingDouble(height);

				priorityQueue.add(new Chair(4, name, color, companyName, price,
						answer, height));
				break;
			case 2:
				// for professor information
				System.out.println("Enter Name of professor");
				name = sc.next();
				System.out.println("Enter specification of professor");
				String specification = sc.next();
				System.out.println("Enter address of professor");
				String address = sc.next();
				System.out.println("Enter contactNumber of professor");
				contactNumber = sc.next();
				System.out.println("Enter department of professor");
				String department = sc.next();
				System.out.println("Enter salary of professor");
				double salary = 0;
				salary = checkingDouble(salary);

				priorityQueue.add(new Professor(3, name, specification,
						address, contactNumber, department, salary));

				break;
			case 3:// for graduate student information
				System.out.println("Enter Name of Graduate Student");
				name = sc.next();
				System.out.println("Enter Course of Graduate Student");
				course = sc.next();
				System.out.println("Enter Batch of Graduate Student");
				batch = sc.next();
				System.out.println("Enter aggregatePercentage of Graduate Student");
				aggregate = sc.next();
				System.out.println("Enter address of Graduate Student");
				address = sc.next();
				System.out.println("Enter employed of Graduate Student");
				String employed = sc.next();
				System.out.println("Enter contactNumber of Graduate Student");
				contactNumber = sc.next();
				priorityQueue.add(new GraduateStudent(2, name, course, batch,
						aggregate, address, employed, contactNumber));
				break;
			case 4:
				// for undergraduate student
				System.out.println("Enter Name of UnderGraduate Student");
				name = sc.next();
				System.out.println("Enter Course of UnderGraduate Student");
				course = sc.next();
				System.out.println("Enter Batch of UnderGraduate Student");
				batch = sc.next();
				System.out.println("Enter aggregatePercentage of UnderGraduate Student");
				aggregate = sc.next();
				System.out.println("Enter address of UnderGraduate Student");
				address = sc.next();
				System.out.println("Enter contactNumber of UnderGraduate Student");
				contactNumber = sc.next();
				priorityQueue.add(new UndergraduateStudent(1, name, course,
						batch, aggregate, address, contactNumber));
				break;
			case 5:
				// for displaying jobs in priority queue
				printJobsBasedOnPriority();
				break;
			default:
				System.out.println("enter rightvalues");

			}
			mainChoice = checkingString(mainChoice);

		} while (mainChoice == 'Y');

		heapifyJobs();

		assigningPrinter();
	}

	/**
	 * checking input is integer or not
	 * 
	 * @param value
	 *            :value to get
	 * @return :an integer value
	 */
	public int checkingInteger(int value) {

		do {// Validation

			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!Please enter again");
				sc.next(); // this is important!
			}
			value = sc.nextInt();
		} while (value <= 0);
		return value;

	}

	/**
	 * checking input is double or not
	 * 
	 * @param value
	 *            :value to get
	 * @return :return a double value
	 */
	public double checkingDouble(double value) {

		do {// Validation

			while (!sc.hasNextDouble()) {
				System.out.println("That's not a number!Please enter again");
				sc.next(); // this is important!
			}
			value = sc.nextDouble();
		} while (value <= 0);
		return value;

	}

	/**
	 * checking input is String or not
	 * 
	 * @param value
	 *            :value to get
	 * @return :return a char value
	 */
	public char checkingString(char value) {

		do {// validation
			System.out.println("Do you want to enter more jobs ?(Y/N)"); // continuing
			// the
			// procedure
			while (!sc.hasNext()) {
				System.out.println("That's not a character!");
				sc.next(); // this is important!

			}
			value = sc.next().toUpperCase().charAt(0);
			if (value == 'N')
				break;
		} while (value != 'Y');
		return value;
	}

	/**
	 * To heapify the queue
	 */
	public void heapifyJobs() {
		for (int i = ((priorityQueue.size() - 1) / 2); i >= 0; i--) {

			heapM(i);
		}

	}

	/**
	 * to create maxHeap
	 * 
	 * @param i
	 *            :parent index
	 */
	public void heapM(int i) {

		int largest;
		int left = leftchild(i);
		int right = rightchild(i);
		if (left == -1 || right == -1) {
			return;
		}
		if (((left < priorityQueue.size()) && (priorityQueue.get(left)
				.getPriority() > priorityQueue.get(i).getPriority()))) {// for
																		// checking
																		// with
																		// left
																		// child
			largest = left;
		} else {
			largest = i;
		}

		if (((right < priorityQueue.size()) && (priorityQueue.get(right)
				.getPriority() > priorityQueue.get(largest).getPriority()))) {// for
																				// checking
																				// with
																				// right
																				// child
			largest = right;
		}
		if (largest != i) {
			swap(i, largest);

			heapM(largest);
		}
	}

	/**
	 * Swapping instances
	 * 
	 * @param i
	 *            :First index
	 * @param largest
	 *            :second index
	 */
	public void swap(int i, int largest) {
		Jobs job = priorityQueue.get(i);
		priorityQueue.set(i, priorityQueue.get(largest));
		priorityQueue.set(largest, job);

	}

	/**
	 * Assigning job to printer
	 */
	public void assigningPrinter() {

		int counter = 0, result;
		char mainChoice = 0;
		while (counter != timeForADocumentPrinting) {
			result = assignJobsToPrinter();
			if (result == -1) {
				break;
			} else {
				counter = 0;
			}

			mainChoice = checkingString(mainChoice);
			if (mainChoice == 'Y') {
				insertingNewJobs();
			}

		}
	}

	/**
	 * @return integer value to check if assigned or not
	 */
	public int assignJobsToPrinter() {

		if (priorityQueue.size() == 0) {
			return -1; // Removing from empty heap
		}
		swap(0, priorityQueue.size() - 1); // Swap maximum with last value

		printJobWhichIsAssignedToPrinter();
		priorityQueue.remove(priorityQueue.size() - 1);

		if (priorityQueue.size() != 0) {// Not on last element
			heapifyJobs();
		}
		return 1;
	}

	/**
	 * printing job which is assigned to printer
	 */
	public void printJobWhichIsAssignedToPrinter() {
		Jobs job = priorityQueue.get(priorityQueue.size() - 1);
		printSection(job);
	}

	/**
	 * printing job based on priority in queue
	 */
	public void printJobsBasedOnPriority() {
		Iterator<Jobs> jobsIterator = priorityQueue.iterator(); // Iterating
																// list of
																// questions

		while (jobsIterator.hasNext()) {
			printSection(jobsIterator.next());
		}
	}

	/**
	 * @param job :job to display
	 */
	public void printSection(Jobs job) {

		if (job instanceof Chair) {
			Chair chair = (Chair) job;
			System.out.println("Priority of Job :" + chair.getPriority());
			System.out.println("Name of chair :" + chair.getName());

			System.out.println("Color of chair :" + chair.getColor());
			System.out.println("Company Name of chair :"
					+ chair.getCompanyName());
			System.out.println("Price of chair :" + chair.getPrice());
			System.out.println("Chair is Adjustable or not :"
					+ chair.getAdjustableChair());
			System.out.println("Height of chair :" + chair.getHeight());

		} else if (job instanceof Professor) {
			Professor professor = (Professor) job;
			System.out.println("Priority of Job :" + professor.getPriority());
			System.out.println("Name of Professor :" + professor.getName());

			System.out.println("Specification of Professor :"
					+ professor.getSpecification());
			System.out.println("Address of Professor :"
					+ professor.getAddress());
			System.out.println("Department  of professor :"
					+ professor.getDepartment());
			System.out.println("Contact Number of Professor :"
					+ professor.getContactNumber());
			System.out.println("Salary of Professor :" + professor.getSalary());

		} else if (job instanceof GraduateStudent) {
			GraduateStudent graduateStudent = (GraduateStudent) job;
			System.out.println("Priority of Job :"
					+ graduateStudent.getPriority());
			System.out.println("Name of Graduate Student :"
					+ graduateStudent.getName());

			System.out.println("Address of Graduate Student :"
					+ graduateStudent.getAddress());
			System.out.println("Batch of Graduate Student :"
					+ graduateStudent.getBatch());
			System.out.println("Course of Graduate Student :"
					+ graduateStudent.getCourse());
			System.out.println("Is Grauate Student Employed ? :"
					+ graduateStudent.getEmployed());
			System.out.println("Percentage of Graduate Student :"
					+ graduateStudent.getPercentage());
			System.out.println("Contact Number of Graduate Student :"
					+ graduateStudent.getContactNumber());

		} else {
			UndergraduateStudent student = (UndergraduateStudent) job;
			System.out.println("Priority of Job :" + student.getPriority());
			System.out.println("Name of Student :" + student.getName());

			System.out.println("Address of Student :" + student.getAddress());
			System.out.println("Batch of Student :" + student.getBatch());
			System.out.println("Course of Student :" + student.getCourse());
			System.out.println("Percentage of Student"
					+ student.getAggregatePercentage());
			System.out.println("Contact Number of Student :"
					+ student.getContactNumber());

		}
	}

	
	/**Return position for left child of pos
	 * @param pos :parent index
	 * @return :returns  chid index
	 */
	int leftchild(int pos) {
		if (pos > (priorityQueue.size() - 1) / 2)
			return -1;
		return 2 * pos + 1;
	}

	
	/**Return position for right child of pos
	 * @param pos :parent index
	 * @return :returns  chid index
	 */
	int rightchild(int pos) {
		if (pos > (priorityQueue.size() - 2) / 2)
			return -1;
		return 2 * pos + 2;
	}

}
