/* WORD LADDER Main.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Fall 2015
 */


package project3;
import java.util.*;
import java.io.*;

public class Main {  

	/* inner class Node
	 * 
	 */
	private static class Node {
		ArrayList<String> nextword = new ArrayList<String>();
		boolean visted = false;
	}
	
	/* public static void main(String[] args)
	 * given method
	 */
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		//String start = "stone";
		//String end = "money";
		//getWordLadder(start, end);
		
		
		String cmd = "initializer";
		//kb.useDelimiter(" ");
		System.out.println(kb.delimiter());
		while(true){
			
			//terminate program
			cmd = kb.next();
			if(cmd.equals("/quit")) break;
			if(cmd.startsWith("/")) System.out.println("invalid command " + cmd);
			System.out.println(cmd);
				
			
		}

	}
	
	/* public static ArrayList<String> getWordLadder(String start, String end)
	 * given method
	 */
	public static ArrayList<String> getWordLadder(String start, String end) {
		Set<String> dict = makeDictionary();
		HashMap<String, Node> data = saveToMap(dict);
		
		// TODO BFS algo
		Node possibleWords = data.get(start);
		possibleWords.visted = true;
		// TODO index
		possibleWords.nextword.get(index);
		
		return null;
	}
	
	/* public static Set<String> makeDictionary()
	 * given method
	 */
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while(infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}
	
	/* public static HashMap<String, Node> saveToMap(Set<String> dict)
	 * saves to the map by calling saveToArrayList and compareWords
	 */
	public static HashMap<String, Node> saveToMap(Set<String> dict) {
		Iterator<String> iterDict = dict.iterator();
		HashMap<String, Node> map = new HashMap<String, Node>();

		while(iterDict.hasNext()) {
			String word = iterDict.next();
			map.put(word, saveToArrayList(word, dict));
		}
		
		return map;
	}
	
	/* public static Node saveToArrayList(String word, Set<String> dict)
	 * saves words that has only one different character to the ArrayList
	 */
	public static Node saveToArrayList(String word, Set<String> dict) {
		Iterator<String> iterDict = dict.iterator();
		Node possibleWords = new Node();
		
		while(iterDict.hasNext()) {
			String nextWord = iterDict.next();
			if(compareWords(word, nextWord)) {
				possibleWords.nextword.add(nextWord);
			}
		}
		
		return possibleWords;
	}
	
	/* public static boolean compareWords(String s1, String s2)
	 * compares two strings and return true if s2 has only one different character compared to s1
	 */
	public static boolean compareWords(String s1, String s2) {
		int count_of_diff_letters = 0;
		
		for(int i = 0; i < 5; i++){
			if(s1.getBytes()[i] != s2.getBytes()[i]) count_of_diff_letters++;
			if(count_of_diff_letters > 1) return false;
		}
		
		if(count_of_diff_letters == 1) return true;
		else return false;
	}
}
