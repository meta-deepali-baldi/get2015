package Session3;
/**
 * @author Deepali
 *
 * @param <T> :Generic Type
 */
public class Node<T> {
	int data; //Data in node
	Node<T> left, right;

	Node() {
		data = 0;
		left = null;
		right = null;
	}

	Node(int element) {//Parameterized Constructor
		data = element;
		left = null;
		right = null;
	}

}

