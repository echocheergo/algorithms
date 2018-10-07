package javasrc;

import java.util.Arrays;
// two copy remains
public class ArrayDeduplication2 {
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array.length < 3) {
            return array;
        }
        int slow = 1;
        for (int fast = 2; fast < array.length; fast++) {
            if (array[fast] == array[slow - 1]) {
                continue;
            }
            array[++slow] = array[fast];
        }
        return Arrays.copyOf(array, slow + 1);
    }
}
