class Solution {
    public int maximumGain(String s, int x, int y) {

        // Decide which pattern gives more points
        byte c1 = 'a', c2 = 'b';
        if(x < y){
            // Swap if "ba" is more valuable than "ab"
            c1 = 'b';
            c2 = 'a';

            int temp = x;
            x = y;
            y = temp;
        }

        int n = s.length();

        // Convert string to byte array for performance
        byte[] cs = new byte[n];
        s.getBytes(0, n, cs, 0);  // Fill cs with byte values of chars

        int count1 = 0, count2 = 0;  // Counters for c1 and c2
        int ans = 0;

        for(byte c : cs){
            if(c == c1) {
                // Count c1 when seen
                count1++;
            } else if(c == c2){
                if(count1 > 0){
                    // Found a matching c1-c2 pair: remove and score
                    count1--;
                    ans += x;
                } else {
                    // No pair yet, just count c2
                    count2++;
                }
            } else {
                // Flush any unpaired c1/c2 and score lower point matches
                ans += Math.min(count1, count2) * y;
                count1 = 0;
                count2 = 0;
            }
        }

        // Flush any remaining c1/c2 matches at the end
        ans += Math.min(count1, count2) * y;

        return ans;
    }
}