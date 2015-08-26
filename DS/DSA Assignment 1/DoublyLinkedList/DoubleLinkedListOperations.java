
/**
 * WAP to implement the doubly Linkedlist that must contain all of the above operations.
 */
package DoublyLinkedList;

import java.util.Scanner;


/**
 * @author Deepali
 *
 * @param <T> :Generic type
 */
public class DoubleLinkedListOperations<T> {

	/**
	 * @param dataFirst :first data to add
	 * @param dataSecond :Second data to add
	 * @return :return the starting pointer
	 */
	public Node<T> createDoublyLinkedList(T dataFirst, T dataSecond) {
		Node<T> start = null, first, second;
		first = new Node<T>(dataFirst);
		second = new Node<T>(dataSecond);
		start = first;
		first.next = second;
		second.prev = first;
		return start;
	}

	/**
	 * Insertion at position
	 * @param position:position after which element to be found
	 * @param element: item to be found
	 * @param start:Starting pointer of linked list
	 * @return :starting pointer
	 */ 
	public Node<T> insertAtPosition(String element, int position, Node<T> start, int listSize) {
		Node<T> newNode = new Node<T>((T) element);
		Node<T> current = start;
		if (position == 0) {
			start = newNode;
			newNode.next = current;
			newNode.prev = null;
			return start;

		} else if (position > 0 && position < listSize - 1) {
			for (int i = 1; i < position; i++) {
				current = current.next;
			}
			current.next.prev = newNode;
			newNode.next = current.next;
			newNode.prev = current;
			current.next = newNode;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			newNode.prev = current;
		}
		return start;

	}

	/**
	 * Deleting element by value
	 * @param start : Starting pointer
	 * @param value : value to be deleted
	 * @return :starting pointer
	 */
	public Node<T> deleteAtValue(Node<T> start, String value, int listSize) {
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
					if(current.next!=null)
					current.next.prev = previous;
				}

			}
		}
		return start;
	}

	/**
	 * Deletion at position
	 * 
	 * @param position:position after which element to be deleted
	 * @param start:Starting pointer
	 * @param listSize :no of nodes
	 * @return :starting pointer
	 */
	public Node<T> deleteAtPosition(int position, Node<T> start, int listSize) {
		Node<T> current = start;
		Node<T> previous = start;
		int i;
		if (position == 0) {
			start = start.next;
			return start;
		}

		else if (position > 0 && position < listSize - 1) {
			for (i = 0; i < position; i++) {
				previous = current;
				current = current.next;
			}
			previous.next = current.next;
			current.next.prev = previous;
			return previous;
		}

		else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = null;
		}
		return start;

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
	public Node<T> reverseDoublyLinkedList(Node<T> start,int listSize) {
		Node<T> nodeFirst = start, nodeSecond = start;
		String temp;
		while (nodeSecond.next != null) 
		{
			nodeSecond = nodeSecond.next;
		}

		for(int i=0; i<listSize/2; i++) 
		{
			temp = (String) nodeFirst.nodeValue;
			nodeFirst.nodeValue = nodeSecond.nodeValue;
			nodeSecond.nodeValue = (T) temp;
			nodeFirst = nodeFirst.next;
			nodeSecond= nodeSecond.prev;
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

	/**
	 * Calculating length of Linked List
	 * 
	 * @param start : Starting pointer
	 * @return :starting pointer
	 */
	public int calculateLength(Node<T> start)
	{
		int count=1;
		Node<T> current = start;
		while(current.next!=null)
		{
			current = current.next;
			count++;
		}
		return count;
	}

	public static void main(String args[]) {
		DoubleLinkedListOperations<String> object = new DoubleLinkedListOperations<String>();
		Scanner sc = new Scanner(System.in);
		int choice;
		int position;
		Node<String> node = null;
		String input = new String();

		do {
			System.out.println("1) Creation of linked list");
			System.out
					.println("2) Add the particular item in the linked list at the particular location");
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
				System.out
						.println("Enter a generic value to create a linked list");
				String dataFirst = sc.next();
				String dataSecond = sc.next();
				node = object.createDoublyLinkedList(dataFirst, dataSecond);
				System.out.println("After node creation");
				object.display(node);
				break;

			case 2:

				System.out.println("Enter a string to be inserted");
				input = sc.next();
				System.out.println("Enter position of string to be inserted");
				position = sc.nextInt();
				System.out.println("After inserting at required position");
				node = object.insertAtPosition(input, position, node, object.calculateLength(node));
				object.display(node);

				break;

			case 3:
				System.out.println("Enter string to be deleted");
				node = object.deleteAtValue(node, sc.next(), object.calculateLength(node));
				object.display(node);
				break;

			case 4:
				System.out.println("Enter position of string to be deleted");
				position = sc.nextInt();
				System.out.println("After deleting at required position");
				node = object.deleteAtPosition(position, node, object.calculateLength(node));
				object.display(node);
				break;

			case 5:
				System.out.println("To retrieve at a particular position");
				System.out.println("Enter position of string to be retrieved");
				position = sc.nextInt();
				String str = object.retrieveAtPosition(position, node);
				System.out.println(str);
				break;
			case 6:
				System.out.println("Reverse Linked list");
				node = object.reverseDoublyLinkedList(node,object.calculateLength(node));
				System.out.println("Reverse Linked list");
				object.display(node);
				break;
			case 7:
				System.out.println("Sorting Linked list");
				node = object.sort(node);
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
