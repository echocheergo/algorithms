package javasrc;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        // two recorder: max, min,
        // one global max
        // for each point: can continue with prev or start a new
        if (nums == null || nums.length == 0) return 0;


        int max = nums[0], curMax = nums[0], curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(nums[i], curMax * nums[i]);
            curMin = Math.min(nums[i], curMin * nums[i]);
            max = Math.max(max, curMax);

        }
        return max;
    }
}
