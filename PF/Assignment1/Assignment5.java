package Assignments;

import java.util.Scanner;

/**
 * @author Deepali
 *Write a function to check given array is in sorted order or not. Function should return 1 if array is in ascending order, 2 if array is in descending order, 0 if array is not in sorted
 *Use this function and write a program to display appropriate message based on return value of above function.
 *Also write JUnit test cases which takes an integer array as input and assert return value.
 *Write Junit Test cases for all above 3 cases.
 */
public class Assignment5 {

	/**
	 * @param array :Array whose order is to be checked
	 * size : size of this array
	 */
	public static void main(String[] args) {
		int array[];
		int size;
		System.out.println("Enter size of the array");
		Scanner sc=new Scanner(System.in);
		size=sc.nextInt();
		array=new int[size];
		System.out.println("Enter Elements of array");
		for(int i=0;i<size;i++)
		{
			array[i]=sc.nextInt();
		}
		int result=checkingorderofarray(array);
		if(result==1)
			System.out.println("Array is in ascending order");
		else if(result==2)
			System.out.println("Array is in descending order");
		else
			System.out.println("Array is not in sorted order");
			

	}
	
	/**
	 * @param input : receiving array for checking order
	 * @return : an integer value is returned
	 */
	static int checkingorderofarray(int input[]){
		int count1=0,count2=0;
		for(int i=0;i<input.length-1;i++)//for checking Ascending array
		{
			if(input[i+1]>=input[i]){
				count1++;	
			}
			else
				break;
		}
		for(int i=0;i<input.length-1;i++)//for checking Descending array
		{
			if(input[i+1]<=input[i]){
				count2++;	
			}
			else
				break;
		}
	
		if(count1==input.length-1)
		return 1;
		else if(count2==input.length-1)
			return 2;
		else  // for checking not sorted array
			return 0;
		
	}

}
