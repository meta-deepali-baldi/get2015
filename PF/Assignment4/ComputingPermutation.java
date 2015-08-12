/**
*Write a Java program to generate all possible permutations of given letters in string.

Can you make it more generic so that it can generate permutations of any length of string.

List<String> generatePermutations(String input);

Write JUnit for the above program:
generatePermutations(“ABC”);
Expected: Return List of string containing following values:
ABC
ACB
BAC
BCA
CBA
CAB

2) generatePermutations(“ABCD”);
Expected: Return List of string containing 24 unique permutations.

*/
package Assignment4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Deepali
 *
 */
public class ComputingPermutation {
	static List<String> result;//List of Permutations of String
	String permuteString;//String to be permutated
	public ComputingPermutation( String permuteString) {
		super();
		this.permuteString = permuteString;
	}
	public static void main(String[] args) {
		int temp = 0;
		result=new ArrayList<String>();
		ComputingPermutation computingPermutation;
		Scanner sc=new Scanner(System.in);
		
		do{
			switch (temp) {
			case 0:
				System.out.println("Enter String :");
				computingPermutation=new ComputingPermutation(sc.next());
				if(!computingPermutation.permuteString.isEmpty()){ //For checking if String is empty
					result=permutation(computingPermutation.permuteString);
					 Iterator<String> itr=result.iterator();//getting Iterator from arraylist to traverse elements  
					  while(itr.hasNext()){  
					   System.out.println(itr.next());  
					  }  
				}
				System.out.println("Press 1 if you want to exit");
				System.out.println("Press 0 if you want to continue");
				temp = sc.nextInt();
				result.removeAll(result);
				break;
			case 1:
				System.exit(0);
			}
		}while(true);
			
	}
	/**
	 * Function calls a recursive function to find out all strings and then
	 * adding it to the list and then returning it.
	 * 
	 * @param input: input string
	 * @return list of all permuted values
	 */
	public static List<String> permutation(String input) {
		result=generatePermutations("", input);

		Set<String> hs = new HashSet<>();
		hs.addAll(result);
		result.clear();
		result.addAll(hs);
		return result;
	}

	/**
	 * Function calls itself so that it checks at every character and store
	 * every permutation in list
	 * 
	 * @param prefix: prefix string
	 * @param input: string which is to be permuted now
	 */
	public static List<String> generatePermutations(String prefix, String input) {

		int n = input.length();
		if (n == 0) {//if length of String is Empty
			result.add(prefix);

		} else {
			for (int i = 0; i < n; i++)
				generatePermutations(prefix + input.charAt(i),
						input.substring(0, i) + input.substring(i + 1, n));
		}
		return result;

	}

}
