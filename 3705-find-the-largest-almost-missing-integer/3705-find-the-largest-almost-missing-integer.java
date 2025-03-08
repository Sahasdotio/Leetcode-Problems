class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> subc = new HashMap<>();
        
        for (int i = 0; i <= n - k; i++) {
            Set<Integer> uniqueNums = new HashSet<>();
            for (int j = i; j < i + k; j++) uniqueNums.add(nums[j]);
            
            for (int num:uniqueNums) subc.put(num, subc.getOrDefault(num, 0) + 1);
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : subc.entrySet()) {
            if (entry.getValue() == 1 && entry.getKey() > ans) ans = entry.getKey();
        }        
        return ans;
    }
}