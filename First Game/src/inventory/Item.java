package inventory;


public class Item
{
    public String name;
    public int count;
    public boolean isActive;
    
    
    public Item(String name) {
        this(name, 1, true);
    }

    public Item(String str, int i, boolean b) {
        name     = str;
        count = i;
        isActive = b;
    }
        
    public void countUp() {
    	count++;
    }
    
    public String toString() {
    	return name;
    }
}