public class Caesar {

	// loops through all keys amount of times, if it goes out of range count from max / min range.
	public static char encrypt_character(char tkn, int key) {
		for (int i = 0; i < key; i++) {
			tkn += 1;
			if (tkn == 91) {
				tkn = 65;
			} else if (tkn == 123) {
				tkn = 97;
			} else if (tkn == 58) {
				tkn = 48;
			}
		}

		return (char) tkn;
	}

	public static char decrypt_character(char tkn, int key) {
		for (int i = 0; i < key; i++) {
			tkn -= 1;
			if (tkn == 64) {
				tkn = 90;
			} else if (tkn == 96) {
				tkn = 122;
			} else if (tkn == 47) {
				tkn = 57;
			}
		}

		return (char) tkn;
	}
}

