/**Write recursive functions for the following
 *b) int gcd(int x, int y) where x > 0 and y > 0, to compute the greatest common divisor of x and y. 
 *Also, Write following JUnits cases
 *gcd(2, 1)
 *gcd(12, 18)
 *gcd(100, 3)
 */
package Assignments3;

import java.util.Scanner;

/**
 * @author Deepali
 * number1 ,number2:number whose greatest common divisor calculated
 * result :contains greatest common divisor
 */
public class GreatestCommonDivisor {

	public static void main(String[] args) {
	int number1,number2,result,temp;
	GreatestCommonDivisor commonDivisor=new GreatestCommonDivisor();
	Scanner sc=new Scanner(System.in);
	
	do{
	System.out.println("enter First Number:");
	number1=sc.nextInt();
	System.out.println("enter Second Number:");
	number2=sc.nextInt();
	if(number1>0 && number2>0) {//checking such that number1 and number2 must not be negative
		if(number1<number2){//to keep greater number in number1
			temp=number1;
			number1=number2;
			number2=temp;
		}
		result=commonDivisor.greatestCommonDivisor(number1,number2);
		System.out.println("GreatestCommonDivisor is "+result);
	}
	else
		System.out.println("Enter Correct value");
	
	System.out.println("Press 1 if you want to exit");
	System.out.println("Press 0 if you want to continue");
	temp=sc.nextInt();
	}while(temp!=1);
	}
	
	/**Recursive function to calculate GreatestCommonDivisor
	 * @param x : receives first number
	 * @param y :receives second number
	 * @return :returns GreatestCommonDivisor
	 */
	public int greatestCommonDivisor(int x, int y){
		int temp;
		while(x%y!=0){//loop works until remainder is not equal to zero
			 x=x%y;
			 //Swapping of numbers
			 temp=x;
			 x=y;
			 y=temp;
			 y=greatestCommonDivisor(x,y);
		}
		return y;
		
	}	
}
