/**
 * Write a method that takes a string and returns the number of unique characters in the string. 
 * It is expected that a string with the same character sequence may be passed several times to the method.
 * Since the counting operation can be time consuming, the methods should cache the results,
 * so that when the methods is given a string previously encountered, it will simply retrieve the stored result. Use collection and maps where appropriate.
 */
package Session6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author deepali
 *
 */
public class UniqueCharactersUsingMap {
	private Map<String,Integer> charactersMap=new HashMap<String,Integer>(); //Map for storing String with their no of unique characters
	private Set<Character> setOfUniqueCharacter = new HashSet<Character>(); //Set of Unique Characters
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		char mainChoice = 0;
		String input;
		UniqueCharactersUsingMap map=new UniqueCharactersUsingMap();
		Utility utility=new Utility();
		do {
			//Taking input
			System.out.println("Enter String");
			input=scanner.nextLine();
			//Displaying no of Unique characters
			System.out.println("No. of characters :"+map.uniqueCharacter(input));
			//Displaying Unique Characters
			if(map.setOfUniqueCharacter.size()!=0) {
			System.out.println(map.setOfUniqueCharacter);
			}
			map.setOfUniqueCharacter.clear();
			mainChoice = utility.checkingString(mainChoice);
		} while (mainChoice == 'Y');
		scanner.close();
	}
	
	/** Computing Number of uNique Characters
	 * @param input :String whose unique Characters to be computed
	 * @return :No of characters
	 */
	public int uniqueCharacter(String input) {
		
		if(charactersMap.containsKey(input)) {//If map contains key previously then only retrieve
			System.out.println("Repeated String");
			return charactersMap.get(input);
		}else {	//else computing no of unique characters
		
			for (int i = 0; i <input.length(); i++) {
				if(input.charAt(i)!=' '){
				setOfUniqueCharacter.add(input.charAt(i));
				}
			}
			charactersMap.put(input, setOfUniqueCharacter.size());
			
			return setOfUniqueCharacter.size();
		}
	}
}
