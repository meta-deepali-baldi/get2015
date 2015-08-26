package DoublyLinkedList;
/**
 * @author Deepali
 *
 * @param <T> : generic Type
 */
public class Node<T> {
	public T nodeValue;//value on node
	public Node<T> next;//Pointer to next node
	public Node<T> prev;//Pointer to previous node

	Node() {
		nodeValue = null;
		next = null;
		prev = null;
	}

	Node(T item) {//Parameterized constructor
		nodeValue = item;
		next = null;
		prev = null;
	}

}

