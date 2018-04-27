import java.util.Scanner;

public class PigLatin {

	// Tim Pieniazek, github.com/timpieniazek/timpieniazekcapstone1
	// Week 1 Capstone: Pig Latin, 04/26/2018

	public static final String[] VOWELS = { "a", "e", "i", "o", "u" };
	public static final String AY = "ay";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Welcome to the Pig Latin Translator!%n%n");

		// StringBuilder userInput = new StringBuilder();
		String userInput;

		// While loops allows user to repeat after translating line
		char cont = 'y';
		while (cont == 'y') {

			System.out.print("Enter a line to be translated: ");
			userInput = scan.nextLine();

			System.out.println(indexOfFirstVowel(userInput));

		}

	}

	// Method takes a valid word and returns the index of the first vowel,
	// returns -1 if no vowel.
	public static int indexOfFirstVowel(String userInput) {
		int index;
		for (int i = 0; i < VOWELS.length; i++) {
			index = userInput.indexOf(VOWELS[i]);
			if (index >= 0) {
				return index;
			}
		}
		return -1;

	}
}