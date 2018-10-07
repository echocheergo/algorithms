package javasrc;

import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,ArrayList<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            ArrayList<String> l = map.get(temp);
            if(l == null) {
                l = new ArrayList<>();
                l.add(s);
                map.put(temp,l);
            } else {
                l.add(s);
                map.put(temp,l);
            }

        } // can use map update value
        List<List<String>> ret = new ArrayList<>(map.values());
        return ret;
    }
}
