package java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    int slow = 0;
    int fast = 0;
    public List<Integer> allAnagrams(String sh, String lo) {
        // Write your solution here

        List<Integer> res = new ArrayList<>();
        if (lo.length() == 0 || lo.length() < sh.length()) {
            return res;
        }
        // sliding window by two pointers(included), expand f till length > target, move s to fast++ when char not in map
        // move s to nearest char c if c violates number
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] s = sh.toCharArray();
        char[] l = lo.toCharArray();
        for (char c : s) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int width = s.length;

        while (fast < l.length) {
            checkStatus(l, map, window, width, res);
        }
        return res;
    }
    private void checkStatus(char[] l, Map<Character, Integer> map, Map<Character, Integer> window, int width, List<Integer> res) {
        // check l[fast] legitimacy
        if (!map.containsKey(l[fast])) {// alien char
            fast++;
            slow = fast;
            for (Map.Entry<Character, Integer> entry : window.entrySet()) {
                window.put(entry.getKey(), 0);
            }

            //window.forEach((k,v) -> window.put(k, 0));
            return;
        } else if ((window.getOrDefault(l[fast], 0) + 1) > map.get(l[fast])) { // extra char
            while (l[slow] != l[fast]) {//update window_map by moving slow up to the type of char violating
                window.put(l[slow], window.get(l[slow])- 1);
                slow++;
            }
            window.put(l[slow], window.get(l[slow])- 1);
            slow++;
        }
        // check length
        window.put(l[fast], window.getOrDefault(l[fast], 0) + 1);
        if (fast - slow == width - 1) {
            res.add(slow);
            window.put(l[slow], window.get(l[slow])- 1);
            slow++;
        }
        fast++;
    }
}



