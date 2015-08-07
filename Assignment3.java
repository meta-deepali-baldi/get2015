package Assignments;

import java.util.Scanner;

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
		
		for(int i=0;i<greater+1;i++)
		{
			System.out.print(array2[i]+"  ");
		}
	}
	static int[] longestSequence(int input[]){
		int input2[];
		int i,j=0;
		for( i=0;i<input.length-1;i++){
				if(input[i+1]-input[i]>0){
				count++;
				}
				else if(greater<=count){
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
		 System.out.println(count3+",,,,,"+count2);
		 for(i=count3;i<=count2;i++){
			 input2[j]=input[i];
			 j++;
		 }
		return input2;
	}
}
