import java.util.Random;
import java.util.regex.Pattern;
import java.io.*;
import java.util.Scanner;
import java.io.*;
import java.util.Scanner;

public class Password {

	public static char[] generatePassword() {
		// declare variables used to generate password
		Random rnd = new Random();
		String lowerChar = "abcdefghijklmnopqrstuvwxyz";
		String upperChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		Random rn = new Random();
		// create a char array that will contain the password, Size 8-12
		char[] x = new char[rn.nextInt(12 - 8 + 1) + 8];

		for (int i = 0; i < x.length; i++) {

			// if statements to fill the array with chars and numbers
			if (i < 4) {
				x[i] = (char) ((rn.nextInt(9 - 0 + 1) + 0) + '0');
			}
			if (i > 3 && i < 6) {

				x[i] = lowerChar.charAt((rnd.nextInt(lowerChar.length())));
			}
			if (i > 5) {
				x[i] = upperChar.charAt((rnd.nextInt(lowerChar.length())));

			}
		}

		// shuffle the created password to add complexity
		for (int j = 0; j < x.length; j++) {
			char randomPosition = (char) rnd.nextInt(x.length);
			char temp = x[j];
			x[j] = x[randomPosition];
			x[randomPosition] = temp;
		}
		return x;
	}

	public static boolean passwordCheck(String password) {

		return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,12}", password);

	}
}
