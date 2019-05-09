import java.io.*;
import java.util.Scanner;

public class TestTask123 {
	public static void main(String[] args) {
		Password pass1 = new Password();
		int count = 0;
		// make our array
		char[][] passArrays = new char[1000][];
		for (int i = 0; i < passArrays.length; i++) {
			passArrays[i] = pass1.generatePassword();
			String stringPass = new String(passArrays[i]);

			// add these lines to print all created passwords with a true/false statement
			// for each iteration.
			// System.out.println(Password.passwordCheck(stringPass));
			// System.out.println(stringPass);

			// counter to check how many passwords are valid
			if (Password.passwordCheck(stringPass) == true) {
				count++;

			}

		}
		// add this line to check every password in the array
		// System.out.println(Arrays.deepToString(passArrays));

		System.out.println(count + " " + "out of" + " " + passArrays.length + " is valid passwords");

	}

}
