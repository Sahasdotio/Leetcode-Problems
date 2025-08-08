class Solution {
    static int[][] soup = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};

    public double soupServings(int n) {
        if(n >= 4800) return 1.0;

        double dp[][] = new double[n+1][n+1];
        for(double[] arr : dp) {
            Arrays.fill(arr, -1.0);
        }

        return findProbability(n, n, dp);
    }

    double findProbability(int A, int B, double[][] dp) {
        if(A <= 0 && B <= 0) return 0.5;
        if(A <= 0) return 1.0;
        if(B <= 0) return 0.0;

        if(dp[A][B] != -1) {
            return dp[A][B];
        }

        double prob = 0.0;
        for(int s[] : soup) {
            int A_taken = s[0];
            int B_taken = s[1];

            prob += findProbability(A-A_taken, B-B_taken,dp);
        }

       
        return dp[A][B] = 0.25 * prob;
    }
}