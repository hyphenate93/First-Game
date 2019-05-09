import java.util.List;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

class CharacterReader {

	static void getOccuringChar(String file) {
		// make a counting array the size of the input file, also add a list and decimal for later use
		int count[] = new int[file.length()];
		List<String> letterC = new ArrayList<String>();
		DecimalFormat dec = new DecimalFormat("###.##");

		double charCount = 0;
		char temp;
		// Foorloop to determine the amount of letters in the file to use for frequency
		for (int i = 0; i < file.length(); i++) {
			temp = file.charAt(i);

			if (Character.toString(temp).matches("^[a-zA-Z]*$"))
				charCount++;
		}
		for (int i = 0; i < file.length(); i++)

			count[file.charAt(i)]++;

		// Create an array of given String size
		char ch[] = new char[file.length()];

		for (int i = 0; i < file.length(); i++) {
			ch[i] = file.charAt(i);
			int find = 0;
			for (int j = 0; j <= i; j++) {

				// if statement looks for letters

				if (file.charAt(i) == ch[j] && Character.toString(file.charAt(i)).matches("^[a-zA-Z]*$"))
					find++;
			}

			if (find == 1)

				letterC.add(" Bokstav     " + "antal     " + " Frekvens\n" + "    " + file.charAt(i) + "          "
						+ count[file.charAt(i)] + "           "
						+ dec.format(((double) (count[file.charAt(i)] / charCount) * 100)) + "%");

		}
		java.util.Collections.sort(letterC);
		letterC.forEach(System.out::println);
	}

	public static char[] reader(File a) {

		String string = "";
		File file = a;
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			string = scanner.nextLine();
			while (scanner.hasNextLine()) {
				string += scanner.nextLine(); // string gets the value of row + next row
			}

			char[] charArray = string.toCharArray();

			scanner.close();
			return charArray;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}
}
