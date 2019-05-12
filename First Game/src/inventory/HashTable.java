package inventory;


/*
 *  Todo
 *  
 *  Max fill HashTable to ½ arraySize
 */

public class HashTable {

	
	Item[] theArray;

	int arraySize;

	
	
	public HashTable(int size) {
		 arraySize = size;
		 theArray = new Item[size];
		 //Arrays.fill(theArray, "-1");
		// Arrays.fill(theArray, empty);
	}
	
    	

	public void insert(Item itm) {
		
        int key = findPos(itm);
       
        if(emptyIndex(key)) {
        theArray[key] = itm;
		}
        else if(notActive(itm, key)) {
        	theArray[key].countUp();
        	theArray[key].isActive = true;
        }	
        else if(isActive(key) && theArray[key].name.equals(itm.name)) {
            theArray[key].countUp();
    	}
	}
	
	
	// KAOS help me
	public void remove(Item itm) {
        
		int key = hashCalc(itm);
        
        for(int i = key; i < arraySize; i++) {
        	if(isActive(i) && theArray[i].name.equals(itm.name)) {
        		theArray[i].count--;
        		if(theArray[i].count == 0){
        			theArray[i].isActive = false;
        		}
        	}
        	if(i == arraySize) {
        		for(int j = 0; j < key; j++) {
        			if(isActive(i) && theArray[i].name.equals(itm.name)) {
                		theArray[i].count--;
                		if(theArray[i].count == 0){
                			theArray[i].isActive = false;
                		}
                	}
        		}	
        	}
        }
	}

	
	
	public int hashCalc(Item itm) {

        int hashKey = 0;
        for (int i = 0; i < itm.name.length(); i++) {
            hashKey = (hashKey * 128 + itm.name.charAt(i)) % arraySize;
        }
        return hashKey;
    }
	
	
	
	// Print String /w hashKey
	public void hashCalcEq(Item itm) {

        int hashKey = 0;
        for (int i = 0; i < itm.name.length(); i++) {
            hashKey = (hashKey * 128 + itm.name.charAt(i)) % arraySize;
        }
        System.out.println("[" + itm + "] key " + hashKey);
        System.out.println();
    }
	
	
	
	private int findPos(Item itm)
    {
        int offset = 1;
        int index = hashCalc(itm);
        
        while(theArray[index] != null && !theArray[index].name.equals(itm.name))
        {
            index += offset;
            offset += 2;
            if(index >= theArray.length){
                index -= theArray.length;
            }    
        }
        return index;
    }
	
	
	
	// look for first occurence
	public Item findItem(Item itm) {
		
		int key = hashCalc(itm);
		
		while (theArray[key] != null) {
			if (theArray[key] == itm && theArray[key].isActive) {
				System.out.println("\n" + itm.name + " * " + itm.count + " at index " + key);
				return theArray[key];
			}
			++key;
			// out of bounds -> start of array
			key %= arraySize;
		}
		// Couldn't locate the key
		System.out.println("\ncould'nt find " + itm.name);
		return null;
	}

	
	
	public boolean isActive(int index) {
        return theArray[index] != null && theArray[index].isActive;
    }
	
	
	
	public boolean notActive(Item itm, int index) {
        return theArray[index].name.equals(itm.name) && theArray[index].isActive == false;
        		//theArray[index] != null && theArray[index].isActive;
    }
	
	
	
	public boolean emptyIndex(int index) {
		return theArray[index] == null;
	}
	
	
	
    public void displayTheStack() {
    	for(int i = 0; i < 27; i ++) {
    		if(theArray[i] != null) {
    		System.out.println(i + " [" + theArray[i] + "]*" + theArray[i].count + ", isActive: " + theArray[i].isActive);
    		}
    	}
    }

    
    
    public static void main(String[] args) {
    	HashTable hashi = new HashTable(27);
    
    	Item sw = new Item("Sword");
    	Item hp = new Item("healthPot");
    	Item wa = new Item("WAND");
    	Item ba = new Item("Bazooka");
    	Item ka = new Item("KALASHNIKOV");
    	
    	
    	hashi.hashCalcEq(sw);
    	hashi.hashCalcEq(hp);
    	hashi.hashCalcEq(wa);
    	hashi.hashCalcEq(ba);
    	hashi.hashCalcEq(ka);
    	
    	hashi.insert(sw);
    	hashi.insert(hp);
    	hashi.insert(hp);
    	hashi.insert(hp);
    	hashi.insert(hp);
    	hashi.insert(hp);
    	hashi.insert(wa);
    	hashi.insert(ba);
    	hashi.insert(ka);
    	
    	hashi.findItem(sw);
    	hashi.findItem(hp);
    	hashi.findItem(wa);
    	hashi.findItem(ba);
    	hashi.findItem(ka);
    	//System.out.println(sw.howMany());
    	
    	hashi.displayTheStack();
    	
    	//hashi.remove(hp);
    	//hashi.findItem(hp);
    	//hashi.remove(hp);
    	//hashi.remove(hp);
    	hashi.remove(hp);
    	hashi.remove(hp);
    	hashi.remove(hp);
    	hashi.remove(hp);
    	//hashi.remove(hp);
    	
    	hashi.displayTheStack();
    }
}

	