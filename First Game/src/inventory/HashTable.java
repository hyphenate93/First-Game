package inventory;


/*
 *  Todo
 *  
 *  Max fill HashTable to ½ arraySize
 */

public class HashTable {

	
	Item[] theArray;

	int arraySize;
	static int numOfItems;

	
	
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
        numOfItems++;
		}
        else if(notActive(itm, key)) {
        	theArray[key].countUp();
        	theArray[key].isActive = true;
        	numOfItems++;
        }	
        else if(indexActive(key) && theArray[key].name.equals(itm.name)) {
            theArray[key].countUp();
            numOfItems++;
    	}
	}
	
	
	// KAOS help me
	public void remove(Item itm) {
        
		int key = hashCalc(itm);
        
        for(int i = key; i < arraySize; i++) {
        	if(indexActive(i) && theArray[i].name.equals(itm.name)) {
        		theArray[i].count--;
        		numOfItems--;
        		if(theArray[i].count == 0){
        			theArray[i].isActive = false;
        		}
        	}
        	if(i == arraySize) {
        		for(int j = 0; j < key; j++) {
        			if(indexActive(i) && theArray[i].name.equals(itm.name)) {
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
	
	
	
	public int findPos(Item itm){
       
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
	
	
	

	public Item getItem(Item itm) {
		
		int key = hashCalc(itm);
		
		while (theArray[key] != null) {
			if (notActive(itm, key) || isActive(itm, key)) {
				return theArray[key];
			}
			++key;
			// out of bounds -> start of array
			key %= arraySize;
		}
		// Couldn't locate the key
		return null;
	}

	
	
	public int getIndex(Item itm) {
		
		int key = hashCalc(itm);
		
		while (theArray[key] != null) {
			if (theArray[key] == itm && theArray[key].isActive) {
			return key;
		}
		++key;
		// out of bounds -> start of array
		key %= arraySize;
	}
	// Couldn't locate the key
	return -1;
	}
	
	
	
	public boolean contains(Item itm){
        int key = findPos(itm);
        return isActive(itm, key);
    }
	
	
	
	public boolean indexActive(int index) {
        return theArray[index] != null && theArray[index].isActive;
    }
	
	
	
	public boolean isActive(Item itm, int index) {
        return theArray[index].name.equals(itm.name) && theArray[index].isActive == true;
    }
	
	
	
	public boolean notActive(Item itm, int index) {
        return theArray[index].name.equals(itm.name) && theArray[index].isActive == false;
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
    	
    	hashi.getItem(sw);
    	hashi.getItem(hp);
    	hashi.getItem(wa);
    	hashi.getItem(ba);
    	hashi.getItem(ka);
    	//System.out.println(sw.howMany());
    	System.out.println(hashi.contains(hp));
    	hashi.displayTheStack();
    	System.out.println(numOfItems);
    	//hashi.remove(hp);
    	//hashi.findItem(hp);
    	//hashi.remove(hp);
    	//hashi.remove(hp);
    	hashi.remove(hp);
    	hashi.remove(hp);
    	hashi.remove(hp);
    	hashi.remove(hp);
    	System.out.println(hashi.contains(hp));
    	hashi.remove(hp);
    	hashi.getItem(hp);
    	System.out.println(hashi.contains(hp));
    	hashi.displayTheStack();
    }
}

	