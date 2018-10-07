package javasrc;

public class LargestSubArrSumWithBoundary {
    public int[] largestSum(int[] array) {
        // Write your solution here
        int max = array[0];
        int currMax = array[0];
        int s = 0;
        int e = 0;
        int c = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < 0) {
                if (currMax + array[i] >= 0) {
                    currMax = currMax + array[i];
                } else {
                    c = i;
                    currMax = array[i];
                    e = i - 1;
                }
            }
            else {
                if (currMax < 0) {
                    c = i;
                    currMax = array[i];
                } else {
                    currMax += array[i];
                }
            }
            if (max < currMax) {
                s = c;
                e = i;
                max = currMax;
            }
        }
        return new int[] {max, s, e};
    }

}
