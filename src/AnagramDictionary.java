// Name: Alay Dilipbhai Shah
// USC NetID: 4038-9488-19
// CS 455 PA4
// Spring 2019

// Importing necessary packages.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
	
	//Private Instance Variables
	private Map<String, ArrayList<String>> processedDictionary;   //HashMap to store the processedDictionary for quick retrieval of the Anagram values using its keys.
	
	// # Representation Invariants for this class:
	// -- Words having same set of letters will have the same String ID 
	// -- Words with different set of letters cannot have the same string ID.
	// -- All words present in the dictionary file has to be assigned to at least and at most one string ID.
	// -- String Length of StringId and String Length of each word present in the assigned ArrayList of values has to be equal.
	
	
   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      PRE: The strings in the file are unique.
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
    */
	
   public AnagramDictionary(String fileName) throws FileNotFoundException {
	  
	  File inFile = new File(fileName);
	   
	  try (Scanner in = new Scanner(inFile)){
		 processDictionary(in); 
	  }  
   }
	   
   
   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s. If no anagrams are found, it returns an empty list of Strings.
    */  
   
  public ArrayList<String> getAnagramsOf(String s) {
	  
	 ArrayList<String> emptyList = new ArrayList<String>();
	 
	 // stringToId generates the key by using the letters, since the same set of letters will have the same keys. 
	 // Hence we will be retrieving the Anagram values of particular word using its key.
	 String searchId = stringToId(s);                     
	 
	 if (processedDictionary.containsKey(searchId)) {
		return defensiveCopy(processedDictionary.get(searchId));
	 }
	 
	 return defensiveCopy(emptyList);
   }
  
  
  /**
   * Takes each word from the given dictionary file, and processes it as follows:
   * -- It first creates an ID for the word. (Same set of letters will have the same Id)
   * -- It checks if we already have the same Id in the processedDictionary. If it exists, it adds the word to the end of the already existing ArrayList. 
   * 	If it doesn't exists, it will add a new entry where key is the id, and value is the ArrayList of that word. 
   * @param in The Scanner is passes as the parameter input, to read all the words of dictionary file one by one.
   */
   
   private void processDictionary(Scanner in){
	  
	  processedDictionary = new HashMap<String, ArrayList<String>>();
	   
	  while (in.hasNext()) {
		  
		 ArrayList<String> valSet = new ArrayList<String>();
		 String next = in.next();
		 String Id = stringToId(next);
		 
		 
		 if (processedDictionary.containsKey(Id)) {
			valSet = processedDictionary.get(Id);
			valSet.add(next);
			processedDictionary.put(Id, valSet);
		 }
		 
		 else {
			valSet.add(next);
			processedDictionary.put(Id,valSet);
		 }
	  }
   }
   
   
   /**
    * Arranges a string of letters in to alphabetic order which we call it as Id, so that we have the same Id for the same set of letters. 
    * @param str A string or letters in any random order.
    * @return a string of letters arranged in alphabetic order. 
    */
   
   private String stringToId (String str) {
	  
	  char[] charholder = str.toCharArray();
	  Arrays.sort(charholder);
	  String id = String.copyValueOf(charholder);
	  return id;
   }
   
   
   /**
    * Prints the processedDictionary in the form of "Key : Value"
    */
   
   public void printDictionary() {
	   
	   for(Map.Entry<String, ArrayList<String>> entry: processedDictionary.entrySet()) {
		  System.out.println(entry.getKey() + " : " + entry.getValue());  
	   }   
   }
   
   
   /**
    * Makes a defensiveCopy of ArrayList of Strings which we can confidently return to the client without worrying about aliasing issue.
    * @param arr An Arraylist of Strings to make its defensive copy
    * @return The defensive copy of the ArrayList in its same type i.e. ArrayList<String>. 
    */
   
   private ArrayList<String> defensiveCopy(ArrayList<String> arr){
	   ArrayList<String> defensiveCopyArray = new ArrayList<String>();
	   defensiveCopyArray.addAll(arr);
	   return defensiveCopyArray;
   }  
}
