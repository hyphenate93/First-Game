import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Reader;

public class Test7 {

public static void main(String[]args) {
	
	

	    String line = null;
	    ArrayList<String> list = new ArrayList<String>();
	    ArrayList<String> a = new ArrayList<String>();
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader("klasslista(3)(2).txt"));
	        while((line = reader.readLine()) != null){
	            list.add(line.trim().replaceAll("\\s+", " "));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	  
	 System.out.println(Lister.findName(list, 1).split(" ").length);
	// System.out.println(Lister.deleteName(list,"Andreas Andersson" ));
	 list.forEach(System.out::println);
	 
	System.out.println( Lister.addToList(list,"Andreas Östlin"));
	 
	 
	 
	   
	    
	}

	}