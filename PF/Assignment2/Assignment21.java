package Assignments;

import java.util.Scanner;


/**
 * @author Deepali
 * 	     1
       1 2 1
     1 2 3 2 1
   1 2 3 4 3 2 1
 1 2 3 4 5 4 3 2 1
   1 2 3 4 3 2 1
	 1 2 3 2 1
	   1 2 1
		 1

Write a program to display above pyramid using modular approach. 
Divide whole problem in 3 parts as per describe in the presentation.
1. spaces(row, n): return the spaces string
2. numbers(row, n): return the number string
3. print whole pyramid : It will return the array of string by using above 2 functions.
Also write JUnit test cases for each modules.
 */


public class Assignment21 {

	/**
	 * @param number: It denote number for which pyramid is created
	 */
	public static void main(String[] args) {
		int number;
		Assignment21 a1=new Assignment21();
		System.out.println("enter the Number");
		Scanner sc=new Scanner(System.in);
		number=sc.nextInt();
		String s4[]=a1.printWholePyramid(number);
		for(int i=0;i<s4.length;i++)
			System.out.println(s4[i]);
		
	}
	
	/**
	 * @param row :row of the pyramid
	 * @param n   :The value for which pyramid we have to create
	 * @return :string of space

	 */
	String spaces(int row,int n){
		String s1="";
		if(row<=n){//for upward pyramid
		for(int i=0;i<n-row;i++){
			s1=s1+" ";
		}
		}
		else//for downward pyramid
		{
			for(int i=0;i<row-n;i++){
				s1=s1+" ";
			}	
		}
		return s1;
		
	}
	
	/**
	 *@param row :row of the pyramid
	 * @param n   :The value for which pyramid we have to create
	 * @return :string of numbers
	 */
	String number(int row,int n){
		String s1="";
		int j=0;
		if(row<=n){//for upward pyramid
		for(int i=1;i<=row;i++){
			s1=s1+i;
		}
		for(int i=row-1;i>=1;i--)
		{
			s1=s1+i;
		}
		}
		else//for downward pyramid
		{
			
			j=j+2*(row-n);
			for(int i=1;i<=row-j;i++){
				s1=s1+i;
			
			}	
			for(int i=row-j-1;i>=1;i--){
				s1=s1+i;
			
			}	
			
		
		}
		return s1;
		
	}
	
	/**
	 *  @param n   :The value for which pyramid we have to create
	 * @return :s3 is array of String containing string of concatenation of spaces and numbers
	 */
	String[] printWholePyramid(int n)
	{
		String s1="",s2="";
                String s3[]=new String[(2*n)-1];
		for(int i=1;i<=2*n-1;i++){
			s1=spaces(i,n);
			s2=number(i,n);
			s3[i-1]=s1+s2;
		}
		return s3;
	}
}
