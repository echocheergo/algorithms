package javasrc;

public class AllUniqueChar {
    public boolean allUnique(String word) {
        // Write your solution here
        int[] map = new int[8];
        char[] arr = word.toCharArray();
        for (char c : arr) {
            if ((map[c / 32] >>> (c % 32) & 1) != 0) {
                return false;
            }
            map[c / 32] |= 1 << (c % 32);
        }
        return true;
    }
}
