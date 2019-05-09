import java.io.*;
import java.util.Scanner;

class NoOfOccurenceOfCharacters { 
    static final int MAX_CHAR = 256; 
  
    static void getOccuringChar(String str) 
    { 
        // Create an array of size 256 i.e. ASCII_SIZE 
        int count[] = new int[MAX_CHAR]; 
  
        int len = str.length(); 
  
        // Initialize count array index 
        for (int i = 0; i < len; i++) 
            count[str.charAt(i)]++; 
  
        // Create an array of given String size 
        char ch[] = new char[str.length()]; 
        for (int i = 0; i < len; i++) { 
            ch[i] = str.charAt(i); 
            int find = 0; 
            for (int j = 0; j <= i; j++) { 
  
                // If any matches found 
                if (str.charAt(i) == ch[j])  
                    find++;                 
            } 
  
            if (find == 1)  
                System.out.println("Number of Occurrence of " + 
                 str.charAt(i) + " is:" + count[str.charAt(i)]);             
        } 
    } 
    public static void main(String[] args) 
    { 
    	File file = new File("klasslista(3)(2).txt");
    	char[] p =reader(file);
    	String q= new String(p);
        ; 
        
        getOccuringChar(q); 
    } 
public static char[] reader(File a) {
		
		String string = "";
		File file = a;
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			string = scanner.nextLine();
			while(scanner.hasNextLine()) {
				string += scanner.nextLine(); //string gets the value of row + next row
			}
			
			char[] charArray = string.toCharArray();
			
			scanner.close();
			return charArray;
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	
	}
} 
