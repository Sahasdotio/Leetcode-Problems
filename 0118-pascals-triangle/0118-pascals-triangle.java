class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> pa=new ArrayList<>();
        
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        pa.add(arr);
        if(n==1){
        return pa;}

        int i=1;
        while(i<n){
            List<Integer> prev=pa.get(i-1);
            int l=prev.size();
            ArrayList<Integer> ne =new ArrayList<>();
                ne.add(1);
                for(int j=0;j<l-1;j++){
                    if(i>=2){
                        int sum=prev.get(j)+prev.get(j+1);
                        ne.add(sum);
                    }
                }
                ne.add(1);
                pa.add(ne);
                i++;
        }
        return pa;

        
        
        
    }
}