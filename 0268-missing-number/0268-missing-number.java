class Solution {
    public int missingNumber(int[] arr) {
        int i=0;
        while(i<arr.length){
            //int correct = arr[i];
            if(arr[i]<arr.length && arr[i]!=arr[arr[i]]){
                int temp=arr[i];
                arr[i]=arr[temp];
                arr[temp]=temp;
            }
            else{
                i++;
            }
        }

        for(int j=0;j<arr.length;j++){
            if(arr[j]!=j){
                return j;
            }
            
        }
        return arr.length;
    }
}

