package javasrc;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        //Binary search on number distribution
        int low = 1, high = nums.length - 1;
        while (low <= high) {
            int mid = (int) (low + (high - low) * 0.5);
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;
        // two pointer find cycle
//        int len = nums.length;
//        if (len < 2) return -1;
//        int slow = nums[0];
//        int fast = nums[0];
//        while (true) {
//            slow = nums[slow];
//            fast = nums[nums[fast]];
//            if (slow == fast) {
//                fast = nums[0];
//                while (slow != fast) {
//                    slow = nums[slow];
//                    fast = nums[fast];
//                }
//                return slow;
//            }
//        }
    }
}
