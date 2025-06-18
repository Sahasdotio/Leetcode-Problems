import java.util.*;

public class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int nSlices = n / 3;
        int nSliceElements = 3;

        int[][] result = new int[nSlices][nSliceElements];

        for (int i = 0; i < nSlices; i ++) {
            if (Math.abs(nums[i * nSliceElements] - nums[i * nSliceElements + nSliceElements - 1]) > k) {
                return new int[0][0];
            }

            for (int j = 0; j < nSliceElements; j++) {
                result[i][j] = nums[i * nSliceElements + j];
            }
        }

        return result;
    }
}