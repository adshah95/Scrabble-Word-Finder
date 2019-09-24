// Name: Alay Dilipbhai Shah
// USC NetID: 4038-9488-19
// CS 455 PA4
// Spring 2019


// Importing necessary packages:
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
   A Rack of Scrabble tiles
 */

public class Rack {
	
	//Private Instance Variables
	private static final int INITIAL_INDEX = 0;        	// The index which will be passes as an argument for getting all the possible subsets of the word currently on Rack.
	private String wordOnRack;						   	// The word currently present on Rack.
	private String uniqString;						   	// The String which is created out of all the unique letters from the word on rack.
	private int[] multiplicity;						   	// The array stores the number of times each unique letter appeared in the word present on rack.
	private Map<Character, Integer> charMap;		   	// The Map stores Character as Key, and the number of times that character appeared in the word on Rack as its value.
	
	
	// # Representation Invariants for this class:
	// -- The String uniqString cannot have a letter more than once i.e. All letters in the unique String are unique.
	// -- The size of multiplicity array should be at least as big as the length of the unique String.
	// -- Any letter present in the uniqString has to be present in the String wordOnRack atleast once.
	// -- Conversely, all the letters present in the wordOnRack should be also present in the uniqString exactly once.
	
	/**
	 * Creates a Rack class from the given word and initializes all the instance variables.
	 * The Rack Class processes the word present on rack to generate all the possible subsets of the word out of it.
	 * @param s The word currently on Rack.
	 */
	
	public Rack(String s) {
		wordOnRack = s;
		charMap = new HashMap<Character, Integer>();
		charMapFiller(wordOnRack);
		mapToWord();
	}
   

   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset.  Unlike the multiset in the parameters,
      each subset is represented as a String that can have repeated characters in it.
      @author Claire Bono
    */

   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<String>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      return allCombos;
   }
  
   
   /**
    * Creates a HashMap out of the word, where the key is the letter present in the word, 
    * and the value will be the number of times that particular letter appeared in the same word. 
    * @param word The word currently on rack to be processed for subsets.
    */
   
   private void charMapFiller(String word){
	  int charVal;
	  
	  // Traverses over the entire word, one character at a time, and updates the value of the key character in the map by incrementing it with 1 
	  // if the character(key) was already present in the map. Else, it puts the character as a new key in the map with a value 1.
	  
	  for(int i=0; i<word.length(); i++) {
		
		char currChar = word.charAt(i);
		if (charMap.containsKey(currChar)) {
			charVal = charMap.get(currChar);
			charVal++;
			charMap.put(currChar, charVal);
		}
		else {
			charMap.put(currChar, 1);
		}		 
	  }
   }
   
   
   /**
    * For each entry present in the HashMap, it populates the multiplicity array and the uniqString string by adding the key of the entry to the uniqString, and
    * adding the value of the entry to the multiplicity array, in the same order as it traverses.
    */
   
   private void mapToWord() {

	  multiplicity = new int[charMap.size()];
	  uniqString = "";
	  int i=0;
	  for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
		  uniqString += entry.getKey();
		  multiplicity[i] = entry.getValue();
		  i++;
	  }   
   }
   
   
   /**
    * Runs the allsubsets() method by giving the uniqString, multiplicity and INITIAL_INDEX as necessary arguments.
    * @return the array list of Strings which contains all the possible unique subsets of the word currently present on the rack.
    */
   
   public ArrayList<String> getSubsets(){ 
	   return allSubsets(uniqString, multiplicity, INITIAL_INDEX);
   }  
}

