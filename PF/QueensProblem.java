/**
 * N Queens Problem - The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other. (Thus, a solution requires that no two queens share the same row, column, or diagonal)
Boolean  nQueen(int[][], int startRow, int dimensionOfMatrix);
int [][] board = new int [][] {
             { 0,  0,  0,  0},
              { 0,  0,  0,  0},
              { 0,  0,  0,  0},
              { 0,  0,  0,  0} };

Boolean result = nQueen(board , 0, 4);
Where result should be true and board should have following content. 

Following is a solution for 4 Queen problem.	
NQueen

The expected output is a binary matrix which has 1s for the blocks where queens are placed. For example following is the output matrix for above 4 queen solution.

             { 0,  1,  0,  0}
              { 0,  0,  0,  1}
              { 1,  0,  0,  0}
              { 0,  0,  1,  0}

Write JUNIT Test Case for above problem
 */
package Assignment4;
import java.util.*;

/**
 * @author Deepali
 *
 */
public class QueensProblem {

private	static int[] Board; //Representing the Chess Board whwre queens are to be placed
private	int array1[][];
private	int queens;//No. Of Queens

public QueensProblem(int queens) {
	Board = new int[queens];
  }
	public static void main(String[] args) {
		
		System.out.println("Enter queens");
    	Scanner sc=new Scanner(System.in);
    	
        QueensProblem Q = new QueensProblem(sc.nextInt());
        if((Q.queens==2)||(Q.queens==3))//FOr 2 and 3 queens not possible
       	{
       	System.out.println("Please enter right values");
       	}
        else{
        	//Q.Solution=new int[2*Q.queens][Q.queens];
        	//Q.Solution=Q.placeNqueens(0, Board.length);	
        	Q.placeNqueens(0, Board.length);
        	
        	/* for(int i=0;i<Q.Solution.length;i++){
        		 for(int j=0;j<Q.Solution.length;j++){
        			 System.out.print(Q.Solution[i][j]+"  ");
          	   }
        		 System.out.println();
             }*/
        }
        
        sc.close();  
	}
	
	/**
	 * @param Board :An array where queen are to placed
	 * @return:Solution of Queen problem
	 */
	public int[][] printQueens(int[] Board) {
        int N = Board.length;
        int array[][]= new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Board[i] == j) {
                   System.out.print(" 1 ");
                    array[i][j]='1';
                } else 
                {
                    System.out.print(" 0 ");
                    array[i][j]='0';
                }
            }
            System.out.println();
        }
       System.out.println();
       return array;
    }
	
	/**
     * Returns TRUE if a queen can be placed in row r and column c.
     * Otherwise it returns FALSE. x[] is a global array whose first (r-1)
     * values have been set.
     */
	public boolean canPlaceQueen(int r, int c) {
        
        for (int i = 0; i < r; i++) {
            if (Board[i] == c || (i - r) == (Board[i] - c) ||(i - r) == (c - Board[i])) //For common row and column and Diagonal
            {
                return false;
            }
        }
        return true;
	}
	
	/**
     * Using backtracking this method prints all possible placements of n
     * queens on an n x n chessboard so that they are non-attacking.
     */
	public int[][] placeNqueens(int r, int n) 
	{
 	  for (int c = 0; c < n; c++) {
        if (canPlaceQueen(r, c)) {
            Board[r] = c;
            if (r == n - 1) {
                array1=printQueens(Board);
                return array1;
            } 
            else {
                placeNqueens(r + 1, n);
            }
        }
    }
    return array1;
  }
}
