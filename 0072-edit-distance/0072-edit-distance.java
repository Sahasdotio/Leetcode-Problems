class Solution {

    //using single 1D
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n == 0) return m;
        if (m == 0) return n;
        if (word2.equals(word1)) return 0;

        int[] dp = new int[word2.length() + 1];
        for (int i = 0; i <= m; i++) {
            dp[i] = i;
        }
       
        
        for (int i = 1; i <= n; i++) {
            int prev = dp[0];
            dp[0] = i;
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    int insert = 1 + dp[j - 1];
                    int replace = 1 + prev;
                    int delete = 1 + dp[j];
                    dp[j] = Math.min(replace, Math.min(delete, insert));
                } else {
                    dp[j] = prev;
                }
                prev = temp;
            }
        }

        return dp[m];
    }

    public int minDistanceTwo1D(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n == 0) return m;
        if (m == 0) return n;
        if (word2.equals(word1)) return 0;

        int[] prev = new int[word2.length() + 1];
        for (int i = 0; i <= m; i++) {
            prev[i] = i;
        }
       
        
        for (int i = 1; i <= n; i++) {
            int[] cur = new int[word2.length() + 1];
            cur[0] = i;
            for (int j = 1; j <=m; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    int insert = 1 + cur[j - 1];
                    int replace = 1 + prev[j - 1];
                    int delete = 1 + prev[j];
                    cur[j] = Math.min(replace, Math.min(delete, insert));
                } else {
                    cur[j] = prev[j - 1];
                }
            }
            prev = cur;
        }

        return prev[m];
    }

    public int minDistanceBU(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        if (word2.equals(word1)) {
            return 0;
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    int insert = 1 + dp[i][j - 1];
                    int replace = 1 + dp[i - 1][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    dp[i][j] = Math.min(replace, Math.min(delete, insert));
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][m];
    }

    public int minDistanceTD(String word1, String word2) {

        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        for (int[] mem : memo)
            Arrays.fill(mem, -1);

        int w1Len = word1.length();
        int w2Len = word2.length();
        return dp(word1, word2, w1Len - 1, w2Len - 1, memo);
    }

    private int dp(String s1, String s2, int i1, int i2, int[][] memo) {
        if (i1 < 0)
            return i2 + 1;
        if (i2 < 0)
            return i1 + 1;

        if (memo[i1][i2] != -1)
            return memo[i1][i2];

        if (s1.charAt(i1) == s2.charAt(i2)) {
            memo[i1][i2] = dp(s1, s2, i1 - 1, i2 - 1, memo);
        } else {
            int insert = 1 + dp(s1, s2, i1 - 1, i2, memo);
            int replace = 1 + dp(s1, s2, i1 - 1, i2 - 1, memo);
            int delete = 1 + dp(s1, s2, i1, i2 - 1, memo);
            memo[i1][i2] = Math.min(replace, Math.min(delete, insert));
        }
        return memo[i1][i2];
    }
}