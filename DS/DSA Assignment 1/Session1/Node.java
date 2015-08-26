package Session1;

/**
 * @author Deepali
 *
 * @param <T> : generic Type
 */
public class Node<T> {
	public T nodeValue;//value on node
	public Node<T> next;//Pointer to next node

	Node() {
		nodeValue = null;
		next = null;
	}

	Node(T item) {//Parameterized constructor
		nodeValue = item;
		next = null;
	}

}
