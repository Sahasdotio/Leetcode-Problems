class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] setbit = new int[32];
       
       
        Arrays.fill(setbit, -1);
        for (int i = n - 1; i >= 0; i--) {
            int maxend = i;
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    setbit[j] = i;
                }
            }
            for (int j = 0; j < 32; j++) {
                if (setbit[j] != -1) {
                    maxend = Math.max(maxend, setbit[j]);
                }
            }
            res[i] = maxend - i + 1;
        }
        return res;
    }
}