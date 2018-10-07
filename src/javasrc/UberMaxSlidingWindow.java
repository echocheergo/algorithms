package javasrc;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class UberMaxSlidingWindow {
    public int[] UberMaxSlidingWindow(int[] nums, int k) {
        // naive max heap + index + lazy delete
        // deque keep elements in deque descending, pollLast when gets bigger num. pollFirst when out of bound
        List<Integer> max;
        max = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            while(!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            dq.offerLast(i);
            if (i >= k - 1) {
                max.add(nums[dq.peekFirst()]);
            }
        }
        int[] res = new int[max.size()];
        for (int i = 0; i < max.size(); i++) {
            res[i] = max.get(i);
        }
        return res;
    }
}
