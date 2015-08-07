package Assignments;
import java.util.*;
public class ConvertBinaryToOctal{
	int binNum, octNum;
	public static void main(String[] args) {
		ConvertBinaryToOctal c1=new ConvertBinaryToOctal();
		System.out.println("Binary Number");
		Scanner sc=new Scanner(System.in);
		c1.binNum=sc.nextInt();
		c1.octNum=c1.convertBinaryToOctal(c1.binNum);
		System.out.println("Octal Number"+c1.octNum);
		

	}
	 int convertBinaryToOctal(int n)
	{
		int octal,count,rem, rem1,rem2,actual=0;
		do{
			rem=n%1000;
			rem2=rem;
			count=0;
			
			do{
				
				count++;
				rem2=rem2/10;
			}while(rem2!=0);
			 octal=0;
			for(int i=0;i<count;i++){
				rem1=rem%10;
				octal=octal+ rem1*(int)Math.pow(2,i);
				rem=rem/10;
			
			}
		actual=actual*10+octal;
		
			n=n/1000;
	
		}while(n!=0);
		octal=0;
		while(actual!=0)
		{
			rem=actual%10;
			octal=octal*10+rem;
			actual=actual/10;
		}
		 return octal;
		
	}
}