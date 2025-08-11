class Solution {
    public int[] productQueries(int n, int[][] queries) {

        final int MOD = 1_000_000_007; 
        


        int result[] = new int[queries.length];

        List<Long> powers = new ArrayList<>();

        int x = (int)Math.sqrt(n);
        int sum = 0;
        for(int i = x ; i>=0 ; i--){
            if((sum + (int)Math.pow(2,i)) <= n){
                sum = sum + (int)Math.pow(2,i);
                powers.add((long)Math.pow(2,i));
            }
        }

        Collections.sort(powers);

        int index = 0 ;
        for(int i = 0 ; i<queries.length ; i++){

            int left = queries[i][0];
            int right = queries[i][1];

            long product = 1 ;
            for(int j = left ; j<=right ; j++){
                product = (product *  powers.get(j)) % MOD;
            }
            result[index] = (int)product ;
            index++;
        } 

        return result ;
        
    }
}