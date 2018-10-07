package javasrc;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> next = new HashMap<>();
    int count; // count of word that on this subtree including this node
}
class Trie {

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (!search(word)) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                TrieNode child = cur.next.get(c);
                if (child == null) {
                    child = new TrieNode();
                    cur.next.put(c, child);
                }

                cur = child;
                cur.count++;
            }
            cur.isWord = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            TrieNode child = cur.next.get(c);
            if (child == null) {
                return false;
            }
            cur = child;
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            TrieNode child = cur.next.get(c);
            if (child == null) {
                return false;
            }
            cur = child;
        }
        return cur.count > 0;
    }

    public boolean delete(String word) {
        if (!search(word)) {
            return false;
        }
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            TrieNode child = cur.next.get(c);
            child.count--;
            if (child.count == 0) {
                cur.next.remove(c, child);
                return true;
            }

            cur = child;
        }
        cur.isWord = false;
        return true;

    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
