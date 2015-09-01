/**
 *Write a program which create a concordance of characters occurring in a string (i.e which characters occur where in a string). Read the string from the command line.

Example:  java Concordance Hello World

{d=[9], o=[4, 6], r=[7], W=[5], H=[0], l=[2, 3, 8], e=[1]}
 */
package Session5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Deepali
 *
 */
public class ConcordanceOfCharacters {
	private Set<Character> setOfUniqueCharacter = new HashSet<Character>(); //set of unique characters
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String input;
		ConcordanceOfCharacters concordanceOfCharacters=new ConcordanceOfCharacters();
		System.out.println("Enter the string");
		input = scanner.next();

		concordanceOfCharacters.uniqueCharacter(input);//generating set of unique elements
		
		String result[]=concordanceOfCharacters.calculatingOccurence(input); //List of Occurence of each unique element

		concordanceOfCharacters.display(result);//display concordance of characters
		scanner.close();
	}
	
	/**
	 * @param input :to create set of unique characters from this input
	 */
	public void uniqueCharacter(String input) {
		for (int i = 0; i <input.length(); i++) {
			setOfUniqueCharacter.add(input.charAt(i));

		}
	}
	
	/**Calculating occurence of unique characters
	 * @param input :input from user
	 * @return :return string of occurence
	 */
	public String[] calculatingOccurence(String input){
		int size=0;
		String result[] = new String[input.length()];
		Iterator<Character> characterIterator = setOfUniqueCharacter.iterator();
		while (characterIterator.hasNext()) {
			char element = (char) characterIterator.next();
			for (int i = 0; i <input.length(); i++) {
				if (element == input.charAt(i)) {
					
					if (result[size] == null)//if no element then add 
						result[size] = " " + i;
					else
						result[size] = result[size] + " "+ i;
				}
			}
			size++;
		}
		return result;
	}
	
	/**Display concordance of characters
	 * @param result :String array containing occurence
	 */
	public void display(String[] result){
		int j=0;

		Iterator<Character> characterIterator = setOfUniqueCharacter.iterator();
		while (characterIterator.hasNext()) {
			char element = characterIterator.next();
			System.out.print(element+ ": [");
			System.out.print(result[j]);
			System.out.println(" ]");
			j++;
	
		}
	}
}