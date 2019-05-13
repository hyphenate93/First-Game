package inventory;


import org.junit.Assert;
import org.junit.Test;
	
	
public class HashTableJunit {
	

		
	    @Test
	    public void insertTest() 
	    {
	    	HashTable HT = new HashTable(27);
	    	Item test = new Item("test");
	    	Item in = new Item("insert");
	    	Item hej = new Item("hej");
	    	Item ok = new Item("ok");
	        for(int i = 0; i < 7; i++)
			{
	        	HT.insert(test);
			}        
	        HT.insert(in);
	        HT.insert(hej);
	        HT.insert(ok);
	        Assert.assertTrue("Contains Item", HT.contains(test));
	        Assert.assertTrue("Contains Item", HT.getIndex(test) == 4);
	        Assert.assertTrue("Contains Item", HT.contains(in));
	        Assert.assertTrue("Contains Item", HT.contains(hej));
	        Assert.assertTrue("Contains Item", HT.contains(ok));
	        Assert.assertTrue("Contains Item", HT.getItem(ok).isActive == true);
	        Assert.assertEquals("Check if there's 7 'test' in array" , HT.size(), 10);
			Assert.assertEquals("Check if there's 7 'test' in array" , HT.getItem(test).count, 7);
			Assert.assertEquals("Check if there's 7 'test' in array" , HT.getItem(hej).count, 1);
			for(int i = 0; i < 7; i++)
			{
	        	HT.remove(test);
			}        
	        HT.remove(in);
	        HT.remove(hej);
	        HT.remove(ok);
	    }

	    
	    @Test
	    public void removeTest() 
	    {
	    	HashTable HT = new HashTable(27);
	    	Item test = new Item("test");
	    	for(int i = 0; i < 7; i++)
			{
	        	HT.insert(test);
			}   
	    	Assert.assertEquals("Check if there's 7 'test' in array" , HT.size(), 7);
	    	Assert.assertEquals("Check if there's 7 'test' in array" , HT.getItem(test).count, 7);
	    	Assert.assertTrue("Contains Item", HT.getItem(test).isActive == true);
	    	for(int i = 0; i < 10; i++)
			{
	        	HT.remove(test);
			}
	    	Assert.assertEquals("Check if there's 7 'test' in array" , HT.size(), 0);
	    	Assert.assertTrue("Contains Item", HT.getItem(test).count == 0);
	    	Assert.assertTrue("Contains Item", HT.getItem(test).isActive == false);
	    }
	    
	    
	    
	    @Test
	    public void getItemTest() 
	    {
	    	HashTable HT = new HashTable(27);
	    	Item test = new Item("test");
	    }

}

