package Assignments;

import java.util.Scanner;

/**
 * @author Deepali
 * 1 2 3 4 5 
     1 2 3 4 
       1 2 3 
         1 2 
           1
Write a program to display above structure using modular approach. 
Divide whole problem in 3 parts as per describe in the presentation.
1. spaces(row, n): return the spaces string
2. numbers(row, n): return the number string
3. print whole pyramid : It will return the array of string by using above 2 functions.
Also write JUnit test cases for each modules.
 */
public class Assignment22 {

	/**
	 * @param number: It denote number for which pyramid is created
	 */
	public static void main(String[] args) {
		int num;
		Assignment22 a1=new Assignment22();
		System.out.println("enter the Number");
		Scanner sc=new Scanner(System.in);
		num=sc.nextInt();
		String s4[]=a1.printWholePyramid(num);
		for(int i=0;i<s4.length;i++)
			System.out.println(s4[i]);
		
	}
	
	/**
	  @param row :row of the Structure
	 * @param n   :The value for which Structure we have to create
	 * @return :string of space
 */
	String spaces(int row,int n){
		String s1="";
		for(int i=1;i<row;i++){
			s1=s1+" ";
		}
		//System.out.println("hello"+s1+"hello");
		return s1;
		
	}
	
	String number(int row,int n){
		String s1="";
		for(int i=1;i<n-row+2;i++){
			s1=s1+i;
		}
		return s1;
		
	}
	
	/**
	  @param row :row of the Structure
	 * @param n   :The value for which Structure we have to create
	 * @return :string of numbers
*/
	
	String[] printWholePyramid(int n)
	{
		String s1="",s2="";
String s3[]=new String[n];
		for(int i=1;i<=n;i++){
			s1=spaces(i,n);
			s2=number(i,n);
			s3[i-1]=s1+s2;
		}
		return s3;
	}

}
