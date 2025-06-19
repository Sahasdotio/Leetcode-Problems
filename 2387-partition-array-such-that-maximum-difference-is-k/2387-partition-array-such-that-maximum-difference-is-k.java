class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt=0;
        int mini=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]-mini>k){
                mini=nums[i];
                cnt++;
            }
        }
        return cnt+1;
    }
}