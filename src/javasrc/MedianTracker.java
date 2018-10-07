package javasrc;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianTracker {
    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;
    public MedianTracker() {
        // add new fields and complete the constructor if necessary.
        this.max = new PriorityQueue<>(11, Collections.reverseOrder());
        this.min = new PriorityQueue<>();
    }

    public void read(int value) {
        // write your implementation here.
        if (max.size() == 0 || value < max.poll()) {
            max.offer(value);
        } else {
            min.offer(value);
        }
        if (max.size() > min.size() + 1) {
            min.offer(max.poll());
        } else if (min.size() > max.size()) {
            max.offer(min.poll());
        }
    }

    public Double median() {
        // write your implementation here.
        int size = size();
        if (size == 0) {
            return null;
        } else if (size % 2 == 0) {
            return (max.peek() + min.peek()) / 2.0;
        } else {
            return (double) max.peek();
        }
    }
    private int size() {
        return max.size() + min.size();
    }
}


