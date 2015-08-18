/**
 * Assignment 1: Matrix Class Implement Matrix Class as discussed in session.
 *  Write proper unit test for addElements, transpose, show methods. 
 */
package Assignment5;

import java.util.Scanner;

/**
 * @author Deepali
 * 
 */
public class Matrix {
	int data[][];// denote the matrix
	int noRows;// No. of Rows of Matrix
	int noCols;// No. of Column of Matrix

	public Matrix(int row, int col) {// Parameterized Constructor Setting row
										// and column and Creating array
		this.noRows = row;
		this.noCols = col;
		data = new int[row][col];
	}

	/**
	 * @param row :row of matrix
	 * @param col :Column Of Matrix
	 * @param val :Value to be set at this Location in Matrix
	 */
	public void addElements(int row, int col, int val) {// To add Elements
		data[row][col] = val;
	}

	/**
	 * @return Transpose of the Matrix
	 */
	public Matrix transpose() {// To transpose Matrix
		Matrix transposeMatrix = new Matrix(noCols, noRows);
		for (int i = 0; i < transposeMatrix.noRows; i++) {
			for (int j = 0; j < transposeMatrix.noCols; j++) {
				transposeMatrix.data[i][j] = data[j][i];
			}
		}
		return transposeMatrix;

	}

	public void show() {// logic to display
		for (int i = 0; i < noRows; i++) {
			for (int j = 0; j < noCols; j++) {
				System.out.print(data[i][j] + "  ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {// Main Function
		Scanner sc = new Scanner(System.in);
		// Taking Information
		System.out.println("Enter rows of Matrix");
		int rowInput = sc.nextInt();
		System.out.println("Enter column of Matrix");
		int columnInput = sc.nextInt();
		// Setting Value
		Matrix matrix = new Matrix(rowInput, columnInput);
		System.out.println("Enter values in Matrix");
		for (int i = 0; i < matrix.noRows; i++)// Getting Value
		{
			for (int j = 0; j < matrix.noCols; j++) {
				matrix.addElements(i, j, sc.nextInt());
			}
			System.out.println();
		}
		Matrix m2 = matrix.transpose();// Transpose
		m2.show();// display
		sc.close();
	}

}
