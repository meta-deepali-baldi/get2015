/**
 * Question 2. Truth Table

Write a Java program that will take a boolean expression in infix form as an input, and will display the truth table for that boolean expression. For parsing you can assume that- 

a) variables in boolean expression are single character long
b) there are no white spaces in the expression
c) expression is made of only three types of operators and(&), or (|) and not (~)
d) precedence of operators is as follows- not (~) > and (&) > or (|)
e)  and (&) associates from left to right, or (|) associates from left to right, not (~) associates from right to left
f) expression may have parentheses 
 *
 */
package TruthTableForExpression;

import java.util.Scanner;

/**
 * @author Deepali
 *
 */
public class TruthTableMain {

	public static void main(String[] args) {
		String infixExpression="";
		Scanner sc = new Scanner(System.in);
		do{
		System.out.println ("Enter valid boolean expression : ");
		infixExpression = sc.next();
		}while(!Validation.isExpression(infixExpression));
		
		TruthTableGenerator tableGenerator=new TruthTableGenerator(); 
		String postfixString=tableGenerator.infixToPostfixConversion(infixExpression);//converting expression to postfix form
		String string = tableGenerator.getVariablesInExpresssion(postfixString); //getting unique variables from expression
		System.out.println ( "\nTruth Table : ");
		tableGenerator.generateTruthTable(postfixString, string);//generating truth table
		sc.close();
	}
}
