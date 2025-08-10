class Solution {
    public boolean Po2(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return Po2(n / 2);
    }
    public static boolean isShuffle(int a, int b) {
        char[] arr1 = String.valueOf(a).toCharArray();
        char[] arr2 = String.valueOf(b).toCharArray();

        if (arr1.length != arr2.length) return false;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public boolean reorderedPowerOf2(int n) {
        for (int i = 0; i < 31; i++) { 
            int powerOfTwo = 1 << i;
            if (isShuffle(n, powerOfTwo)) {
                return true;
            }
        }
        return false;
    }
}