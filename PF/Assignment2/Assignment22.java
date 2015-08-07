package Assignments;

import java.util.Scanner;

public class Assignment22 {

	
	public static void main(String[] args) {
		int num;
		Assignment22 a1=new Assignment22();
		System.out.println("enter the Number");
		Scanner sc=new Scanner(System.in);
		num=sc.nextInt();
		String s4[]=a1.printWholePyramid(num);
		for(int i=0;i<s4.length;i++)
			System.out.println(s4[i]);
		
	}
	String spaces(int row,int n){
		String s1="";
		for(int i=1;i<row;i++){
			s1=s1+" ";
		}
		//System.out.println("hello"+s1+"hello");
		return s1;
		
	}
	
	String number(int row,int n){
		String s1="";
		for(int i=1;i<n-row+2;i++){
			s1=s1+i;
		}
		return s1;
		
	}
	
	String[] printWholePyramid(int n)
	{
		String s1="",s2="";
String s3[]=new String[n];
		for(int i=1;i<=n;i++){
			s1=spaces(i,n);
			s2=number(i,n);
			s3[i-1]=s1+s2;
		}
		return s3;
	}

}
