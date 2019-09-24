import java.awt.Window.Type;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Rough_Scrabble
{

	public static void main(String[] args) throws FileNotFoundException
	
	{
		Rack rack = new Rack("alay");
		ArrayList<String> check = rack.getSubsets();
		System.out.println(check.toString());
		
	}

}




//// TODO Auto-generated method stub
////HashMap<String, Set<String>> mapCheck = new HashMap<String, Set<String>>();
////Set<String> first = new HashSet<String>();
////first.add("calm");
////mapCheck.put("aclm", first);
////first.add("clam");
////mapCheck.put("aclm", first);
////
////System.out.println(mapCheck.toString());
////
////String check = "Alay";
////char[] checkarr = check.toCharArray();
////
////System.out.println(Arrays.toString(checkarr));
////
////Arrays.sort(checkarr);
////System.out.println(Arrays.toString(checkarr));
////
////String id = "";
////
////for (int i=0; i<checkarr.length; i++) {
////id += checkarr[i];
////}
////
////System.out.println(id);
////
////String check2 = String.copyValueOf(checkarr);
////System.out.println(check2);
//
//String name_file = "src/sowpods.txt";
//
//
////AnagramDictionary dict = new AnagramDictionary();
////dict.printDictionary();
////ArrayList<String> fuck = dict.getAnagramsOf("calm");
////System.out.println(fuck);
////Rack strrack = new Rack();
////System.out.println('e'-'a');
//
//ArrayList<String> arr = new ArrayList<String>();
//arr.add("Sejal");
//arr.add("Alay");
//Collections.sort(arr);
//System.out.println(arr);
//
//
//Rack checkrack = new Rack("calm");
//
//char c1 = 'a';
//String c = "A";
//String faad = "Alay";
//char c2 = faad.toLowerCase().charAt(0);
//System.out.println(c1==c2);
//System.out.println('E'-1);
////System.out.println(st.indexGenerator('E'));
////ScoreGenerator checkgen = new ScoreGenerator("calm", dict);
//
