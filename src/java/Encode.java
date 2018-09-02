package java;

import java.util.ArrayList;

public class Encode {
    public String encode(String input) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] arr = input.toCharArray();
        return replace(arr);
    }
    private String replace(char[] arr) {
        ArrayList<Integer> matchInd = getAllMatches(arr);
        char[] res = new char[arr.length + matchInd.size() * 2];
        // two pointers, slow for new (right are processed, not including slow), fast for original arr, both from right to left
        int lastInd = matchInd.size() - 1;
        int fast = arr.length - 1;
        int slow = res.length - 1;
        while (fast >= 0) {
            if (lastInd >= 0 && fast == matchInd.get(lastInd)) {
                copySubstring(res, slow - 2);
                slow -= 3;
                fast--;
                lastInd--;
            } else {
                res[slow--] = arr[fast--];
            }
        }
        return new String(res);
    }
    private void copySubstring(char[] res, int startInd) {
        res[startInd] = '2';
        res[startInd + 1] = '0';
        res[startInd + 2] = '%';
    }
    private ArrayList<Integer> getAllMatches(char[] arr) {
        ArrayList<Integer> matches = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                matches.add(i);
            }
        }
        return matches;
    }
}
