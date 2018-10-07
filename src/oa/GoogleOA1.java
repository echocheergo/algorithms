package oa;

import java.util.HashMap;
import java.util.Map;

// assumption all email addresses are legal
// for each email address, split first into local and domain part
// for local, first remove everything after the first +
// then split on . and combine
// append back domain part
// store in hashmap
// TEST: case sensitive or not
public class GoogleOA1 {
    public int GoogleOA1 (String[] input) {
        int res = 0;
        if (input == null || input.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : input) {
            String postS = process(s);

            map.put(postS, map.getOrDefault(postS , 0) + 1);
        }
        for (Integer value : map.values() ) {
            if (value > 1) {
                res++;
            }
        }
        return res;
    }

    private String process(String s) {
        String[] s1 = s.split("@");
        // process local part
        String[] s2 = s1[0].split("\\+");
        System.out.println(s2[0]);
        // process local part that's before the first +
        String[] s3 = s2[0].split("[.]");

        // combine all fragments after removing .
        String res = "";
        for (String frag : s3) {
            System.out.println(frag);
            res = res + frag;
        }
        res =  res + ("@" + s1[1]);
        return res.toLowerCase();
    }
}
