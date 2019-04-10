package a4p1;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

/* Kathleen Graham 
* Assignment 4 Part 1
*/
public class HorspoolMapGraham {
	private static PrintWriter pw;
	static int numCharT;
	static int numCharP;
	static String text;
	static String pattern;

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length != 2) {
			System.out.print("Error: not enough arguments...");
			System.exit(0); //exit program 
		} else {
			new HorspoolMapGraham(args); //call constructor
		}
	}

	public HorspoolMapGraham(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new File(args[0])); // read the input
		pw = new PrintWriter(args[1]); // creates the output file

		while (sc.hasNextLine()) {
			HashMap<Character, Integer> bmt = new HashMap<Character, Integer>(); // create hashmap to make bmt
			
			while ((text = sc.nextLine()).isEmpty()) { // loops through the input file 
			}
			while ((pattern = sc.nextLine()).isEmpty()) {
			} 

			numCharT = text.length(); // set lengths
			numCharP = pattern.length();

			pw.println("text: " + text); // print the text
			pw.println("pattern: " + pattern); // print the pattern
			
			if (text.length() < pattern.length()) { //if length of the text is less than the pattern, there is an error
				pw.println("Error: Number of the pattern is greater than the text. ");
				pw.println(); //print a space
			} 
			else {
				
				for (int i = 0; i < numCharP - 1; i++) { // make the table
					bmt.put(pattern.charAt(i), (pattern.length() - i - 1));
				}
				bmt.put('*', pattern.length());
				pw.println("BMT Table: " + bmt.toString());
				System.out.println(bmt.toString()); //print to check

				int i = 0;
				while (i <= (numCharT - numCharP)) { //while i is less than T-P
					int j = pattern.length() - 1; //set j to pattern - 1 (last position)
					while (pattern.charAt(j) == text.charAt(j + i)) { //check the positions of the last with the rest 
						if (j == 0) { //once j == 0, then you have found the match
							pw.println("The pattern of the length is found at position: " + i);
							pw.println();
							break; //break out of while 
						}
						j--; //decrement j 
					}
					if (bmt.containsKey(text.charAt(i + pattern.length() - 1))) { // checks to see if the character is
																					// in the bmt

						i += bmt.get(text.charAt(i + pattern.length() - 1)); // move the number associated with the character
					} else {
						i += bmt.get('*'); //else, go the length of the pattern
					}
				}
			}
		}
		pw.println("No match..."); //no match 
		pw.close(); //close
	}
}
