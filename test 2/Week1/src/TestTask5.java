import java.io.File;

public class TestTask5 {
	
	public static void main(String[] args) {
		//add a new file and use reader function to add it to a charArray
		// then convert the array to a string and use our occurring function on the string of text.
		File file = new File("TomSawyer.txt");
		char[] p = CharacterReader.reader(file);
		String q = new String(p);
		

		CharacterReader.getOccuringChar(q);
	}
}
