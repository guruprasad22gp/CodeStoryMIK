package Destination_City;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution2 {
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
    		HashSet<String> set = new HashSet<>();
    		for(List<String> ls: paths) {
    			set.add(ls.get(0));
    		}
    		
    		for(List<String> ls: paths) {
    			if(!set.contains(ls.get(1))) {
    				return ls.get(1);
    			}
    		}
    		
    		return "";
    }
}
