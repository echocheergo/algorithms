package javasrc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class UberPalindromePermutation2 {
    public List<String> generatePalindromes(String s) {
        // assumption: all chars are covered by ascii table
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        // use a int[] since map here is not sparse
        int[] map = new int[256];
        int odd = 0;
        int n = s.length();
        // check if can for a palindrome
        for (int i = 0; i < n; i++) {
            map[s.charAt(i)]++;
            odd += map[s.charAt(i)] % 2 == 0 ? -1 : 1;
        }
        if (odd > 1) {
            return res;
        }
        // only do permutations on the first half; fill in first
        char[] arr = new char[n];
        int j = 0;
        for (int i = 0; i < 256; i++) {
            if (map[i] % 2 == 1) {
                arr[n / 2] = (char) (i);
                map[i]--;
            }
            while (map[i] > 0) {
                arr[j++] = (char) (i);
                map[i] -= 2;
            }
        }
        getPermutations(arr, 0, n, res);
        return res;
    }

    private void getPermutations(char[] arr, int ind, int n, List<String> res) {
        // base case
        if (ind == n/2) {
            for (int i = 0; i < n/2; i++) {
                arr[n - i - 1] = arr[i];
            }
            res.add(new String(arr));
        }
        HashSet<Character> seen = new HashSet<>();
        for (int i = ind; i < n / 2; i++) {
            if (!seen.contains(arr[i])) {
                seen.add(arr[i]);
                swap(arr, i, ind);
                getPermutations(arr, ind + 1, n, res);
                swap(arr, i, ind);
            }
        }
    }

    private void swap(char[] arr, int l, int r) {
        char tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
