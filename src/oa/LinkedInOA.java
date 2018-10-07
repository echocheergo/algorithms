package oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LinkedInOA {
    public void LinkedInOA(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> map1 = new HashMap<>();
        for (Integer i: arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Integer i: map.keySet()) {
            if (!map1.containsKey(map.get(i))) {
                map1.put(map.get(i), new ArrayList<>());
            }
            map1.get(map.get(i)).add(i);
        }
        List<Integer> sortedCount = new ArrayList<>(map1.keySet());
        Collections.sort(sortedCount);
        for (Integer count: sortedCount) {
            for (Integer num: map1.get(count)) {
                for (int i = 0; i < count; i++) {
                    res.add(num);
                    System.out.print(num);
                    System.out.print(", ");
                }
            }
        }
    }
}
