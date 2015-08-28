package Session3;


/**
 * @author Deepali
 *
 * @param <T> :Generic Type
 */
public class TreeOperations<T> {

	String result = ""; 

	
	/** To start inserting from left child
	 * @param node :starting node
	 * @param element :element to insert
	 * @return :starting node 
	 */
	public Node<T> insertLeft(Node<T> node, int element) {
		if (node == null) {
			node = new Node<T>(element);
		}

		else {
			if (node.data > element) {

				node.left = insertLeft(node.left, element);
			} else {
				node.right = insertLeft(node.right, element);
			}
		}
		return node;
	}

	/** To start inserting from right child
	 * @param node :starting node
	 * @param element :element to insert
	 * @return :starting node 
	 */
	public Node<T> insertRight(Node<T> node, int element) {
		if (node == null) {
			node = new Node<T>(element);
		}

		else {
			if (node.data < element) {

				node.left = insertRight(node.left, element);
			} else {
				node.right = insertRight(node.right, element);

			}
		}
		return node;
	}

	
	/**To check for mirror image
	 * @param root :starting root
	 * @return :returning result
	 */
	public String mirrorImageOfTree(Node<T> root) {
		if (root != null) {
			mirrorImageOfTree(root.left);
			result = result + root.data;
			mirrorImageOfTree(root.right);
		}
		return result;

	}

}
