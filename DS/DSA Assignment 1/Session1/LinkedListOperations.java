/**
 * Q3: WAP to implement a singly Linkedlist that must contain following operations:

a)Creation of linked list

b)Add the particular item in the linked list at the particular location

c)Removal of an item based on its value   

d)Removal of an item based on its index

e)Retrieval of an item of particular index

f)Reversal of linked list

g)Sorting of linked list
 */
package Session1;

import java.util.Scanner;

/**
 * @author Deepali
 *
 * @param <T>
 *            : Generic Type
 */
public class LinkedListOperations<T> {

	/**
	 * @param dataFirst :first data to add
	 * @param dataSecond :Second data to add
	 * @return :return the starting pointer
	 */
	public Node<T> createLinkedList(T dataFirst, T dataSecond) {
		Node<T> start = null, first, second;
		first = new Node<T>(dataFirst);
		second = new Node<T>(dataSecond);
		first.next = second;
		start = first;
		return start;
	}

	/**
	 * Insertion at position
	 * @param position:position after which element to be found
	 * @param item: item to be found
	 * @param start:Starting pointer of linked list
	 * @return :starting pointer
	 */
	public Node<T> insertAtPosition(int position, T item, Node<T> start) {
		Node<T> current = start;
		Node<T> newNode = new Node<T>(item);
		if (position == 0) {
			start = newNode;
			newNode.next = current;
			return start;

		} else if (position > 0) {
			for (int i = 1; i < position; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
		return start;
	}

	/**
	 * Deletion at position
	 * 
	 * @param position:position after which element to be deleted
	 * @param start:Starting pointer
	 * @param sizeList :no of nodes
	 * @return :starting pointer
	 */
	public Node<T> deleteAtPosition(int position, Node<T> start, int sizeList) {
		Node<T> current = start;
		Node<T> previous = start;
		int i;
		if (position == 0) {
			start = start.next;
			return start;
		}

		else if (position == (sizeList - 1)) {
			for (i = 0; i <= sizeList - 1; i++) {
				previous = current;
				current = current.next;
			}
			previous.next = null;
			return previous;
		}

		else {
			for (i = 1; i < position; i++) {
				current = current.next;
			}
			current.next = current.next.next;
		}
		return current;

	}

	/**
	 * Retrieve element at position
	 * 
	 * @param position :position at which element to be get
	 * @param start : Starting pointer
	 * @return :starting pointer
	 */
	public T retrieveAtPosition(int position, Node<T> start) {
		Node<T> current = start;
		for (int i = 0; i < position; i++) {
			current = current.next;
		}
		return current.nodeValue;
	}

	/**
	 * Displaying data of list
	 * 
	 * @param start: Starting pointer
	 */
	public void display(Node<T> start) {
		Node<T> current = start;
		while (current != null) {
			System.out.println(current.nodeValue);
			current = current.next;

		}

	}

	/**
	 * Reversing Linked List
	 * 
	 * @param start : Starting pointer
	 * @return :starting pointer
	 */
	public Node<T> reverseLinkedList(Node<T> start) {
		if (start == null || start.next == null) {
			return start;
		}
		Node<T> Second = start.next;
		// store third node before we change
		Node<T> Third = Second.next;
		// Second's next pointer
		Second.next = start; // second now points to head
		start.next = null; // change head pointer to NULL
		// only two nodes, which we already reversed
		if (Third == null)
			return Second;
		Node<T> CurrentNode = Third;
		Node<T> PreviousNode = Second;
		while (CurrentNode != null) {
			Node<T> NextNode = CurrentNode.next;
			CurrentNode.next = PreviousNode;
			PreviousNode = CurrentNode;
			CurrentNode = NextNode;
		}
		start = PreviousNode; // reset the head node

		return start;
	}

	/**
	 * Calculating length of Linked List
	 * 
	 * @param start : Starting pointer
	 * @return :starting pointer
	 */
	public int calculateLength(Node<T> start) {
		int count = 1;
		Node<T> current = start;
		while (current.next != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	/**
	 * Deleting element by value
	 * @param start : Starting pointer
	 * @param value : value to be deleted
	 * @return :starting pointer
	 */
	public Node<T> deleteAtValue(Node<T> start, String value, int sizeList) {
		Node<T> current = start;
		Node<T> previous = start;
		if (current.nodeValue.equals(value)) {
			start = current.next;
		} else {

			while (current.next != null) {
				previous = current;
				current = current.next;
				if (current.nodeValue.equals(value)) {
					previous.next = current.next;
				}

			}
		}
		return start;
	}

	/**
	 * Sorting data of Linked list
	 * 
	 * @param start: Starting pointer
	 * @return : Starting pointer
	 */
	Node<T> sort(Node<T> start) {
		Node<T> nodeFirst = start, nodeSecond;
		String string;
		while (nodeFirst != null) // apply simple sorting to sort the elements
									// of Linked list
		{
			nodeSecond = start;
			while (nodeSecond.next != null) {
				if (((String) nodeSecond.nodeValue)
						.compareTo((String) nodeSecond.next.nodeValue) > 0) {
					string = (String) nodeSecond.nodeValue;
					nodeSecond.nodeValue = nodeSecond.next.nodeValue;
					nodeSecond.next.nodeValue = (T) string;
				}
				nodeSecond = nodeSecond.next;
			}
			nodeFirst = nodeFirst.next;
		}
		return start;
	}

	public static void main(String args[]) {
		LinkedListOperations<String> object = new LinkedListOperations<String>();
		Scanner sc = new Scanner(System.in);
		int choice;
		int position;
		Node<String> node = null;
		String input;

		do {
			System.out.println("1) Creation of linked list");
			System.out.println("2) Add the particular item in the linked list at the particular location");
			System.out.println("3) Removal of an item based on its value ");
			System.out.println("4) Removal of an item based on its index");
			System.out.println("5) Retrieval of an item of particular index");
			System.out.println("6) Reversal of linked list");
			System.out.println("7) Sorting of linked list");
			do {// Validation
				System.out.println("Please enter a positive number!");
				while (!sc.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					sc.next(); // this is important!
				}
				choice = sc.nextInt();
			} while (choice <= 0);

			switch (choice) {
			case 1:
				System.out.println("Enter a generic value to create a linked list");
				String dataFirst = sc.next();
				String dataSecond = sc.next();
				node = object.createLinkedList(dataFirst, dataSecond);
				System.out.println("After node creation");
				object.display(node);
				break;

			case 2:

				System.out.println("Enter a string to be inserted");
				input = sc.next();
				System.out.println("Enter position of string to be inserted");
				position = sc.nextInt();
				System.out.println("After inserting at required position");
				node = object.insertAtPosition(position, input, node);
				object.display(node);

				break;

			case 3:
				System.out.println("Enter string to be deleted");
				node = object.deleteAtValue(node, sc.next(),object.calculateLength(node));
				object.display(node);
				break;

			case 4:
				System.out.println("Enter position of string to be deleted");
				position = sc.nextInt();
				System.out.println("After deleting at required position");
				node = object.deleteAtPosition(position, node,object.calculateLength(node));
				object.display(node);
				break;

			case 5:
				System.out.println("To retrieve at a particular position");
				System.out.println("Enter position of string to be retrieved");
				position = sc.nextInt();
				String string = object.retrieveAtPosition(position, node);
				System.out.println(string);
				break;
			case 6:
				System.out.println("Reverse Linked list");
				node = object.reverseLinkedList(node);
				object.display(node);
				break;
			case 7:
				System.out.println("Sorting Linked list");
				object.sort(node);
				object.display(node);
				break;
			default:
				System.out.println("Enter Correct Choice");
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
		sc.close();
	}
}
