// Name: Alay Dilipbhai Shah
// USC NetID: 4038-9488-19
// CS 455 PA4
// Spring 2019


/**
 * The Score Table Class contains the points each letter carries, and
 * the class also has a method to compute the score any word carries by 
 * summing up all the points the of the letters present in that particular word.
 * @author Alay
 */

public class ScoreTable
{
	//Private Instance Variables
	private static final int NUM_ALPHABETS = 26;			
	private static final char REL_INDEX = 'A';				// We will calculate the index of any letter with respect to the index of letter 'A'.
	private int[] scoreKeeper;								// Array of integer to store the points each letter is worth of.

	// # Representation Invariants for this class
	// -- The length of the scoreKeeper array should be no lesser than the total number of alphabets i.e. 26,
	//    since we need exactly one space in the array for storing the value of the alphabet/letter.
	// -- Each letter can have exactly one point-value i.e. Letter 'A' cannot have point-value 1 as well as 2 simultaneously.
	// -- The point value of the letter as well as the overall scores of the word both are case-insensitive i.e. 
	//    Letter 'A' and Letter 'a' will have same point-value. Similarly words 'calm', 'CALM, 'cAlM', 'CaLm'; all will have the same scores.
	
	
	/**
	 * Initiates a scoreKeeper array of length 26, since we need one place each for storing the point of all 26 alphabets at its respective place relative to alphabet 'A'.
	 * Calls the charScoresFiller() method to populate the above initiated scoreKepper Array.
	 */
	
	public ScoreTable() {
		scoreKeeper = new int[NUM_ALPHABETS];
		charScoresFiller();
	}
	
	
	/**
	 * Calculates the score of the given word by summing up the values of each letter present in that particular word,
	 * using the point-value information stored in the scoreKeeper Array.
	 * NOTE: This method is not case-sensitive, hence "CALM" and "calm" will have the same score, 
	 * since the point-value of the letters does not depend on its case.
	 * @param currWord The word whose score we want to calculate
	 * @return The score of the word as integer.
	 */
	
	public int getWordScore(String currWord) {
		int score = 0;		
		for (int i=0; i<currWord.length(); i++) {
			char c = currWord.toUpperCase().charAt(i);
			int index = getIndexOf(c);
			if (index >= 0 && index < scoreKeeper.length) {
				score += scoreKeeper[index];
			}
		}
		return score;	
	}
	
	
	/**
	 * The method populates the scoreKeeper array by first getting the index of the alphabet using the getIndexOf() method, 
	 * and then maps the value of the Alphabet at its calculated correct place. 
	 */
	
	private void charScoresFiller() {		
		scoreKeeper[getIndexOf('A')] = 1;
		scoreKeeper[getIndexOf('E')] = 1;
		scoreKeeper[getIndexOf('I')] = 1;
		scoreKeeper[getIndexOf('O')] = 1;
		scoreKeeper[getIndexOf('U')] = 1;
		scoreKeeper[getIndexOf('L')] = 1;
		scoreKeeper[getIndexOf('N')] = 1;
		scoreKeeper[getIndexOf('S')] = 1;
		scoreKeeper[getIndexOf('T')] = 1;
		scoreKeeper[getIndexOf('R')] = 1;
		scoreKeeper[getIndexOf('D')] = 2;
		scoreKeeper[getIndexOf('G')] = 2;
		scoreKeeper[getIndexOf('B')] = 3;
		scoreKeeper[getIndexOf('C')] = 3;
		scoreKeeper[getIndexOf('M')] = 3;
		scoreKeeper[getIndexOf('P')] = 3;
		scoreKeeper[getIndexOf('F')] = 4;
		scoreKeeper[getIndexOf('H')] = 4;
		scoreKeeper[getIndexOf('V')] = 4;
		scoreKeeper[getIndexOf('W')] = 4;
		scoreKeeper[getIndexOf('Y')] = 4;
		scoreKeeper[getIndexOf('K')] = 5;
		scoreKeeper[getIndexOf('J')] = 8;
		scoreKeeper[getIndexOf('X')] = 8;
		scoreKeeper[getIndexOf('Q')] = 10;
		scoreKeeper[getIndexOf('Z')] = 10;		
	}
	
	
	/**
	 * Returns the index of the given character for mapping its point-value using that index in the scoreKeeper array. 
	 * The place/index of the given character is calculated using the reference of character 'A'.
	 * For e.g, alphabet 'B' appears just after alphabet 'A', hence the index of character 'B' is 1 w.r.t to 'A'. 
	 * Also note that by the above method, the minimum index i.e index of character 'A' w.r.t itself will be 0,
	 * and the maximum index i.e. index of character 'Z' w.r.t character 'A' will be 25, which is also the last available place in the scoreKeeper array. 
	 * @param c The Character whose index we want to generate.
	 * @return The index of given character w.r.t character 'A' as integer.
	 */
	
	private int getIndexOf(char c) {
		return (c - REL_INDEX);	
	}	
}

