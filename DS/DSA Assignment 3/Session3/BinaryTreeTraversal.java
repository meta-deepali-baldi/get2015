package Session3;

/**
 * @author Deepali
 *
 * @param <T>
 *            :generic Type
 */
class BinaryTreeTraversal<T> {
	private Node<T> root;
	String result;

	public BinaryTreeTraversal() {
		root = null;
	}

	public void insert(int element) {
		root = insert(root, element);
	}

	/**
	 * To insert an element
	 * 
	 * @param node
	 *            :starting root node
	 * @param element
	 *            :element to be entered
	 * @return :return starting node
	 */
	private Node<T> insert(Node<T> node, int element) {
		if (node == null) {
			node = new Node<T>(element);
		}

		else {
			if (node.data > element) {

				node.left = insert(node.left, element);
			} else {
				node.right = insert(node.right, element);
			}
		}
		return node;
	}

	/**
	 * To traverse in pre order
	 */
	public void traversePreorder() {
		traversePreorder(root);
	}

	/**
	 * @param rootNode
	 *            root node
	 */
	private void traversePreorder(Node<T> rootNode) {
		if (rootNode != null) {
			System.out.print(rootNode.data + ",");
			traversePreorder(rootNode.left);
			traversePreorder(rootNode.right);
		}
	}

	/**
	 * To traverse in post order
	 */
	public void traversePostorder() {
		traversePostorder(root);
	}

	/**
	 * @param rootNode
	 *            :root node
	 */
	private void traversePostorder(Node<T> rootNode) {
		if (rootNode != null) {
			traversePostorder(rootNode.left);
			traversePostorder(rootNode.right);
			System.out.print(rootNode.data + ",");
		}
	}

	/**
	 * To traverse in Inorder
	 */
	public String traverseInorder() {
		return inorderTraversal(root);
	}

	/**inorder traversal
	 * @param root :starting root
	 * @return :returning result
	 */
	public String inorderTraversal(Node<T> root) {
		if (root != null) {
			inorderTraversal(root.left);
			result = result + root.data;
			inorderTraversal(root.right);
		}
		return result;

	}

}