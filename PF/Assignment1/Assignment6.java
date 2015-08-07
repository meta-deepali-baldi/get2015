package Assignments;

import java.util.Scanner;

public class Assignment6 {

	public static void main(String[] args) {
		int array1[],array2[],array3[];
		System.out.println("Enter size of the array arrival time");
		Scanner sc=new Scanner(System.in);
		int alength=sc.nextInt();
		System.out.println("Enter size of the array job size");
		int blength=sc.nextInt();
		array1=new int[alength];
		System.out.println("Enter Arrival time");
		for(int i=0;i<alength;i++)
		{
			array1[i]=sc.nextInt();
		}
		array2=new int[blength];
		System.out.println("Enter job sizes");
		for(int i=0;i<blength;i++)
		{
			array2[i]=sc.nextInt();
		}
		array3=new int[blength+alength];
		array3=join(array1,alength,array2,blength,array3);
		System.out.println("Joined array is");
		for(int i=0;i<array3.length;i++)
		{
			System.out.println(array3[i]+"  ");
		}
	}
	static int[] join(int a[], int asize, int b[], int bsize, int c[]){
		int i=0,j=0,k=0;
		c=new int[bsize+asize];
		while(i<asize&& j<bsize)
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
		if(i>=asize){
			while(j<bsize){
				c[k]=b[j];
				j++;
				k++;	
			}
		}
		if(j>=bsize){
			while(i<asize){
				c[k]=a[i];
				i++;
				k++;	
			}
		}
		return c;
		
	}

}
