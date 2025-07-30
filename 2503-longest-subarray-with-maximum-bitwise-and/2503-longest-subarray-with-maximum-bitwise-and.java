class Solution {
    public int longestSubarray(int[] nums) {
        int max[]={0,0};
        int ans=0;
        int r=0;
        while(r<nums.length){
            int num=nums[r];
            int cnt=0;
            while(r<nums.length&&nums[r]==num){
                cnt++;
                r++;
            }
            if(num>max[0]){
            ans=cnt;
            max[0]=num;
            max[1]=cnt;
            }
            else if(num==max[0]){
                if(cnt>max[1]){
                    ans=cnt;
                    max[1]=cnt;
                }
            }
        }
        return ans;
    }
}