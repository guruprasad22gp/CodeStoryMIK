package Destination_City;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
	public static void main(String[] args) {
		List<List<String>> paths = new ArrayList<>(
			    Arrays.asList(
			        Arrays.asList("London", "New York"),
			        Arrays.asList("New York", "Lima"),
			        Arrays.asList("Lima", "Sao Paulo")
			    )
			);
		
		Solution1 m = new Solution1();
		System.out.println("Output: " + m.destCity(paths));
	}
	
    public String destCity(List<List<String>> paths) {
        HashMap<String, Integer> map = new HashMap<>();
        for(List<String> ls: paths) {
        		String u = ls.get(0);
        		map.put(u, map.getOrDefault(u, 0)+1);
        }
        
        for(List<String> ls: paths) {
	    		String v = ls.get(1);
	    		if(!map.containsKey(v)) {
	    			return v;
	    		}
	    }
        
        return "";
    }
}
