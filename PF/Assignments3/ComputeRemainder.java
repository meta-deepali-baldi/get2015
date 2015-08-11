/**
 *1. 
 *Write recursive functions for the following:
 *int rem(int x, int y) where x >=0 and y > 0, to compute the remainder of x divided by y.
 *Also, Write following JUnits cases:
 *rem(2, 1)
 *rem(2, 0)
 *rem(100, 3)
 */

package Assignments3; 

import java.util.Scanner;

/**
 * @author Deepali
 */
public class ComputeRemainder {
private int divisor,dividend,remainder;
	public static void main(String[] args) {
		int temp=0;
		ComputeRemainder computeRemainder= new ComputeRemainder();
		Scanner sc=new Scanner(System.in);
		do{
		System.out.println("enter First Number:");
		computeRemainder.dividend=sc.nextInt();
		System.out.println("enter Second Number:");
		computeRemainder.divisor=sc.nextInt();
		
		if(computeRemainder.divisor>=0 && computeRemainder.dividend>0) {//checking such that dividend and divisor must not be negative
			computeRemainder.remainder=computeRemainder.rem(computeRemainder.dividend,computeRemainder.divisor);
			System.out.println("Remainder is"+computeRemainder.remainder);
		}
		else
			System.out.println("Enter Correct value");
		
		System.out.println("Press 1 if you want to exit");
		System.out.println("Press 0 if you want to continue");
		temp=sc.nextInt();
		}while(temp!=1);
	}
	
	/**recursive function to calculate remainder
	 * @param x:recieving dividend value
	 * @param y:recieving divisor value
	 * @return :
	 */
	public int rem(int x, int y){
		while(x>=y){
			x=x-y;
			x=rem(x,y);
 		}
		return x;
	}


}
