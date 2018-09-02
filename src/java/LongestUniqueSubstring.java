package java;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
    public int longest(String input) {
        // Write your solution here
        if (input.length() == 0) {
            return 0;
        }
        int global_max = 0;
        int slow = 0;
        char[] arr = input.toCharArray();
        // build hashmap to record frequency
        Map<Character, Integer> map = new HashMap<>();
        int fast = 0;
        for (; fast < arr.length; fast++) {
            map.put(arr[fast], map.getOrDefault(arr[fast], 0) + 1);
            if (map.get(arr[fast]) > 1) {
                if (global_max == 0) {
                    global_max = fast - slow;
                } else {
                    global_max = Math.max(global_max, fast - slow);
                }
                while (arr[slow] != arr[fast]) {
                    map.put(arr[slow], 0);
                    slow++;
                }
                map.put(arr[slow], 1);
                slow++;
                global_max = Math.max(global_max, fast - slow + 1);
            }
        }
        global_max = Math.max(global_max, fast - slow);
        return global_max;

    }
}
