package javasrc;

import java.util.Arrays;

public class ArrayDeduplication4 {
    // deduplicate repeatedly (no replicate remains)
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array.length == 0) {
            return array;
        }
        int slow = -1;
        int fast = 0;
        while (fast < array.length) {
            if (slow == -1 || array[fast] != array[slow]) {
                array[++slow] = array[fast++];
            } else {
                slow--;
                int fast2 = fast;
                // 连连看
                while (fast < array.length && array[fast] == array[fast2]) {
                    fast++;
                }
            }
        }
        return Arrays.copyOf(array, slow + 1);
    }
}
