package TrainManagementByMenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import TrainManagementByMenu.Train.trainType;

/**
 * @author Deepali
 *
 */
public class TrainMenu {
	List<Train> trainList;// List of train
	Scanner sc = new Scanner(System.in);
	public TrainMenu() {// Here list is created
		trainList = new ArrayList<Train>();
	}

	/**
	 * To Show menu
	 */
	public void menu() {
		char choice;
		MenuList menulist = new MenuList();
		do {
			System.out.println("Enter Ticket Holder Name");
			String userName = sc.next();
			int trainType;
			do {
				menulist.displayMenu();
				do {// Validation
					System.out.println("Please enter a positive number!");
					while (!sc.hasNextInt()) {
						System.out.println("That's not a number!Please enter again");
						sc.next(); // this is important!
					}
					trainType = sc.nextInt();
				} while (trainType <= 0);

				if ((trainType != 1) && (trainType != 2)) {
					System.out.println("Enter right values");

				}
			} while ((trainType != 1) && (trainType != 2));

			if (trainType == 1) {
				passengerTrain(userName);
			}

			if (trainType == 2) {
				goodsTrainDisplay(userName);
			}

			do {// validation
				System.out.println("Do you want to continue(Y/N)"); // continuing
																	// the
																	// procedure
				while (!sc.hasNext()) {
					System.out.println("That's not a character!");
					sc.next(); // this is important!
				}
				choice = sc.next().toUpperCase().charAt(0);
				if (choice == 'N')
					System.exit(0);
			} while (choice != 'Y');

		} while (choice == 'Y');
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
		String duration = "";
		try {
			File f = new File(fileName).getAbsoluteFile();
			br = new BufferedReader(new FileReader(f));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] row = line.split(cvsSplitBy);
				type = row[0];
				trainNum = row[1];
				destination = row[2];
				source = row[3];
				availableSeat = row[4];
				price = row[5];
				duration = row[6];
				if (trainType.passengerTrain.toString().equals(type)) {// if
																		// belong
																		// to
																		// passenger
																		// train
					PassengerTrain passengerTrain = new PassengerTrain(
							Integer.parseInt(trainNum), source, destination,
							Double.parseDouble(price),
							Double.parseDouble(duration),
							Integer.parseInt(availableSeat));
					trainList.add(passengerTrain);// adding to train list
				} else {// if belong to goods train
					GoodsTrain goodsTrain = new GoodsTrain(
							Integer.parseInt(trainNum), source, destination,
							Double.parseDouble(price),
							Double.parseDouble(duration),
							Integer.parseInt(availableSeat));
					trainList.add(goodsTrain);// adding to train list
				}
			}
			sortChart();
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

	public void sortChart() { // sorting the chart according to duration

		Train train;
		for (int index = 0; index < trainList.size(); index++) {
			for (int i = 0; i < trainList.size(); i++) {
				double totalTime1 = ((trainList).get(index).duration);
				double totalTime2 = (trainList.get(i).duration);
				if (totalTime1 < totalTime2) {
					train = trainList.get(index);
					trainList.set(index, trainList.get(i));
					trainList.set(i, train);
				}
			}
		}

	}

	/**
	 * @param userName
	 *            :username of ticket holder
	 */
	public void passengerTrain(String userName) {
		int temp1 = 0, trainId;
		int size = 0;
		// Current train chart for passenger train
		System.out.println("---CURRENT TRAVELLING CHART");
		System.out
				.println("TRAIN No STARTINGPOINT ENDPOINT	PRICE SEATSAVAILABLE DURATION");
		Iterator<Train> iteratorTrain = trainList.iterator();// iterating train
																// list
		while (iteratorTrain.hasNext()) {
			Train train = iteratorTrain.next();
			if (train instanceof PassengerTrain) {// if instance of passenger
													// train
				PassengerTrain passengerTrain = (PassengerTrain) train;
				System.out.println(passengerTrain.trainNumber + "		"
						+ passengerTrain.startingPoint + "	"
						+ passengerTrain.endPoint + "	" + passengerTrain.price
						+ "	" + passengerTrain.seats + "  "
						+ passengerTrain.duration);
			}
		}
		System.out.println("Enter from where you want to go");
		String fromPlace = sc.next();
		System.out.println("Enter where you want to go");
		String toPlace = sc.next();
		// Refine Result as per requirement
		printRefineTrainList(fromPlace, toPlace, 1);
		System.out.println("Enter train id ");

		do {// Validation
			System.out.println("Please enter a positive number!");
			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!Please enter again");
				sc.next(); // this is important!
			}
			trainId = sc.nextInt();
		} while (trainId <= 0);

		Iterator<Train> trainIterator = trainList.iterator();// iterating train
																// list for
		// passenger train
		while (trainIterator.hasNext()) {
			Train train1 = trainIterator.next();
			if (train1 instanceof PassengerTrain) {
				PassengerTrain passengerTrain = (PassengerTrain) train1;
				if ((passengerTrain.getTrainNumber() == trainId)) {
					System.out.println("Enter no of seats");// tracking
															// seats
					int seats;
					do {// Validation
						System.out.println("Please enter a positive number!");
						while (!sc.hasNextInt()) {
							System.out
									.println("That's not a number!Please enter again");
							sc.next(); // this is important!
						}
						seats = sc.nextInt();
					} while (seats <= 0);
					if (seats < passengerTrain.seats) {// if seats available
						double amount = seats * passengerTrain.price;
						MenuList menulist = new MenuList();
						menulist.displayPaymentMenu();
						int paymentType;
						do {
							do {// Validation
								System.out
										.println("Please enter a positive number!");
								while (!sc.hasNextInt()) {
									System.out
											.println("That's not a number!Please enter again");
									sc.next(); // this is important!
								}
								paymentType = sc.nextInt();
							} while (paymentType <= 0);
							PaymentMode paymentmode = new PaymentMode();
							if (paymentType == 1) {
								paymentmode.creditCard(amount);
							} else if (paymentType == 2) {
								paymentmode.wallet(amount);
							} else if (paymentType == 3) {
								paymentmode.netBanking(amount);
							} else {
								System.out.println("enter right value");

							}
						} while ((paymentType != 1) && (paymentType != 2)
								&& (paymentType != 3));
						// reducing seats
						int newSeats = passengerTrain.seats - seats;
						passengerTrain.setSeats(newSeats);// setting reduced
															// seats
						System.out.println("YOUR DETAILS");
						// details of booking
						System.out.println("UserName---" + userName);
						System.out.println("FROM----" + fromPlace);
						System.out.println("TO-------" + toPlace);
						System.out.println("SEATS----" + seats);
						System.out.println("AMOUNT---" + amount);
						System.out.println("---CURRENT TRAVELLING CHART");// updated
																			// train
																			// chart
						System.out
								.println("TRAIN No STARTINGPOINT ENDPOINT	PRICE SEATSAVAILABLE DURATION");
						Iterator<Train> train = trainList.iterator();// Again
																		// iterating
																		// list
						while (train.hasNext()) {
							Train trainObject = train.next();
							if (trainObject instanceof PassengerTrain) {
								PassengerTrain passenger = (PassengerTrain) trainObject;

								System.out.println(passenger.trainNumber + "		"
										+ passenger.startingPoint + "	"
										+ passenger.endPoint + "	"
										+ passenger.price + "	"
										+ passenger.seats + "   "
										+ passenger.duration);
								size++;
							}
						}

					} else {// if seats not available
						System.out.println("seats not available");
					}

				} else {
					temp1 = temp1 + 1;
				}
				if (temp1 == size) {// if no train of such type
					System.out.println("no such train");
				}
			}
		}

	}

	public void printRefineTrainList(String source, String destination, int type) {
		int temp = 0, i = 0;
		if (type == 1) {
			Iterator<Train> iteratorTrain = trainList.iterator();// iterating
																	// train
																	// list
			while (iteratorTrain.hasNext()) {
				Train train = iteratorTrain.next();
				if (train instanceof PassengerTrain) {
					PassengerTrain passenger = (PassengerTrain) train;

					if (source.equalsIgnoreCase(passenger.getStartingPoint())
							&& destination.equalsIgnoreCase(passenger
									.getEndPoint())) {
						temp = temp + 1;
						System.out.println(temp);

						if (i == 0) {
							System.out
									.println("TRAINID	SOURCE DESTINATION	DURATION    SEATS	 PRICE");
							i++;
						}
						System.out.println(passenger.getTrainNumber() + "	"
								+ passenger.getStartingPoint() + "	"
								+ passenger.getEndPoint() + " "
								+ passenger.getDuration() + " "
								+ passenger.getSeats() + " "
								+ passenger.getPrice());
					}
				}
			}

			if (temp == 0) {
				System.out.println("No such trains.Try Another");
			}
		} else {
			Iterator<Train> iteratorTrain = trainList.iterator();// iterating
																	// train
																	// list
			while (iteratorTrain.hasNext()) {
				Train train = iteratorTrain.next();
				if (train instanceof GoodsTrain) {
					GoodsTrain goodsTrain = (GoodsTrain) train;

					if (source.equalsIgnoreCase(goodsTrain.getStartingPoint())
							&& destination.equalsIgnoreCase(goodsTrain
									.getEndPoint())) {
						temp = temp + 1;
						System.out.println(temp);

						if (i == 0) {
							System.out
									.println("TRAINID	SOURCE DESTINATION	DURATION    SEATS	 PRICE");
							i++;
						}
						System.out.println(goodsTrain.getTrainNumber() + "	"
								+ goodsTrain.getStartingPoint() + "	"
								+ goodsTrain.getEndPoint() + " "
								+ goodsTrain.getDuration() + " "
								+ goodsTrain.getWeight() + " "
								+ goodsTrain.getPrice());

					}
				}
			}

			if (temp == 0) {
				System.out.println("No such trains.Try Another");
			}
		}

	}

	/**
	 * @param userName
	 *            :username of ticket holder
	 */
	public void goodsTrainDisplay(String userName) {
		int temp1 = 0;
		int trainId;
		int size = 0;
		// Current train chart for passenger train
		System.out.println("---CURRENT TRAVELLING CHART");
		System.out
				.println("TRAIN No STARTINGPOINT ENDPOINT	PRICE WEIGHTAVAILABLE DURATION");
		Iterator<Train> iteratorTrain = trainList.iterator();// iterating train
																// list
		while (iteratorTrain.hasNext()) {
			Train train = iteratorTrain.next();
			if (train instanceof GoodsTrain) {// if instance of goods train
				GoodsTrain goodsTrain = (GoodsTrain) train;
				System.out.println(goodsTrain.trainNumber + "		"
						+ goodsTrain.startingPoint + "	" + goodsTrain.endPoint
						+ "	" + goodsTrain.price + "	" + goodsTrain.weight
						+ "   " + goodsTrain.duration);

			}
		}

		System.out.println("Enter from where you want to go");
		String fromPlace = sc.next();
		System.out.println("Enter where you want to go");
		String toPlace = sc.next();
		printRefineTrainList(fromPlace, toPlace, 2);
		System.out.println("Enter train id ");

		do {// Validation
			System.out.println("Please enter a positive number!");
			while (!sc.hasNextInt()) {
				System.out.println("That's not a number!Please enter again");
				sc.next(); // this is important!
			}
			trainId = sc.nextInt();
		} while (trainId <= 0);

		Iterator<Train> iterator = trainList.iterator();// iterating train list
		while (iterator.hasNext()) {
			Train train = iterator.next();
			if (train instanceof GoodsTrain) {// if instance of goods train
				GoodsTrain goodsTrain = (GoodsTrain) train;
				if ((goodsTrain.getTrainNumber() == trainId)) {
					System.out.println("Enter no of seats");// tracking
															// seats
					int weight;
					do {// Validation
						System.out.println("Please enter a positive number!");
						while (!sc.hasNextInt()) {
							System.out
									.println("That's not a number!Please enter again");
							sc.next(); // this is important!
						}
						weight = sc.nextInt();
					} while (weight <= 0);
					if (weight < goodsTrain.weight) {// if weight available
						double amount = weight * goodsTrain.price;
						MenuList menulist = new MenuList();
						menulist.displayPaymentMenu();
						int paymentType;
						do {
							do {// Validation
								System.out
										.println("Please enter a positive number!");
								while (!sc.hasNextInt()) {
									System.out
											.println("That's not a number!Please enter again");
									sc.next(); // this is important!
								}
								paymentType = sc.nextInt();
							} while (paymentType <= 0);
							PaymentMode paymentmode = new PaymentMode();
							if (paymentType == 1) {
								paymentmode.creditCard(amount);
							} else if (paymentType == 2) {
								paymentmode.wallet(amount);
							} else if (paymentType == 3) {
								paymentmode.netBanking(amount);
							} else {
								System.out.println("enter right value");

							}
						} while ((paymentType != 1) && (paymentType != 2)
								&& (paymentType != 3));
						// reducing weight
						double newWeight = goodsTrain.weight - weight;
						goodsTrain.setWeight(newWeight); // setting reducing
															// weight
						System.out.println("YOUR DETAILS");
						// details of booking
						System.out.println("UserName---" + userName);
						System.out.println("FROM----" + fromPlace);
						System.out.println("TO-------" + toPlace);
						System.out.println("SEATS----" + weight);
						System.out.println("AMOUNT---" + amount);
						System.out.println("---CURRENT TRAVELLING CHART");// updated
																			// train
																			// chart
						System.out
								.println("TRAIN No STARTINGPOINT ENDPOINT	PRICE WEIGHTAVAILABLE DURATION");
						Iterator<Train> trainIterator = trainList.iterator();// iterating
																				// train
																				// list
						while (trainIterator.hasNext()) {
							Train trainObject = trainIterator.next();
							if (trainObject instanceof GoodsTrain) {// if
																	// instance
																	// of goods
																	// train
								GoodsTrain goodTrain = (GoodsTrain) trainObject;
								System.out.println(goodTrain.trainNumber + "		"
										+ goodTrain.startingPoint + "	"
										+ goodTrain.endPoint + "	"
										+ goodTrain.price + "	"
										+ goodTrain.weight + "   "
										+ goodTrain.duration);
								size++;
							}
						}

					} else {// if seats not available
						System.out.println("seats not available");
					}

				} else {
					temp1 = temp1 + 1;
				}
				if (temp1 == size) {// if no train of such type
					System.out.println("no such train");
				}
			}
		}
	}

}