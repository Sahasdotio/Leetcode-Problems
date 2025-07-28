class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxBitWiseOr = 0;
        for (var num : nums) {
            maxBitWiseOr |= num;
        }
        
        int n = nums.length;
        int res = 0;
        for (int subset = 0; subset < (1 << n); subset++) {
            int currBitWiseOr = 0;
            for (int i = 0; i < n; i++) {
                int mask = 1 << i;
                if ((mask & subset) != 0) {
                    currBitWiseOr |= nums[i];
                }
            }

            if (currBitWiseOr == maxBitWiseOr) {
                res++;
            }
        }

        return res;
    }
}