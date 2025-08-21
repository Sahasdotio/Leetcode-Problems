class Solution {
    private int countRectangles(int[] height) {
        int n = height.length;
        int[] sum = new int[n];
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && height[st.peek()] >= height[i])
                st.pop();
            if (!st.isEmpty()) {
                int prev = st.peek();
                sum[i] = sum[prev] + height[i] * (i - prev);
            } else {
                sum[i] = height[i] * (i + 1);
            }
            st.push(i);
            res += sum[i];
        }
        return res;
    }

    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] height = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
            }
            res += countRectangles(height);
        }
        return res;

        
    }
}