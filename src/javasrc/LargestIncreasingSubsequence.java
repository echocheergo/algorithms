package javasrc;

public class LargestIncreasingSubsequence {
    public int LargestIncreasingSubsequence(int[] nums) {
        // record for 1..len subsequence the smallest num
        // replace the one that's after the largest smaller num to newly appending num
        // either to the end or in between
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 1;
        int[] endTable = new int[nums.length + 1];
        endTable[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pos = findInd(endTable, 1, len, nums[i]);
            if (pos == len) {
                endTable[++len] = nums[i];
            } else {
                endTable[++pos] = nums[i];
            }



        }
        return len;
        //DP
        /*
        int[] sol = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sol[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    sol[i] = Math.max(sol[j] + 1, sol[i]);
                }
            }
            res = Math.max(sol[i], res);
        }
        return res;*/
    }
    // find the ind of largest smaller value
    private int findInd(int[] arr, int s, int e, int key) {
        if (arr[e] < key) {
            return e + 1;
        }
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] >= key) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return e;
    }
}
