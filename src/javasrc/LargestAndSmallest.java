package javasrc;

public class LargestAndSmallest {
    // compare in pairs O(3/2n)
    public int[] largestAndSmallest(int[] array) {
        // Write your solution here
        // compare in pairs
        int n = array.length;
        int[] res = new int[2];
        if (n % 2 == 0) {
            res[0] = Math.max(array[0], array[1]);
            res[1] = Math.min(array[0], array[1]);
            return helper(array, 2, res, n);
        }
        res[0] = array[0];
        res[1] = array[0];
        return helper(array, 1, res, n);

    }
    private int[] helper(int[] array, int s, int[] res, int n) {
        while (s < n) {
            int min;
            int max;
            if (array[s] < array[s + 1]) {
                min = array[s];
                max = array[s + 1];
            } else {
                min = array[s + 1];
                max = array[s];
            }
            res[0] = Math.max(res[0], max);
            res[1] = Math.min(res[1], min);
            s += 2;
        }
        return res;
    }

}
