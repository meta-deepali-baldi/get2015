
/**
 * Assignment 1: Train Reservation System Console Application
 
System will ask User to enter his Name and train type Passenger/Goods (P/G). Trains will get listed out those have availability order by duration (travel time). (Read train info from file)
Now system will ask User for from-to station and refine the results depending on user input.
System will ask User to enter required details like.. Train Name/Id and Seat (if Passenger)/Weight (if Goods).
Booking won't process further if entered seat/weight is greater than train's availability. System will refine result and display suitable trains.
Now for booking ask for Payment mode.. Credit Card / Wallet / Net Banking etc.. Based on the payment mode selection user will fill required details like..
CC - CC number and cvv
Wallet - nothing, just process the payable amount
Net Banking - Bank, UserName, Password
Once everything confirm as per the business model, System will print the Ticket details and reduce number of seats/weight from that train.
System will Ask for another booking.. display chart accordingly, follow A.
 
 
Output Report:
A. Ticket Details on successful Booking (UserName, Train Number, Number of Booked Seats/weight, Paid Amount)
B. Updated Train chart


 *
 */
package TrainManagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import TrainManagement.Train.trainType;

/**
 * @author Deepali
 *
 */
public class Booking {

	List<Train> trainList;//List of train
	private static Scanner sc;

	public Booking() {//Here list is created
		trainList = new ArrayList<Train>();
	}

	public static void main(String[] args) {
		char choice;
		Booking booking = new Booking();
		try {
			booking.readData("./src/TrainManagement/Train.txt");

			do {
				System.out.println("Enter Ticket Holder Name");
				sc = new Scanner(System.in);
				String userName = sc.next();

				System.out.println("What type of train you want");
				System.out.println("1.Passenger Train");
				System.out.println("2.Goods Train");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					booking.passengerTrain(userName);//booking for passenger train
					break;
				case 2:
					booking.goodsTrainDisplay(userName);//booking for goods train
					break;
				default:
					System.out.println("Enter right values");

				}
				System.out.println("Do you want to continue(Y/N)"); // continuing
																	// the
																	// procedure
				choice = sc.next().toUpperCase().charAt(0);

			} while (choice == 'Y');

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * @param fileName :filename where data to be read regarding train
	 * @throws IOException :if no file found then this exception thrown
	 */
	public void readData(String fileName) throws IOException {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String source = "";
		String destination = "";
		String price = "";
		String availableSeat = "";
		String type = "";
		String trainNum = "";

		try {

			br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] row = line.split(cvsSplitBy);
				type = row[0];
				trainNum = row[1];
				destination = row[2];
				source = row[3];
				availableSeat = row[4];
				price = row[5];

				if (trainType.passengerTrain.toString().equals(type)) {//if belong to passenger train
					PassengerTrain passengerTrain = new PassengerTrain(
							trainNum, source, destination,
							Double.parseDouble(price),
							Integer.parseInt(availableSeat));
					trainList.add(passengerTrain);//adding to train list
				} else {//if belong to goods train
					GoodsTrain goodsTrain = new GoodsTrain(trainNum, source,
							destination, Double.parseDouble(price),
							Integer.parseInt(availableSeat));
					trainList.add(goodsTrain);//adding to train list
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * @param userName :username of ticket holder
	 */
	public void passengerTrain(String userName) {
		int temp1 = 0;
		int size=0;
		//Current train  chart for passenger train
		System.out.println("---CURRENT TRAVELLING CHART");
		System.out.println("TRAIN No STARTINGPOINT ENDPOINT	PRICE SEATSAVAILABLE");
		Iterator<Train> itr3 =trainList.iterator();//iterating train list
		while (itr3.hasNext()) {
			Train train=itr3.next();
			if ( train instanceof PassengerTrain) {//if instance of passenger train
			PassengerTrain object5 = (PassengerTrain) train;
			System.out.println(object5.trainNumber + "		"
					+ object5.startingPoint + "	"
					+ object5.endPoint + "	" + object5.price + "	"
					+ object5.seats);

		}
		}

		System.out.println("Enter from where you want to go");
		String fromPlace = sc.next();
		System.out.println("Enter where you want to go");
		String toPlace = sc.next();
		Iterator<Train> itr4 =trainList.iterator();//iterating train list for passenger train
		while (itr4.hasNext()) 
		{
			Train train1=itr4.next();
			if ( train1 instanceof PassengerTrain) {
				PassengerTrain object1 = (PassengerTrain) train1;
				if ((object1.startingPoint.equalsIgnoreCase(fromPlace))
						&& (object1.endPoint.equalsIgnoreCase(toPlace))) {//checking for specified train by user
					System.out.println("Enter no of seats");
					int seats = sc.nextInt();
					if (seats < object1.seats) {//if seats available
						double amount = seats * object1.price;
						System.out.println("enter payment mode");
						System.out.println("1.CreditCard");
						System.out.println("2.Wallet");
						System.out.println("3.Netbanking");
						int choose = sc.nextInt();
						//Payment procedure
						PaymentMode payment = new PaymentMode();
						switch (choose) {
						case 1:
	
							payment.creditCard(amount);
							break;
	
						case 2:
	
							payment.wallet(amount);
							break;
	
						case 3:
							payment.netBanking(amount);
							break;
	
						default:
							System.out.println("Enter right values");
							break;
	
						}
					//reducing seats
						int newSeats = object1.seats - seats;
						object1.setSeats(newSeats);//setting reduced seats
						System.out.println("YOUR DETAILS");
						//details of booking
						System.out.println("UserName---" + userName);
						System.out.println("FROM----" + fromPlace);
						System.out.println("TO-------" + toPlace);
						System.out.println("SEATS----" + seats);
						System.out.println("AMOUNT---" + amount);
						System.out.println("---CURRENT TRAVELLING CHART");//updated train chart
						System.out.println("TRAIN No STARTINGPOINT ENDPOINT	PRICE SEATSAVAILABLE");
						Iterator<Train> itr41 =trainList.iterator();//Again iterating list
						while (itr41.hasNext()) {
							Train train11=itr41.next();
							if ( train11 instanceof PassengerTrain) {
								PassengerTrain object11 = (PassengerTrain) train11;

							System.out.println(object11.trainNumber
									+ "		" + object11.startingPoint
									+ "	" + object11.endPoint + "	"
									+ object11.price + "	"
									+ object11.seats);
							size++;
							}
						}
	
					} else {//if seats not available
					System.out.println("seats not available");
					}

				} 
				else {
					temp1 = temp1 + 1;
				}
				if (temp1 ==size) {//if no train of such type
					System.out.println("no such train");
				}
			}
		}
			
	}

	/**
	 * @param userName :username of ticket holder
	 */
	public void goodsTrainDisplay(String userName) {
		int temp1 = 0;
		int size=0;
		//Current train  chart for passenger train
		System.out.println("---CURRENT TRAVELLING CHART");
		System.out
				.println("TRAIN No STARTINGPOINT ENDPOINT	PRICE WEIGHTAVAILABLE");
		Iterator<Train> itr3 =trainList.iterator();//iterating train list
		while (itr3.hasNext()) {
			Train train=itr3.next();
			if ( train instanceof GoodsTrain) {//if instance of goods train
			GoodsTrain object5 = (GoodsTrain) train;
			System.out.println(object5.trainNumber + "		"
					+ object5.startingPoint + "	"
					+ object5.endPoint + "	" + object5.price + "	"
					+ object5.weight);

		}
		}

		System.out.println("Enter from where you want to go");
		String fromPlace = sc.next();
		System.out.println("Enter where you want to go");
		String toPlace = sc.next();
		Iterator<Train> itr4 =trainList.iterator();//iterating train list for goods train
		while (itr4.hasNext()) 
		{
			Train train1=itr4.next();
			if ( train1 instanceof GoodsTrain) {
				GoodsTrain object5 = (GoodsTrain) train1;
				if ((object5.startingPoint.equalsIgnoreCase(fromPlace))
						&& (object5.endPoint.equalsIgnoreCase(toPlace))) {//checking for specified train by user
					System.out.println("Enter Weight needed in Goods Train");
					double weight = sc.nextDouble();
					if (weight < object5.weight) {//if weight available
						double amount = weight * object5.price;
						System.out.println("enter payment mode");
						System.out.println("1.CreditCard");
						System.out.println("2.Wallet");
						System.out.println("3.Netbanking");
						int choose = sc.nextInt();
						//Payment procedure
						PaymentMode payment = new PaymentMode();
						switch (choose) {
						case 1:
	
							payment.creditCard(amount);
							break;
	
						case 2:
	
							payment.wallet(amount);
							break;
	
						case 3:
							payment.netBanking(amount);
							break;
	
						default:
							System.out.println("Enter right values");
							break;
	
						}
						//reducing weight
						double newWeight = object5.weight - weight;
						object5.setWeight(newWeight);	//setting reducing weight
						System.out.println("YOUR DETAILS");
						//details of booking
						System.out.println("UserName---" + userName);
						System.out.println("FROM----" + fromPlace);
						System.out.println("TO-------" + toPlace);
						System.out.println("SEATS----" + weight);
						System.out.println("AMOUNT---" + amount);
						System.out.println("---CURRENT TRAVELLING CHART");//updated train chart
						System.out.println("TRAIN No STARTINGPOINT ENDPOINT	PRICE WEIGHTAVAILABLE");
						Iterator<Train> itr41 =trainList.iterator();//Again iterating list
						while (itr41.hasNext()) {
							Train train11=itr41.next();
							if ( train11 instanceof GoodsTrain) {
								GoodsTrain object6 = (GoodsTrain) train11;

							System.out.println(object6.trainNumber
									+ "		" + object6.startingPoint
									+ "	" + object6.endPoint + "	"
									+ object6.price + "	"
									+ object6.weight);
							size++;
							}
						}
	
					} else {//if seats not available
					System.out.println("seats not available");
					}

				} 
				else {
					temp1 = temp1 + 1;
				}
				if (temp1 ==size) {//if no train of such type
					System.out.println("no such train");
				}
			}
		}
	}

}