class Solution {
    public int numberOfWays(int n, int x) {
        int mod = 1_000_000_007;

        java.util.List<Integer> powers = new java.util.ArrayList<>();
        int i = 1;
        while (true) {
            long pow = (long) Math.pow(i, x);
            if (pow <= n) {
                powers.add((int) pow);
            } else {
                break;
            }
            i++;
        }

        int[][] dp = new int[powers.size()][n + 1];

        dp[0][0] = 1;
        if (powers.get(0) <= n) {
            dp[0][powers.get(0)] = 1;
        }
        for (int j = 0; j < n + 1; j++) {
            if (j != 0 && j != powers.get(0)) {
                dp[0][j] = 0;
            }
        }


        for (i = 1; i < powers.size(); i++) {
            for (int j = 0; j <= n; j++) {
                if (j < powers.get(i)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - powers.get(i)]) % mod;
                }
            }
        }

        return dp[powers.size() - 1][n];
    }
}