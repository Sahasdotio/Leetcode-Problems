import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> current = new HashSet<>();
        
        for (int num : arr) {
            Set<Integer> newCurrent = new HashSet<>();
            newCurrent.add(num);
            for (int val : current) {
                newCurrent.add(val | num);
            }
            current = newCurrent;
            result.addAll(current);
        }
        
        return result.size();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 4};
        System.out.println(sol.subarrayBitwiseORs(arr));  // Output: 6
    }
}