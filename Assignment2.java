package Assignments;

import java.util.Scanner;

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
		for(int i=0;i<size-count;i++)
		{
			System.out.println(array2[i]+"  ");
		}
	}
	static int[] removeDuplicate(int input[]){
	int k=0;
		for(int i=0;i<input.length;i++){
			for(int j=i+1;j<input.length-count;j++){
				
				if(input[i]==input[j])
				{count++;
				
				System.out.println("count="+count);
				for( k=j;k<input.length-count;k++){
					input[k]=input[k+1];
					}
				j=j-1;
				
			}
			
		}
		
		}
		for(int w=count;w>0;w--){
			input[input.length-w]=0;
		}
		return input;
		
	}
}
