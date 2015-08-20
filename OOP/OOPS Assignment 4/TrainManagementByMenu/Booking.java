/**
 * Assignment 2: Apply the design of the menu discussed in the class in one of the previous assignment. 
 * The aim of the exercise is to replace the SOPs in the main program with the the Menu related classes discussed in the OOP Session 4 (Menu , MenuItem , Action , ActionableMenuItem etc. )
 */
package TrainManagementByMenu;

import java.io.IOException;

/**
 * @author Deepali
 *
 */
public class Booking {

	public static void main(String[] args) {
		try {
			TrainMenu trainMenu = new TrainMenu();
			trainMenu.readData("./src/RefactoredTrainManagement/Train.txt");//reading data
			trainMenu.menu();// calling menu

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}