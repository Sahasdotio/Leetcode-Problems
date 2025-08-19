class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0;
        int curr=0, prev=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i+1]==0 && nums[i]==0)
            {
                prev++;
                count=count+prev;
            }
            else{
                prev=0;
            }
        }

        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                count++;
            }
        }

        return count;
    }
}