class Solution {
    public int maxDistance(String s, int k) {
        int N=0,S=0,E=0,W = 0;
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'N')
                N++;
            else if(c == 'E')
                E++;
            else if(c == 'W')
                W++;                
            else if(c == 'S')
                S++;          
            
            int one = Math.min(Math.min(N,S), k);
            int two = Math.min(Math.min(E,W), k-one);

            ans = Math.max(ans, Math.abs(N-S) + one*2 + Math.abs(E-W) + two*2);      
        }

        return ans;

    }
}