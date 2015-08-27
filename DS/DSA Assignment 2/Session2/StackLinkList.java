package Session2;

/**
 * @author Deepali
 *
 */
public class StackLinkList {
	protected static StackNode start;
	protected static StackNode end;
	public static int size;

	
	/**Pushing element into the stack
	 * @param item :Element to be entered in stack
	 */
	public static void push(String item) {
		StackNode newNode = new StackNode(item);
		size++;
		if (start == null) {
			start = newNode;
			end = start;
		} else {
			newNode.setLink(start);
			start = newNode;
		}

	}

	/** Pop Element from stack
	 * @return :return element which is deleted
	 */
	public static String pop() {
		String string = start.data;
		start = start.getLink();
		size--;
		return string;
	}

	/**
	 * @return : Return the element which is a top of stack
	 */
	public static String peek() {
		String string = start.data;

		return string;
	}

	/**
	 * @param ch :character to be checked whether it is alpha numeric or not
	 * @return :return true if alpha numeric else false
	 */
	boolean isAlpha(char ch) {
		if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
			return true;
		else
			return false;

	}

	/**
	 * @param c :checking whether the entered character is operator or not
	 * @return :returning true if operator
	 */
	private boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
			return true;
		return false;
	}

	/**
	 * Name: checkPrecedence
	 * checking whether precedence of c1 should not be greater than c2
	 * @param c1 : operator first
	 * @param c2 : operator second
	 * @return Description: checks the precedence
	 **/
	private boolean checkPrecede(char c1, char c2) {
		if ((c2 == '+' || c2 == '-') && (c1 == '+' || c1 == '-')) {
			return true;
		} else if ((c2 == '*' || c2 == '/')
				&& (c1 == '+' || c1 == '-' || c1 == '*' || c1 == '/')) {
			return true;
		}

		else {
			return false;
		}
	}

	/**Description: Converts infix expression to postfix
	 * @param infix : String to be converted to postfix
	 * @return :postfix string
	 **/
	public String convertFromInfixToPostfix(String infix) {

		String postfix = ""; // equivalent postfix is empty initially stack to hold symbols

		push("#"); // symbol to denote end of stack
		for (int i = 0; i < infix.length(); i++) {

			char inputSymbol = infix.charAt(i); // symbol
			if (isOperator(inputSymbol)) {
				while (checkPrecede(inputSymbol, peek().charAt(0))) {
					postfix += pop();
				}
				push(Character.toString(inputSymbol));
			} else if (inputSymbol == '(') {
				push(Character.toString(inputSymbol)); // push if left
														// parenthesis
			} else if (inputSymbol == ')') {

				while (!peek().equals("(")) { // repeatedly pops if right
												// parenthesis until left
												// parenthesis is found
					postfix += pop();
				}
				pop();
			} else {
				postfix += inputSymbol;
			}
		}

		while (!peek().equals("#")) // pops all elements of stack left
		{
			postfix += pop();
		}
		return postfix;
	}

	/**
	 * Displays elements in stack
	 */
	public void display() {

		System.out.print("\nStack contains = \n");
		if (size == 0) {
			System.out.println("empty\n");
			return;
		}
		
		if (start.getLink() == null) {
			System.out.println(start.getData());
			return;
		}
		
		StackNode ptr = start;
		System.out.println(start.getData());
		ptr = start.getLink();
		while (ptr.getLink() != null) {
			System.out.println(ptr.getData());
			ptr = ptr.getLink();
		}
		System.out.println(ptr.getData() + "\n");

	}

}
