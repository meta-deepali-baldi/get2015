package Assignments;

import java.util.Scanner;

/**
 * @author Deepali
 *Write a java  function int [][]FCFS( int arrival_time [], int job_size[] , n) to simulate FCFS (First come First Server) scheduler of a machine.  First parameter represents list of jobs arrival time and second parameter represent length for respective job. Function should display wait time for each job for cpu cycle. Assume CPU cycle start with 1 for processing.  
 *Input:
 *Arrival_time [1, 5, 9, 25]
 *Job_size [12,7,2,5]
 *Output:

Job       job arrived time      Job wait time    Job Start at         Job finished at

1          1                               	0	           1                  	   12

2          5   	                 			8             13                       19

3          9                               11             20                       21

4          25                             	0             25                       29


Note: To create JUNIT Test Case for array problem , you need to create a sample function that will take 2 input ( first one will be expected 2D array and second input will be 2D array came after above function call)
isArrayEqual(int expected[][], int output[][])
Write JUnit test cases using a method which asserts on the return value of isArrayEqual method.
 */
public class Assignments4 {

	public static void main(String[] args) {
		
		int arrivalTime[],jobSize[];
		System.out.println("Enter size of the array arrival time");
		Scanner sc=new Scanner(System.in);
		
		int arrivalLength=sc.nextInt();
		System.out.println("Enter size of the array job size");
		
		int jobLength=sc.nextInt();
		arrivalTime=new int[arrivalLength];
		System.out.println("Enter Arrival time");
		for(int i=0;i<arrivalLength;i++)
		{
			arrivalTime[i]=sc.nextInt();
		}
		jobSize=new int[jobLength];
		System.out.println("Enter job sizes");
		for(int i=0;i<arrivalLength;i++)
		{
			jobSize[i]=sc.nextInt();
		}
		 Assignments4 a1=new Assignments4();
		 System.out.println(" job   job arrival   Time Job Waiting   Time Job Start   Time Job Finish Time");
		 int array3[][]=new int[jobLength][];
		 array3=a1.firstComeFirstServe(arrivalTime,jobSize,jobLength);
		 for(int i=0;i<jobLength;i++)
		 {
			 for(int j=0;j<5;j++)
				 {
				 System.out.print(array3[i][j]+"   ");
				 }
			 System.out.println();
		 }
	}
	/**
	 * @param arrivalTime :It receives arrivalTime array
	 * @param jobSize :It receives jobSize array
	 * @param n : No. of jobs
	 * @return : returning an 2-D array containing desired result
	 */
	static int[][] firstComeFirstServe( int arrivalTime[], int jobSize[] ,int  n){
		 int i;
		 int jobStartTime[]=new int[n];
		 int jobWaitTime[]=new int[n];
		 int jobFinishTime[]=new int[n];
		 jobStartTime[0]=1;
		 jobWaitTime[0]=0;
		 jobFinishTime[0]=jobSize[0];
		 for(i=1;i<n;i++)
		 {
			 if(arrivalTime[i]<jobFinishTime[i-1])//if arrival time less than finish time
			 {
				 jobStartTime[i]=jobFinishTime[i-1]+1;
			 jobWaitTime[i]=jobStartTime[i]-arrivalTime[i];
			 jobFinishTime[i]=jobStartTime[i]+jobSize[i]-1;
			 }
			 else//if arrival time not less than finish time
			 {
				 jobWaitTime[i]=0;
				 jobStartTime[i]=arrivalTime[i];
				 jobFinishTime[i]=jobStartTime[i]+jobSize[i]-1;
				 
			 }
			 
		 }
		 int finalResult[][]=new int[n][5];
		 for(i=0;i<n;i++)
		 {
			 
			
			 finalResult[i][0]=i+1;
			 finalResult[i][1]=arrivalTime[i];
			 finalResult[i][2]=jobWaitTime[i];
			 finalResult[i][3]=jobStartTime[i];
			 finalResult[i][4]=jobFinishTime[i];
			 
			 
		 }
		 for( i=0;i<n;i++){
			 for(int j=0;j<5;j++){
				 System.out.print(finalResult[i][j]+" ");
			 }
		 System.out.println();
		 }
		 return finalResult;
	}

}
