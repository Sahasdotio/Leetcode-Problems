class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int c = 0;
        int li = nums[0],ri = nums[2];
        boolean va = false,hi = false;
        for(int i=1;i<n-1;i++){
            if(nums[i] != nums[i-1]){
                li = nums[i-1];
            }
            if(nums[i] == nums[i+1]){
                for(int j=i+2;j<n;j++){
                    if(nums[j] != nums[i]){
                        ri = nums[j];
                        break;
                    }
                }
            }
            else{
                ri = nums[i+1];
            }
            if((nums[i]>li && nums[i]>ri)){
                if(!hi){
                    c++;
                }
                hi = true;
                va = false;
            }
            else if((nums[i]<li && nums[i]<ri)){
                if(!va){
                    c++;
                }
                va = true;
                hi = false;
            }
        }
        return c;
    }
}