package Assignments;

import java.util.Scanner;

public class Assignment21 {

	public static void main(String[] args) {
		int num;
		Assignment21 a1=new Assignment21();
		System.out.println("enter the Number");
		Scanner sc=new Scanner(System.in);
		num=sc.nextInt();
		String s4[]=a1.printWholePyramid(num);
		for(int i=0;i<s4.length;i++)
			System.out.println(s4[i]);
		
	}
	String spaces(int row,int n){
		String s1="";
		if(row<=n){
		for(int i=0;i<n-row;i++){
			s1=s1+" ";
		}
		}
		else
		{
			for(int i=0;i<row-n;i++){
				s1=s1+" ";
			}	
		}
		return s1;
		
	}
	
	String number(int row,int n){
		String s1="";
		int j=0;
		if(row<=n){
		for(int i=1;i<=row;i++){
			s1=s1+i;
		}
		for(int i=row-1;i>=1;i--)
		{
			s1=s1+i;
		}
		}
		else
		{
			
			j=j+2*(row-n);
			for(int i=1;i<=row-j;i++){
				s1=s1+i;
			
			}	
			for(int i=row-j-1;i>=1;i--){
				s1=s1+i;
			
			}	
			
		
		}
		return s1;
		
	}
	
	String[] printWholePyramid(int n)
	{
		String s1="",s2="";
String s3[]=new String[(2*n)-1];
		for(int i=1;i<=2*n-1;i++){
			s1=spaces(i,n);
			s2=number(i,n);
			s3[i-1]=s1+s2;
		}
		return s3;
	}
}
