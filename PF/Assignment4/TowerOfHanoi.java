/**
 * Tower of Hanoi
List<String> towerOfHanoi(String source, String destination, String temp, int numOfDisk)
Write JUnit for the above program:
towerOfHanoi(“A”, “B”, “C”, 1);
Expected: Returns List of movements of discs.
Move Disk 1 from A to B 

towerOfHanoi(“A”, “B”, “C”, 2);
Expected: Returns List of movements of discs.
Move Disk 2 from A to C 
Move Disk 1 from A to B 
Move Disk 2 from C to B

towerOfHanoi(“A”, “B”, “C”, 3);
Expected: Returns List of movements of discs.
Move Disk 3 from A to B 
Move Disk 2 from A to C 
Move Disk 3 from B to C
Move Disk 1 from A to B 
Move Disk 3 from C to A 
Move Disk 2 from C to B
Move Disk 3 from A to B
 *
 */
package Assignment4;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Deepali
 */
public class TowerOfHanoi {
	static List<String> Result;//List for Storing Result
	int numberOfDisk;//No. of Disks 

	public TowerOfHanoi(int numberOfDisk) {
		super();
		this.numberOfDisk = numberOfDisk;
	}

	public static void main(String[] args) {
		int temp = 0;
		Result = new ArrayList<String>();
		TowerOfHanoi towerHanoi;
		Scanner sc = new Scanner(System.in);
		
		do{
			switch (temp) {
			case 0:
				System.out.println("Enter Number of Disk for Tower Of Hanoi");
				towerHanoi = new TowerOfHanoi(sc.nextInt());
				if (towerHanoi.numberOfDisk > 0) {
					Result = towerHanoi.towerOfHanoi("A", "B", "C", 1);
					Iterator<String> itr = Result.iterator();// getting Iterator from arraylist to traverse elements
					while (itr.hasNext()) {//output 
						System.out.println(itr.next());
					}
				}
				System.out.println("Press 1 if you want to exit");
				System.out.println("Press 0 if you want to continue");
				temp = sc.nextInt();
				Result.removeAll(Result);
				break;
			case 1:
				System.exit(0);
			}
		}while(true);
			
	}

	/**
	 * @param source :Denote Starting bar
	 * @param destination :Denote Ending Bar
	 * @param temp :Denote Helping Bar
	 * @param n :Denote Starting Disk
	 * @return :Returning List of String
	 */
	List<String> towerOfHanoi(String source, String destination, String temp,int n) {
		if (n == numberOfDisk) {//if 1 disk left in source bar
			Result.add("Move Disk   " + n + "   " + source + "->" + destination);
		} else {
			towerOfHanoi(source, temp, destination, n + 1);//n-1 disk movement from source to temp
			Result.add("Move Disk  " + n + "   " + source + "->" + destination);
			towerOfHanoi(temp, destination, source, n + 1);//n-1 disk movement from temp to destination
		}
		return (Result);

	}
}
