class Solution {
    public int numSubseq(int[] nums, int target) {
        // We need to find all comibnations of max and mins,
        // and count the subsequences where max + min <= target

        // By sorting, we get all mins on the left
        // and all maxes on the right
        Arrays.sort(nums);

        int n = nums.length, mod = 1000000007, count = 0;
        int[] twoRaisedTo = new int[n];

        twoRaisedTo[0] = 1;

        for (int pow = 1; pow < n; pow++) {
            // Preprocess all powers of 2 upto n
            // with mod 10^9 + 7
            twoRaisedTo[pow] = (twoRaisedTo[pow - 1] * 2) % mod;
        }

        for (int min = 0, max = n - 1; min <= max;) {
            // Why this works:
            // The i'th minimum number will be the smallest number in all subsequences
            // of sizes from 1 to n - i

            // So, the 1st smallest number, will be the smallest in all subsequences from
            // 1 to n - 1

            // Similarly, the i'th maximum number will be the largest number in all
            // subsequences of sizes from 1 to n - i

            // So, the 1st largest nunber, will be the largest in all subsequences from
            // 1 to n - 1

            if (nums[min] + nums[max] <= target) {
                // This combination of min and max works,
                // so add the subsequences to the count,
                // then move to the next min number
                count = (count + twoRaisedTo[max - min]) % mod;
                min++;
            }       
            else {
                // Value is more than required,
                // so reduce the max number
                max--;
            }     
        }

        return count;
    }
}