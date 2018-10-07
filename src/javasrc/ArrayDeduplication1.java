package javasrc;

import java.util.Arrays;
//one copy
public class ArrayDeduplication1 {
    public int[] dedup(int[] array) {
        // Write your solution here
        if (array.length == 0) {
            return array;
        }
        int slow = 0;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] == array[slow]) {
                continue;
            }
            array[++slow] = array[fast];
        }
        return Arrays.copyOf(array, slow + 1);

    }
}
