import java.util.*;
class Solution {
    public String largestGoodInteger(String num) {
        char best = 0;
        int n = num.length();
        for(int i=0; i<n-2; i++){
            char c = num.charAt(i);
            if(c==num.charAt(i+1) && num.charAt(i+1) == num.charAt(i+2)){
                if (c > best) best = c;
            }
        } 
        String s = String.valueOf(best);
        return best==0?"":s+s+s;
    }
    
}