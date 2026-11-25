package Number_of_Students_Unable_to_Eat_Lunch;

public class Solution1 {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] arr = new int[2];
        
        for(int ele: students) {
        	arr[ele]++;
        }
        
        int n = sandwiches.length;
        for(int i=0;i<n;i++) {
        	int sandwich = sandwiches[i];
        	if(arr[sandwich] == 0) {
        		return n-i;
        	}
        	arr[sandwich]--;
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
    	int[] students = {1,1,1,0,0,1}; 
    	int[] sandwiches = {1,0,0,0,1,1};

    	Solution1 sol1 = new Solution1();
    	System.out.println("Output: " + sol1.countStudents(students, sandwiches));
	}

}
