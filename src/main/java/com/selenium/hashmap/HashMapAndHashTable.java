package com.selenium.hashmap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;

public class HashMapAndHashTable {
	public static void main(String[] args) {
		
		
		/*HashMap<String,String > hashMap = new HashMap<String, String>();
		
		hashMap.put("Toy", "Airplane");
		hashMap.put("Animal", "Lion");
		hashMap.put("Train", "Train18");
		hashMap.put("Plane", "Boeing");
		hashMap.put(null, "Lockheed Martin");
		hashMap.put(null, "GSDGsa");
		//hashMap.put(null, null);
		
		for (Entry<String, String> m:hashMap.entrySet()) { 
            System.out.println(m.getKey()+" "+m.getValue()); 
        }
		*/
		
		Hashtable< String, String> hashtable = new Hashtable<String, String>();
		
		hashtable.put("Toy", "Airplane");
		hashtable.put("Animal", "Lion");
		hashtable.put("Train", "Train18");
		hashtable.put("Plane", "Boeing");
		hashtable.put(null, "Lockheed Martin");
		hashtable.put(null, "GSDGsa");
		
		for (Entry<String, String> m:hashtable.entrySet()) { 
            System.out.println(m.getKey()+" "+m.getValue()); 
        }
		
		
	}

}
