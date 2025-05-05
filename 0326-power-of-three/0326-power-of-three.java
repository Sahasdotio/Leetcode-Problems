class Solution {
    public boolean isPowerOfN(int n, int base) {
        return Integer.toString(n, base).matches("10*");
    }
    public boolean isPowerOfThree(int n) {
        return isPowerOfN(n, 3);
    }
}