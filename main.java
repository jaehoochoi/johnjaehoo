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
		private ArrayList<String> nextword = new ArrayList<String>();
		private boolean visted = false;
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
	
	/* public static ArrayList<String> BFS(String start, String end, HashMap<String, Node> data)
	 * find the shortest way to get the word
	 */
	public static ArrayList<String> BFS(String start, String end, HashMap<String, Node> data) {
		// special case: when start and end are equal
		if(start.equals(end)) { 
			return null; 
		}
		
		ArrayList<String> ans = new ArrayList<String>();
		Queue<String> q = new LinkedList<String>();
		
		Node adjacent = data.get(start);
		adjacent.visted = true;	// check we visited start at the beginning. 
		
		while(true) {
			// add all the adjacent words of start to queue
			for(int i = 1; i < adjacent.nextword.size(); i++) {
				q.add(adjacent.nextword.get(i));
			}
			
			// get the word from queue and get the node from hashmap
			adjacent = data.get(q.poll());
			adjacent.visted = true;
			// TODO how can we access to the string in hashmap?
			if(adjacent)
			
			// if queue is empty, done
			if(q.isEmpty()) { 
				break;
			}
		}
		
		
		
		
		return null;
	}
	
	/* public static ArrayList<String> getWordLadder(String start, String end)
	 * given method
	 */
	public static ArrayList<String> getWordLadder(String start, String end) {
		Set<String> dict = makeDictionary();
		HashMap<String, Node> data = saveToMap(dict);
		
		// TODO BFS algo
		Node possibleWords = data.get(start);
		// possibleWords.visted = true;
		// TODO index
		// possibleWords.nextword.get(index);
		
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
		
		possibleWords.nextword.add(word);
		
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
		int countOfDiffLetters = 0;
		
		for(int i = 0; i < 5; i++){
			if(s1.getBytes()[i] != s2.getBytes()[i]) {
				countOfDiffLetters++;
			}
			if(countOfDiffLetters > 1) {
				return false;
			}
		}
		
		if(countOfDiffLetters == 1) {
			return true;
		}
		else { 
			return false;
		}
	}
}
