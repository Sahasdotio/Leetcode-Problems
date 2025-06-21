class Solution {
    public int minimumDeletions(String word, int k) {
        int[] frq = new int[26];
        for (char c : word.toCharArray()) {
            frq[c - 'a']++;
        }

        List<Integer> freqList = new ArrayList<>();
        for (int f : frq) {
            if (f > 0) {
                freqList.add(f);
            }
        }

        if (freqList.isEmpty()) return 0;

        Collections.sort(freqList, Collections.reverseOrder());
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < freqList.size(); i++) {
            int target = freqList.get(i);
            int d = 0;
            for (int j = 0; j < freqList.size(); j++) {
                int freq = freqList.get(j);
                if (freq > target + k) {
                    d += freq - (target + k);
                } else if (freq < target) {
                    d += freq;
                }
            }
            ans = Math.min(ans, d);
        }

        return ans;
    }
}