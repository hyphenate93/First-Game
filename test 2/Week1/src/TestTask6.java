import java.io.File;
import java.util.*;
import java.io.*;
import java.util.Scanner;

// how to run: chose a text file and save it with random name use the encrypt code lines
//  run again with random name as file and save as something else, comment out encrypt and use decrypt lines.
// decryption run must use same keys as Encryption did

public class TestTask6 {

	public static void main(String[] args) {
		// add variables used for indexing and counting, also add the text file and
		PrintWriter filout = null;
		char a;
		int k = 0;
		File file = new File("snällagud.txt"); // input desired textfile
		char[] charList = CharacterReader.reader(file);
		String stringList = new String(charList);

		// ask for user inputs Amount of keys used for encrypting/decrypting and their
		// values
		// use while loop to keep asking for values until user desired amount is saved
		Scanner userInput = new Scanner(System.in);
		System.out.println("How many keys do you want?");

		int AmountOfKeys = userInput.nextInt();
		int[] keys = new int[AmountOfKeys];
		int l = 0;

		System.out.println(AmountOfKeys + "  Keys selected\n");

		System.out.println("Chose your value and press enter");

		while (k < AmountOfKeys) {
			keys[k] = userInput.nextInt();
			k++;
		}
		userInput.close();

		// loop to go through our entire text file
		for (int i = 0; i < charList.length; i++) {

			// only do operations if the character in text file matches letter small or
			// large or a number 0-9

			if (Character.toString(stringList.charAt(i)).matches("^[a-z-[0-9]-A-Z]*$")) {

				// two if statements in order to encrypt the first Amount of keys characters
				// with amount of keys key

				if (l < AmountOfKeys) {
					 a = Caesar.encrypt_character(charList[i], keys[l]); // use this line to encrypt
					
					//a = Caesar.decrypt_character(charList[i], keys[l]); // use this line to decrypt
					charList[i] = a;
					l++;
					// once n amount of characters have been given n amount of keys start from key
					
				} else if (l == AmountOfKeys) {
					l = 0;
					 a = Caesar.encrypt_character(charList[i], keys[l]); // use this line to encrypt
				
					//a = Caesar.decrypt_character(charList[i], keys[l]); // use this line to decrypt
					charList[i] = a;
					l++;
				}

			}
		}

		try {
			// Save the new encrypted or decrypted file
			filout = new PrintWriter(new BufferedWriter(new FileWriter("HejsanEncrypt.txt", true)));
			filout.write(charList);
		} catch (IOException e) {
		} finally {
			filout.close();
		}

	}

}
