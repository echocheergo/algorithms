package javasrc;

import java.util.Arrays;

// no copy remains
public class ArrayDeduplication3 {
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array.length <= 1) {
            return array;
        }
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            int fast2 = fast;
            // 连连看
            while (fast < array.length && array[fast] == array[fast2]) {
                fast++;
            }
            //没有连连看
            if (fast - fast2 == 1) {
                array[slow++] = array[fast2];
            }
        }
        return Arrays.copyOf(array, slow);
    }
}
