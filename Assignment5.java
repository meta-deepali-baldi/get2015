package Assignments;

import java.util.Scanner;

public class Assignment5 {

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
	static int checkingorderofarray(int input[]){
		int count1=0,count2=0;
		for(int i=0;i<input.length-1;i++)
		{
			if(input[i+1]>=input[i]){
				count1++;	
			}
			else
				break;
		}
		for(int i=0;i<input.length-1;i++)
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
		else
			return 0;
		
	}

}
