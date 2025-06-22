class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() == k) {
                result.add(sb.toString());
                sb.setLength(0); 
            }
        }

        if (sb.length() != 0) {
            while (sb.length() < k) {
                sb.append(fill);
            }
            result.add(sb.toString());
        }

        return result.toArray(new String[0]);
    }
}