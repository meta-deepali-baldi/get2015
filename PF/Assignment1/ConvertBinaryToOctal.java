package Assignments;
import java.util.*;

/**
 * @author Deepali
 *
 *Write a function (int convertBinaryToOctal(int n) )to convert binary numbers to octal eg.

	      Input:

Binary Number: 110101

	     Output:

Octal Number:  65

Also write JUnit test cases which takes above input and assert octal number.
 */
/**
 *binaryNumber :Binary number
 *octalNumber  :Octal Number
 */
public class ConvertBinaryToOctal{
	int binaryNumber, octalNumber;
	
	public static void main(String[] args) {
		ConvertBinaryToOctal c1=new ConvertBinaryToOctal();
		System.out.println("Binary Number");
		Scanner sc=new Scanner(System.in);
		c1.binaryNumber=sc.nextInt();
		c1.octalNumber=c1.convertBinaryToOctal(c1.binaryNumber);
		System.out.println("Octal Number"+c1.octalNumber);
		

	}
	 /**
	 * @param n : which is receiving value of Binary Number
	 * @return : Octal Number is returned
	 */
	int convertBinaryToOctal(int n)
	{
		int octal,count,rem, rem1,rem2,actual=0;
		do{
			rem=n%1000;
			rem2=rem;//containing three digits from octal no.
			count=0;
			
			do{
			// for counting no of digits in three digit combination	
				count++;
				rem2=rem2/10;
			}while(rem2!=0);
			octal=0;
			for(int i=0;i<count;i++){
				rem1=rem%10;
				octal=octal+ rem1*(int)Math.pow(2,i);//for converting it in binary
				rem=rem/10;
			}
		    actual=actual*10+octal;//creating octal no.
	        n=n/1000;
	
		}while(n!=0);
		octal=0;
		while(actual!=0)//for reversing the digits
		{
			rem=actual%10;
			octal=octal*10+rem;
			actual=actual/10;
		}
		return octal;
		
	}
}
