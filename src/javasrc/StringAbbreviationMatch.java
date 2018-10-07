package javasrc;

public class StringAbbreviationMatch {
    public boolean match(String input, String pattern) {
        // Write your solution here
        // base case
        if (input.length() == 0 && pattern.length() == 0) {
            return true;
        }
        if (input.length() == 0 || pattern.length() == 0) {
            return false;
        }
        return match(input, pattern, 0, 0);
    }
    private boolean match(String in, String pa, int inStart, int paStart) {
        // if both hit end at same time
        if(inStart == in.length() && paStart == pa.length()) {
            return true;
        }
        // if one is done (can exceed)while the other is not
        if (inStart >= in.length() || paStart >= pa.length()) {
            return false;
        }
        // if patter[i] is character
        if (pa.charAt(paStart) > 57) {
            if (pa.charAt(paStart) == in.charAt(inStart)) {
                return match(in, pa, inStart + 1, paStart + 1);
            }
            return false;
        } else { // is pattern[i] is number
            int count = 0;
            while (paStart < pa.length() && pa.charAt(paStart) <= 57) {
                count++;
                paStart++;
            }
            int digits = Integer.parseInt(pa.substring(paStart - count, paStart));
            return match(in, pa, inStart + digits, paStart);
        }
    }
}

