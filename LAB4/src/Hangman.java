import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Hangman {
	//Chance Gordon 300248015
	//COSC 121-L03
	public static void main (String[] args) { 
	
		Scanner sc = new Scanner(System.in);
		
		String guessWord = intWord();
		int score = 0;
		int guessesLeft = 7;
		ArrayList<String> incorrectGuesses = new ArrayList<>();
		char[] dispWord = new char[guessWord.length()];
		
	//	System.out.println(guessWord);

		while (guessesLeft > 0) {

			System.out.println("Hidden Word: " + hiddenWord(dispWord));
			System.out.println("Incorrect guesses: " + dispIncorrect(incorrectGuesses));
			System.out.println("Guesses left: " + guessesLeft);
			System.out.println("Score: " + score); 
			System.out.println("Enter next guess: ");
			String g = sc.nextLine();
			g = g.toLowerCase();
			
			if (guessWord.contains(g)) {
				for (int i = 0; i < guessWord.length(); i++) {
					if (guessWord.charAt(i) == g.charAt(0)) {
						dispWord[i] = guessWord.charAt(i); }}
				
				score += 10;
				System.out.println("There was a " + g + "!\n" ); }
			
			else {
				incorrectGuesses.add(g);
				guessesLeft--; 
				System.out.println("Sorry, there were no " + g + "'s.\n"); }}
		
		System.out.println("No more guesses, you lose!"); }
		
	public static String hiddenWord(char[] word) {
		String temp = "";
		for (int i = 0; i < word.length; i++) {
			temp += word[i] + "_ "; }
		
		return temp; }	

	public static String dispIncorrect(ArrayList<String> incorrectGuesses) {
		String temp = "";
		for (int i = 0; i < incorrectGuesses.size(); i++) {
			temp += incorrectGuesses.get(i) + " "; }
		
		return temp; }	

	public static String intWord() {

		File f = new File("view.txt");
		Scanner sc;

		try {
			sc = new Scanner(f); }
		catch(Exception e) {
			return "Error Reading word"; }

		int numWords = 100000;
		int numLine = 0;
		numLine = (int)(Math.random()*numWords);

		for (int i = 0; i < numLine-1; i++) {
			sc.nextLine(); }

		String word = sc.nextLine();
		sc.close();
		return word; }}	









