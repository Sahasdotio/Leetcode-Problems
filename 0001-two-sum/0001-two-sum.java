import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a map to store numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // If the complement exists in the map, return the pair of indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }
        
        // If no solution is found (although the problem guarantees one solution)
        throw new IllegalArgumentException("No solution found");
    }
}
