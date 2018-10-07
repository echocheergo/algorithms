package javasrc;

import java.util.HashSet;
import java.util.List;

public class UberWordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // basic idea is to build a set and check if a string is breakable: DP: check left part from prev and right part from dict
        // reduce unnecessary check by using info from dict size
        // find min. max length of words in dict
        // has to be composed of words one by one so index has boundary
        // if current can break, then find next breakable position that can be reached by one word
        if(s == null || s.length() ==0 || wordDict == null || wordDict.size()==0) {
            return false;
        }

        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;
        int max = 0;
        int min = s.length();

        HashSet<String> dict = new HashSet<>();
        for (String st : wordDict) {
            max = Math.max(max, st.length());
            min = Math.min(min, st.length());
            dict.add(st);
        }
        for (int i = 0; i <= s.length() - min; i++) {
            if (breakable[i]) {
                int curEnd = Math.min(i + max, s.length());
                for (int j = Math.min(i + min, curEnd); j <= curEnd; j++) {
                    if (dict.contains(s.substring(i, j))) {
                        breakable[j] = true;
                    }
                }
            }

        }
        return breakable[s.length()];
    }
}
