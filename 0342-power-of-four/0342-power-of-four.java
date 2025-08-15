class Solution {
    public boolean isPowerOfFour(int n) {
        if (n < 1 || (n & (n-1)) != 0) return false; // must have only one bit
        while (n > 0) {
            if ((n & 1) == 1) return true;
            n >>= 2;
        }
        return false;
    }
}