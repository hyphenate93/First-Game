import java.util.Arrays;
import java.io.*;
import java.util.Scanner;


public class ArrayTest {

	public static void main(String[] args) {
		// make example arrays to test add different values to
		int[] a = new int[10];
		int[] b = { 0, 2, 3, 4, 7 };

		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		
		// try our method and print to see result.
		int[] c = Task4.addAtIndex(a, 2, 11);
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(b));

	}
}
