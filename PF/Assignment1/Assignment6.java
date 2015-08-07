package Assignments;

import java.util.Scanner;

/**
 * @author Deepali
 *Write a program to join two sorted arrays and generate third sorted array.
 *int[] join(int a[], int asize, int b[], int bsize, int c[])
 *asize is number of elements in array a , bsize is number of elements in array b
 *Assume array c has sufficient space to store elements. Do not sort array c explicit.
 *Write JUnit test cases using a method which takes two arrays as input and return true or false for asserting.
 */
public class Assignment6 {

	/**
	 * @param array1 :contains one sorted array
	 * array2 :contains one sorted array
	 * array3: by merging two above sorted array
	 */
	public static void main(String[] args) {
		
		int array1[],array2[],array3[];
		
		System.out.println("Enter size of the array arrival time");
		Scanner sc=new Scanner(System.in);
		int array1length=sc.nextInt();
		System.out.println("Enter size of the array job size");
		int array2length=sc.nextInt();
		array1=new int[array1length];
		System.out.println("Enter Arrival time");
		for(int i=0;i<array1length;i++)
		{
			array1[i]=sc.nextInt();
		}
		array2=new int[array2length];
		System.out.println("Enter job sizes");
		for(int i=0;i<array2length;i++)
		{
			array2[i]=sc.nextInt();
		}
		array3=new int[array2length+array1length];
		array3=join(array1,array1length,array2,array2length,array3);
		
		System.out.println("Joined array is");
		for(int i=0;i<array3.length;i++)
		{
			System.out.println(array3[i]+"  ");
		}
	}
	
	/**
	 * @param a :receiving array1
	 * @param asize :array1 size
	 * @param b :receiving array2
	 * @param bsize :array2 size
	 * @param c : array where merging of arrays stored
	 * @return : returning merged sorted array
	 */
	static int[] join(int a[], int asize, int b[], int bsize, int c[]){
		int i=0,j=0,k=0;
		c=new int[bsize+asize];
		while(i<asize&& j<bsize)//Merging sorted array
		{
			if(a[i]<=b[j]){
				c[k]=a[i];
				i++;
				k++;
			}
			else{
				c[k]=b[j];
				j++;
				k++;	
			}
		}
		if(i>=asize){//if array1 is finished
			while(j<bsize){
				c[k]=b[j];
				j++;
				k++;	
			}
		}
		if(j>=bsize){////if array2 is finished
			while(i<asize){
				c[k]=a[i];
				i++;
				k++;	
			}
		}
		return c;
		
	}

}
