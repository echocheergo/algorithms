package javasrc;

import java.util.HashSet;
import java.util.Set;

public class UberLargestConsecutiveSequence {
    //check if i-1 / i+1 exist: sort or use set(duplicates here not matter)
    public int longestConsecutive(int[] nums) {
        /*HashSet set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int max = 0;
        for(int i : nums){
            if(!set.contains(i-1)){
                int count = i;
                while(set.contains(count)){
                    count++;
                }
                max = Math.max(count - i, max);
            }
        }
        return max;*/
        if(nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<Integer>();

        for(int num: nums) set.add(num);
        int max = 1;
        for(int num: nums) {
            if(set.remove(num)) {//num hasn't been visited
                int val = num;
                int sum = 1;
                while(set.remove(val-1)) val--;
                sum += num - val;

                val = num;
                while(set.remove(val+1)) val++;
                sum += val - num;

                max = Math.max(max, sum);
                if (set.isEmpty()) {
                    break;
                }
            }
        }
        return max;
    }
}
