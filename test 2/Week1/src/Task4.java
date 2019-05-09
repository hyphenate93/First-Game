import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

public class Task4 {
	public static int[] addAtIndex(int[] a, int x, int index) {
		int userValue = x;
		// first if statement to make sure the index is not larger then the given array
		if (index < a.length) {
			if (a[index] == 0) {
				a[index] = userValue;
				
				// the remaining else ifs is to make sure proper action is take IE if place is taken move to the right.
			} else if (a[index] != 0 && a[a.length - 1] == 0) {
				for (int i = a.length - 1; i > index; i--) {
					a[i] = a[i - 1];
				}
				a[index] = userValue;
			} else if (a[index] != 0 && a[a.length - 1] != 0) {

				int[] doubleArray = new int[a.length * 2];

				for (int i = 0; i < a.length + 1; i++) {
					
					// make numbers left of index stay the same
					if (i < index) {
						doubleArray[i] = a[i];

					}
					// if we move past the index place in the array move values to the right
					else if (i > index) {
						doubleArray[i] = a[i - 1];
					}
				}
				// here we add our new value at given index once operations are complete
				doubleArray[index] = userValue;
				a = doubleArray;
			}

		} else {
			System.out.println("The method requires An int[] followed my your desired number at array index ");
		}
		return a;

	}
}