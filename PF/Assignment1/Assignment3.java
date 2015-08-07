package Assignments;

import java.util.Scanner;

/**
 * @author Deepali
 *Write a program to find longest increasing sequence from an array of n integer values
 *Input:
 *Given Array: [1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9]
 *Output:
 *Resultant Array: [1, 2,4,5,6,7,8,9]
 *method name : int[] longestSequence(int input[])
 *Write JUnit test cases which will assert the array return from the above method and the expected array.
 */
public class Assignment3 {
static int count2=0,count=0,count3=0,greater=0;
	public static void main(String[] args) {
		int array1[],array2[];
		System.out.println("Enter size of the array");
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		array1=new int[size];
		
		System.out.println("Enter Elements of array");
		for(int i=0;i<size;i++)
		{
			array1[i]=sc.nextInt();
		}
		array2=new int[size];
		
		array2=longestSequence(array1);
		System.out.println("Longest Sequence is");
		for(int i=0;i<greater+1;i++)
		{
			System.out.print(array2[i]+"  ");
		}
	}
	
	/**
	 * @param input : receiving integer array1
	 * @return :returning an array containing longest sequence
	 */
	static int[] longestSequence(int input[]){
		int input2[]; //Array for storing Longest Sequence
		int i,j=0;
		for( i=0;i<input.length-1;i++){
				if(input[i+1]-input[i]>0)//for checking increasing sequence
				{
					count++;
				}
				else if(greater<=count){//for keeping track of greater sequence
					greater=count;
					count=0;
					count3=count2;
					count2=i;	
				}else
				{
					count=0;
				}
				
		}
		if(greater<count){
				greater=count;
				count=0;
				count3=count2+1;
				count2=i;
		}
		input2=new int[input.length];
		
		for(i=count3;i<=count2;i++){//for storing sequence in new array
				input2[j]=input[i];
				j++;
		}
		return input2;
	}
}
