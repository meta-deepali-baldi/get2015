package Session8;

/**
 * @author Deepali
 */
class BinaryTreeTraversal {
	private Node root; //root node of tree
	private String result; //for storing inorder

	/**
	 * constructor
	 */
	public BinaryTreeTraversal() {
		root = null;
		result="";
	}

	/** inserting element ono by one
	 * @param element :element to insert
	 */
	public void insert(int element) {
		root = insert(root, element);
	}

	
	/**
	 * To insert an element
	 * @param node :starting root node
	 * @param element :element to be entered
	 * @return :return starting node
	 */
	private Node insert(Node node, int element) {
		if (node == null) {
			node = new Node(element);
		}

		else {
			if (node.data > element) {

				node.left = insert(node.left, element);
			} else if(node.data < element)  {
				node.right = insert(node.right, element);
			}
		}
		return node;
	}


	/**
	 * To traverse in Inorder
	 */
	public String printRollNumberInAscendingOrder() {
		return inorderTraversal(root);
	}

	/**inorder traversal
	 * @param root :starting root
	 * @return :returning inorder of tree
	 */
	private String inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			result = result + "   "+ root.data;
			inorderTraversal(root.right);
		}
		return result;

	}

}