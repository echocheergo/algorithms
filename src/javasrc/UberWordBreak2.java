package javasrc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UberWordBreak2 {
    // idea: DFS + memorization: map storing <substring, list<word>> either iterate dict by checking s.startswith; or iterate s checking substring(i)
    // problem is can't deal with s and dict size unbalanced
    // better use trie + map + DFS for each seed, backtracking all possible word on each level,
    public List<String> UberWordBreak2(String s, List<String> wordDict) {
        TrieNode root = buildTrie(wordDict);
        // memorization
        HashMap<String, List<String>> map = new HashMap<>();
        return backtrack(s, map, root);
    }

    private List<String> backtrack(String s, HashMap<String, List<String>> map, TrieNode root) {
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        if (s.isEmpty()) {
            res.add(s);
            map.put(s, res);
            return res;
        }
        char[] chars = s.toCharArray();
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curr.next[c - 'a'] == null) break;
            curr = curr.next[c - 'a'];
            if (curr.word != null) {
                List<String> tmp = backtrack(s.substring(curr.word.length()), map, root);
                for (String tmps : tmp) {
                    res.add(curr.word + (tmps.isEmpty() ? "" : (" " + tmps)));
                }
            }
        }
        map.put(s, res);
        return res;
    }

    class TrieNode {
        String word;
        TrieNode[] next = new TrieNode[26];
    }

    public TrieNode buildTrie(List<String> words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
}
