package javasrc;

public class MaxSubArr53 {
    public int maxSubArray(int[] nums) {
        int subSum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            subSum += nums[i];
            max = Math.max(max, subSum);
            subSum = Math.max(subSum, 0);
        }
        return max;
        // assumption: nums not null nor empty
        /*int res = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0 ) {
                res = Math.max(nums[i], res + nums[i]);
            } else if (res < 0) {
                res = Math.max(res, nums[i]);
                max = Math.max(max, res);
            } else {
                max = Math.max(max, res);
                if (res + nums[i] < 0) {
                    res = 0;
                } else {
                    res += nums[i];
                }
            }
            System.out.println("res:" + res);
        }
        return Math.max(max, res);*/
    }
}
