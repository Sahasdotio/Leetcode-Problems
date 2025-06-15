class Solution {
    public int maxDiff(int num) {
        List<Integer> list1 = new ArrayList<>();
        int temp = num;
        while (temp > 0) {
            int mod = temp % 10;
            list1.add(0, mod);
            temp /= 10;
        }

        int firstNonNine = -1;
        for (int i : list1) {
            if (i != 9) {
                firstNonNine = i;
                break;
            }
        }
        int max = 0;
        for (int i : list1) {
            if (i != firstNonNine) {
                max = max * 10 + i;
            } else {
                max = max * 10 + 9;
            }
        }

        int min = 0;
        if (list1.get(0) == 1) {
            int firstNonOne = -1;
            for (int i : list1) {
                if (i != 1 && i!=0) {
                    firstNonOne = i;
                    break;
                }
            }

            for (int i : list1) {
                if (i != firstNonOne) {
                    min = min * 10 + i;
                } else {
                    min = min * 10 + 0;
                }
            }
        }
        else{
            int secondTimeOne=list1.get(0);
            for (int i : list1) {
                if (i != secondTimeOne) {
                    min = min * 10 + i;
                } else {
                    min = min * 10 + 1;
                }
            }
        }

        return max-min;
    }
}