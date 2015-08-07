package Assignments;

import java.util.Scanner;

/**
 * @author Deepali
 *Write a program which remove duplicate elements from an unsorted Array eg.
 *Input:
 *Given Array: [2,5,4,6,3,8,5,9,3,3,6,3,9,0]
 *Output:Resultant Array:[2,5,4,6,3,8,9,0]
 *Method name : int[] removeDuplicate(int input[])
 *Write JUnit test cases which will assert the array return from the above method and the expected array.
 */
public class Assignment2 {
static int  count=0;
	public static void main(String[] args) {
		int array1[],array2[];
		
		System.out.println("Enter size of the array");
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		array1=new int[size];
		array2=new int[size];
		System.out.println("Enter Elements of array");
		for(int i=0;i<size;i++)
		{
			array1[i]=sc.nextInt();
		}
		array2=removeDuplicate(array1);
		System.out.println("array without duplicate Elements");
		for(int i=0;i<size-count;i++)
		{
			System.out.println(array2[i]+"  ");
		}
	}
	
	/**
	 * @param input : Integer Array which is receiving duplicate element array
	 * @return :returning an integer array with no duplicate element
	 */
	static int[] removeDuplicate(int input[]){
		int k=0;
		for(int i=0;i<input.length;i++){
			for(int j=i+1;j<input.length-count;j++){
				
				if(input[i]==input[j])//Checking Duplicate Elements
				{
					count++;
					System.out.println("count="+count);
					for( k=j;k<input.length-count;k++){//for Shifting Elements if found any Duplicate
						input[k]=input[k+1];
					}
					j=j-1;
				}
			}
		}
		for(int w=count;w>0;w--){//replacing with zero at end of array as Duplicates are removed
			input[input.length-w]=0;
		}
		return input;
		
	}
}
