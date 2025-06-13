class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFormPairs(nums, p, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean canFormPairs(int[] nums, int requiredPairs, int maxDiff) {
        int pairs = 0;
        for (int i = 0; i < nums.length - 1 && pairs < requiredPairs; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                pairs++;
                i++; 
            }
        }
        return pairs >= requiredPairs;
    }
}