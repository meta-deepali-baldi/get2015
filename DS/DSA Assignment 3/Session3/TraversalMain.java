/**
 * Q1. WAP to traverse a binary tree in preorder and print the nodes as they are traversed.
 * Q3. WAP to traverse a binary tree in postorder and print the nodes as they are traversed.
 */
package Session3;

import java.util.Scanner;

/**
 * @author Deepali
 *
 */
public class TraversalMain {

	public static <T> void main(String args[]) {
		int ch, element;
		int choice;
		Scanner scan = new Scanner(System.in);
		BinaryTreeTraversal<Object> tree = new BinaryTreeTraversal<Object>();
		do {
			System.out.println("Menu");
			System.out.println("1.Insert");
			System.out.println("2. Pre Order traversal");
			System.out.println("3. Post Order traversal");
			System.out.println("Enter choice");
			do {// Validation

				while (!scan.hasNextInt()) {
					System.out
							.println("That's not a number!Please enter again");
					scan.next(); // this is important!
				}
				choice = scan.nextInt();
			} while (choice <= 0);
			switch (choice) {
			case 1:// To input an element
				System.out.println("Insert an element");
				element = scan.nextInt();
				tree.insert(element);
				break;

			case 2:// For pre order display
				System.out.println("Pre order display");
				tree.traversePreorder();
				break;

			case 3:// For post order display
				System.out.println("Post order display");
				tree.traversePostorder();
				break;

			case 4:// For Inorder display
				System.out.println("Inorder display");
				System.out.println(tree.traverseInorder());
				break;

			default:// default case
				System.out.println("Enter correct choice");
				break;
			}
			do {// validation
				System.out.println("Do you want to continue(Y/N)"); // continuing
																	// the
																	// procedure
				while (!scan.hasNext()) {
					System.out.println("That's not a character!");
					scan.next(); // this is important!

				}
				ch = scan.next().toUpperCase().charAt(0);
				if (ch == 'N')
					System.exit(0);
			} while (ch != 'Y');

		} while (ch == 'Y');
		scan.close();
	}
}
