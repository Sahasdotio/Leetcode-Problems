class Solution {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);

        char[] maxChars = numStr.toCharArray();
        char toReplaceMax = 0;
        for (char c : maxChars) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }
        String maxStr = numStr;
        if (toReplaceMax != 0) {
            maxStr = numStr.replace(toReplaceMax, '9');
        }
        char[] minChars = numStr.toCharArray();
        char toReplaceMin = 0;
        for (char c : minChars) {
            if (c != '0') {
                toReplaceMin = c;
                break;
            }
        }
        String minStr = numStr;
        if (toReplaceMin != 0) {
            minStr = numStr.replace(toReplaceMin, '0');
        }

        int maxNum = Integer.parseInt(maxStr);
        int minNum = Integer.parseInt(minStr);

        return maxNum - minNum;
    }
}