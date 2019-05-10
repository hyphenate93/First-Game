package hashtable;

import java.util.Arrays;


/*
 *  todo
 *  Item Class
 *  array[key] taken. key++
 *  Duplicate item. ItemCount ++
 *  Max fill HashTable to ½ arraySize
 */



public class HashTable {

	
	String[] theArray;

	int arraySize;
	int itemsInArray = 0;
	
    	
	public HashTable(int size) {
		 arraySize = size;
		 theArray = new String[size];
		 Arrays.fill(theArray, "-1");
	}
	
	
	public int hashCalc(String strHash) {

        int hashKey = 0;
        for (int i = 0; i < strHash.length(); i++) {
            hashKey = (hashKey * 128 + strHash.charAt(i)) % arraySize;
        }
        return hashKey;
    }
	
	
	// Print String /w hashKey
	public void hashCalcEq(String strHash) {

        int hashKey = 0;
        for (int i = 0; i < strHash.length(); i++) {
            hashKey = (hashKey * 128 + strHash.charAt(i)) % arraySize;
        }
        System.out.println("[" + strHash + "] key " + hashKey);
        System.out.println();
    }
    
	
	
	public void insert(String str) {
		//System.out.println(str + " added to Array");
        int key = hashCalc(str);
        if(!emptyIndex(key)){
        	key++;
        }
        theArray[key] = str;
	}
		
	
	
	public String findItem(String str) {
		int key = hashCalc(str);
		while (theArray[key] != "-1") {
			if (theArray[key] == str) {
				System.out.println("\n" + str + " at index " + key);
				return theArray[key];
			}
			++key;
			// out of bounds -> start of array
			key %= arraySize;
		}
		// Couldn't locate the key
		return null;
	}
	
	
	
	public boolean emptyIndex(int index){
		
		return theArray[index] == "-1";
	}
	

    public void displayTheStack() {

        int increment = 0;
        int numberOfRows = (arraySize / 10) + 1;

        for (int m = 0; m < numberOfRows; m++) {
            increment += 10;
            
            for (int n = 0; n < 71; n++) {

                System.out.print("-");
            }
            System.out.println();
            
            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);
            }

            System.out.println("|");
            
            for (int n = 0; n < 71; n++)
                System.out.print("-");
            System.out.println();
            for (int n = increment - 10; n < increment; n++) {

                if (n >= arraySize){
                    System.out.print("|      ");
            }
                else if (theArray[n].equals("-1")){
                    System.out.print("|      ");
            } else{
			System.out.print(String.format("| %3s " + " ", theArray[n]));
                }
            }
            System.out.println("|");
        	}
            for (int n = 0; n < 71; n++){
                System.out.print("-");
            }
            System.out.println();       
    }

    
    public static void main(String[] args) {
    	HashTable hashi = new HashTable(27);
    	
    	String str1 = "Sword";
    	String str3 = "healthPot";
    	String str4 = "WAND";
    	String str2 = "Bazooka";
    	String str5 = "KALASHNIKOV";
    	
    	
    	hashi.hashCalcEq(str1);
    	hashi.hashCalcEq(str2);
    	hashi.hashCalcEq(str3);
    	hashi.hashCalcEq(str4);
    	hashi.hashCalcEq(str5);
    	
    	hashi.insert(str1);
    	hashi.insert(str2);
    	hashi.insert(str3);
    	hashi.insert(str4);
    	hashi.insert(str5);
    	hashi.insert(str1);
    	

    	
    	hashi.findItem(str1);
    	hashi.findItem(str2);
    	hashi.findItem(str3);
    	hashi.findItem(str4);
    	hashi.findItem(str5);
    	
    	hashi.displayTheStack();
    }
}

	