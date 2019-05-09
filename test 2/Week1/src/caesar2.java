import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class caesar2 {

	public static char encrypt_character(char tkn, int key) {
		if ((((int) tkn >= 48 && (int) tkn <= 57) || ((int) tkn >= 65 && (int) tkn <= 90) || ((int) tkn >= 97))
				&& (int) tkn + key <= 122) {

			int temp = 0;
			temp = (int) tkn + key;
			tkn = (char) temp;

		}

		return tkn;
	}

	public static char decrypt_character(char tkn, int key) {

		int temp = 0;
		temp = (int) tkn - key;
		tkn = (char) temp;

		return tkn;

	}

	public static void main(String[] args) {
		int i;

		String inputstring;
		File Start = new File("Start.txt");
		File Encrypted = new File("Encrypted.txt");
		File Decrypted = new File("Decrypted.txt");

		Scanner userInput = new Scanner(System.in);
		System.out.println("How many keys do you want?");

		int AmountOfKeys = userInput.nextInt();
		int[] keys = new int[AmountOfKeys];

		System.out.println("You chose " + AmountOfKeys);

		System.out.println("And what should their values be?");

		for (i = 0; i < AmountOfKeys; i++) {
			keys[i] = userInput.nextInt();
		}
		userInput.close();

		try {
			Scanner sc = new Scanner(Start);

			PrintWriter PrintEnc = new PrintWriter(Encrypted);
			PrintWriter PrintDec = new PrintWriter(Decrypted);
			while (sc.hasNext()) {

				inputstring = sc.next();
				char[] myChar = inputstring.toCharArray();
				char[] encrypted = new char[myChar.length];
				char[] decrypted = new char[myChar.length];

				boolean[] decryptornot = new boolean[myChar.length];

				ArrayList<Integer> keyList = new ArrayList<>();

				while (keyList.size() <= myChar.length) {
					for (i = 0; i < keys.length; i++) {
						keyList.add(keys[i]);
					}
				}
				keyList.subList(myChar.length, keyList.size()).clear();

				for (i = 0; i < myChar.length; i++) {

					encrypted[i] = Caesar.encrypt_character(myChar[i], keyList.get(i));
					if ((int) myChar[i] == encrypted[i]) {
						decryptornot[i] = false;

					} else {
						decryptornot[i] = true;
					}
				}
				PrintEnc.print(encrypted);
				PrintEnc.print(" ");

				for (i = 0; i < myChar.length; i++) {
					if (decryptornot[i] == false) {
						decrypted[i] = Caesar.decrypt_character(encrypted[i], 0);
					} else {
						decrypted[i] = Caesar.decrypt_character(encrypted[i], keyList.get(i));
					}

				}

				PrintDec.print(decrypted);
				PrintDec.print(" ");

			}

			sc.close();
			PrintDec.close();
			PrintEnc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}