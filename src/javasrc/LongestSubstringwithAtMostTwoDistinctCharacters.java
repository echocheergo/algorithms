package javasrc;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public int LongestSubstringwithAtMostTwoDistinctCharacters(String s) {
        int left1 = -1;
        int left2 = -1;
        int len = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (left1 == -1 || s.charAt(i) == s.charAt(left1)) {
                left1 = i;
                len++;
                max = Math.max(max, len);
            } else if (left2 == -1 || s.charAt(i) == s.charAt(left2)) {
                left2 = i;
                len++;
                max = Math.max(max, len);
            } else {
                if (left1 < left2) {
                    len = i - left1;
                    left1 = i;
                } else {
                    len = i - left2;
                    left2 = i;
                }
            }
        }
        return max;
    }
}
