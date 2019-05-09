import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class Lister {

	public static String findName(ArrayList list, int index) {
		// retrieves index asked for by user and returns with some information.
		String x = list.get(index).toString() + " Is at row " + index + " in the document";
		return x;
	}

	public static boolean deleteName(ArrayList list, String name) {
		// loops through given list and looks for name if name is found remove and
		// return true
		// if name is not found return false and do nothing
		boolean x = false;
		for (int i = 0; i < list.size(); i++) {
			if (((String) list.get(i)).replaceAll("\\s+", " ").equals(name)) {
				list.remove(i);
				x = true;
			}
		}
		return x;
	}

	public static boolean addToList(ArrayList list, String name) {
		// Similar to first function look if name exists if it exists return false and
		// do nothing
		boolean x = true;
		for (int i = 0; i < list.size(); i++) {

			if (((String) list.get(i)).replaceAll("\\s+", " ").equals(name)) {
				x = false;

			}

		}
		// if name does not exist add given name to given list shuffle to sort by last
		// name and shuffle back
		if (x == true) {
			list.add(name);
			list = nameSwap(list);
			java.util.Collections.sort(list);
			list = nameSwap(list);
			list.forEach(System.out::println);
			x = true;
		}
		return x;
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

	public static ArrayList<String> nameSwap(ArrayList list) {
		// shuffle function in order to sort name list by last name
		String[] nameSwap = null;
		String name = null;
		String newName = null;
		ArrayList<String> swap = new ArrayList<String>();

		for (int i = 0; i < list.size(); i++) {
			name = (String) list.get(i);
			nameSwap = name.split("\\s+");
			newName = nameSwap[1] + " " + nameSwap[0];

			swap.add(newName);
		}

		return swap;
	}
}
