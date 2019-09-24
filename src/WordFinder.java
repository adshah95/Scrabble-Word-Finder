// Name: Alay Dilipbhai Shah
// USC NetID: 4038-9488-19
// CS 455 PA4
// Spring 2019

// Importing necessary packages: 
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * The main Class to run the "Find Scrabble Words" program, where the user provides a word and 
 * the program outputs the possible word formations along with their scores.
 * The program also allows the user to give a dictionary file as a program arguments to search for the anagrams of the word from that mentioned dictionary file.
 * However,if no program arguments are specified, then the class will use the default dictionary "sowpods.txt" 
 * present in the same directory as the current working directory where the program runs.
 * NOTE: If the dictionary file mentioned as the program arguments is not found for any reason, 
 * then the program will report an error and exit successfully.
 * @author Alay
 */


// # Representation Invariants for this class:
// Since this is a main class with static methods and has no instance variables
// or abstract data types of its own, hence this class does not have any particular representation invariants.

public class WordFinder
{

	public static void main(String[] args)
	{
		String dictionaryFile;
		AnagramDictionary dictionary;
		
		
		if (args.length == 0) {
			dictionaryFile = "src/sowpods.txt";
		}
		else {
			
			dictionaryFile = args[0];
		}
		
		try {
			Scanner in = new Scanner(System.in);
			dictionary = new AnagramDictionary(dictionaryFile);
			runScrabble(dictionary, in);
		}
		catch (FileNotFoundException e) {
			
			System.out.println("ERROR: File '" + dictionaryFile + "' not found!");	
		}		
	}
	
	
	/**
	 * This method does all the tasks for running the program successfully, by first printing some informative messages,
	 * and then asking the user for a word to be put on the rack, and then calls the ScoreGenerator class and its method to
	 * successfully perform what the program is expected to perform as explained in the class description above.
	 * @param dict The AnagramDictionary from which the words are to be looked for
	 * @param in Scanner function for reading the word on rack entered by the user
	 */
	
	private static void runScrabble(AnagramDictionary dict, Scanner in) {
		System.out.println("Type . to quit.");
		System.out.print("Rack? ");
		String wordOnRack = in.next();
		ScoreGenerator genScores;
		String dot = ".";
		
		// A while loop to stop the program from quitting itself unless asked by the user by entering a "dot".
		while (!wordOnRack.equals(dot)) {
			genScores = new ScoreGenerator(wordOnRack, dict);
			genScores.printScores();
			System.out.print("Rack? ");
			wordOnRack = in.next();
		}
	}
}
