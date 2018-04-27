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
		String cont = "y";
		while (cont.equalsIgnoreCase("y")) {

			System.out.print("Enter a line to be translated: ");
			userInput = scan.nextLine();

			int index = indexOfFirstVowel(userInput);
			System.out.printf("%nIndex of first vowel: %s%n", index);
			
//			System.out.printf("%nPig Latin Translation: %s%n", translate(userInput, index));
			
//			System.out.printf("%nWould you like to continue (y/n)? ");
//			cont = scan.nextLine();

		}

	}

	// Method takes a valid word and returns the index of the first vowel,
	// returns -1 if no vowel.
	
	/* TODO:
	 * method not working for words like "totally"
	 * need to nest a for-loop to cycle through char index in words
	 */
	
	public static int indexOfFirstVowel(String userInput) {
		int index = -1;
		for (int i = 0; i < VOWELS.length; i++) {
			index = userInput.indexOf(VOWELS[i]);
			if (index >= 0) {
				return index;
			}
		}
		return 0;

	}
	
	// Method takes a valid word and index of first vowel,
	// returns Pig Latin translation.
	public static String translate(String userInput, int index) {
		String suffix = AY;
		if (index == 0) {
			suffix = "w" + AY;
		}
		
		return userInput.substring(index) +	userInput.substring(0, index)+ suffix;
	}
}