import java.util.Scanner;

import java.util.regex.Pattern;

import java.util.regex.Matcher;

public class PigLatin {

	// Tim Pieniazek, github.com/timpieniazek/timpieniazekcapstone1
	// Week 1 Capstone: Pig Latin, 04/26/2018

	public static final char[] VOWELS = { 'a', 'e', 'i', 'o', 'u' };
	public static final String AY = "ay";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Welcome to the Pig Latin Translator!%n");

		// StringBuilder userInput = new StringBuilder();
		String userInput;

		// While loops allows user to repeat after translating line
		String cont = "y";
		while (cont.equalsIgnoreCase("y")) {

			System.out.printf("%nEnter a line to be translated: ");
			userInput = scan.nextLine();

			// Converts to lowercase as per the Build Specs
			userInput = userInput.toLowerCase();

			System.out.println("Ends in punctuation? " + hasPunctuation(userInput));
			if (hasPunctuation(userInput)) {
				System.out.println("Remove punctuation: " + removePunctuation(userInput));
				System.out.println("trans: " + translate(removePunctuation(userInput)) + userInput.substring(removePunctuation(userInput).length()));
				System.out.println("Don't translate: " + dontTranslate(removePunctuation(userInput)));
			}

			System.out.printf("%nPig Latin Translation: %s%n", translate(userInput));

			System.out.printf("%nWould you like to continue (y/n)? ");
			cont = scan.nextLine();
		}
		scan.close();

		System.out.printf("%nThank you! Have a great day!!!!!!!! =)");

	}

	// Method returns boolean whether the string ends in punctuation.
	public static boolean hasPunctuation(String input) {
		char lastChar = input.charAt(input.length() - 1);

		Pattern p = Pattern.compile("[!,.?]");
		Matcher m = p.matcher(Character.toString(lastChar));
		return m.find();
	}
	
	// Method return boolean whether string contains numbers or symbols
	public static boolean dontTranslate(String input) {
		Pattern p = Pattern.compile("[^A-Za-z']");
		Matcher m = p.matcher(input);
		return m.find();
	}

	// Method takes a word and removes the punctuation, recursive for multiple
	// punctuation
	public static String removePunctuation(String input) {
		if (!hasPunctuation(input))
			return input;
		return removePunctuation(input.substring(0, input.length() - 1));

	}

	// Method takes a valid word and returns the index of the first vowel,
	// returns 0 if no vowel.

	public static int indexOfBreakpoint(String userInput) {

		for (int i = 0; i < userInput.length(); i++) {

			for (int j = 0; j < VOWELS.length; j++) {

				if (userInput.charAt(i) == VOWELS[j]) {
					return userInput.indexOf(VOWELS[j]);
				}

			}

		}

		return 0;

	}

	// Method return boolean is first char is vowel
	public static boolean startsWithVowel(String userInput) {
		for (int i = 0; i < VOWELS.length; i++) {
			if (userInput.charAt(0) == VOWELS[i]) {
				return true;
			}
		}
		return false;
	}

	// Method new translate method

	// public static String translate(String input) {
	// StringBuffer stringBuffer = new StringBuffer();
	//
	// for (char c : input.toCharArray()) {
	//
	// }
	//
	// }

	// Method takes a valid word and index of first vowel,
	// returns Pig Latin translation.
	public static String translate(String userInput) {
		String suffix = AY;
		int index = indexOfBreakpoint(userInput);
		if (index == 0 && startsWithVowel(userInput)) {
			suffix = "w" + AY;
		}

		return userInput.substring(index) + userInput.substring(0, index) + suffix;
	}
}