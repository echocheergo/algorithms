package javasrc;
public class UberPalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        char a = 'b';
        int b = a - 'a';
        System.out.println(b);

        int[] charmap = new int[256];

        int odd = 0;
        for (int i = 0; i < s.length(); i++) {
            charmap[s.charAt(i)]++;
            odd += charmap[s.charAt(i)] % 2 != 0 ? 1 : -1;

        }
        return odd <= 1;
    }
}
