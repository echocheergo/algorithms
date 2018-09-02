package java;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 1;
        int[] endTable = new int[nums.length];
        endTable[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int pos = findInd(endTable, -1, len - 1, nums[i]);
            endTable[pos] = nums[i];
            if (pos > len - 1) {
                len = pos + 1;
            }
            System.out.println("len:" + len);
            System.out.println("pos:" + pos);
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
    private int findInd(int[] arr, int s, int e, int key) {
        if (arr[e] < key) {
            return e + 1;
        }
        while (e - 1 > s) {
            int mid = s + (e - s) / 2;
            if (arr[mid] >= key) {
                e = mid;
            } else {
                s = mid;
            }
        }
        return e;
    }
}
