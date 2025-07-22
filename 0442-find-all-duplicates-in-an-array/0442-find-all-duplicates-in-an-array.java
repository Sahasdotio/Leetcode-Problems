class Solution {
    public List<Integer> findDuplicates(int[] nums) {
                int i=0;
        while(i< nums.length){
            int correctindex=nums[i]-1;
            if(nums[i]!=nums[correctindex]){
                swapped(nums,i,correctindex);
            }
            else {
                i++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                list.add(nums[j]);
            }
        }
        return list;

    }
    static void swapped(int[] nums,int first,int seccond){
        int temp= nums[first];
        nums[first]=nums[seccond];
        nums[seccond]=temp;

    }



}