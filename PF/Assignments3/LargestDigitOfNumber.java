/**Write recursive functions for the following
 *c) int largestdigit(int x) where x >= 0,  to find out the largest digit in the number x.
 *Also, Write following JUnits cases:
 *largestdigit(2)
 *largestdigit(1257369)
 *largestdigit(444)
 */
package Assignments3;

import java.util.Scanner;

/**
 * @author Deepali
 * number: contains value whose largest digit to be find
 * largestDigit :contain largest digit of number
 */
public class LargestDigitOfNumber {
	private int flag=0;//used to store temporary value
	public static void main(String[] args) {
		int number,largestDigit,temp;
		LargestDigitOfNumber largestDigitOfNumber=new LargestDigitOfNumber();
		Scanner sc=new Scanner(System.in);
		
		do{
		System.out.println("enter Number:");
		number=sc.nextInt();
		if(number>=0) {//checking such that number must not be negative
			largestDigit=largestDigitOfNumber.largestDigit(number);
			System.out.println("Largest Digit of number is"+largestDigit);
		}
		else
			System.out.println("Enter Correct value");
		
		System.out.println("Press 1 if you want to exit");
		System.out.println("Press 0 if you want to continue");
		temp=sc.nextInt();
		largestDigitOfNumber.flag=0;
		}while(temp!=1);
	}

	/**Recursion method to find largest digit of a number
	 * @param x: receiving number to find largest digit
	 * @return :returning Largest Digit
	 */
	public int largestDigit(int x){
		int temp = 0;
		if(x==0){//if their is no digit
			return flag;
		}
		else if(x>0)
		{
			temp=x%10;																																																																																																																																					temp=x%10;
		if(flag<temp){//for storing larger digit
			flag=temp;
		}
		x=x/10;
		flag=largestDigit(x);	//Recursive Function
		}
		return flag;
	}
}
