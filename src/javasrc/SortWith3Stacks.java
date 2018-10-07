package javasrc;

import java.util.LinkedList;

public class SortWith3Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();
        // merge sort
        sort(s1, s2, s3, s1.size());

    }
    // give half of s1 to s2,sort s1 and s2, merge sort s1 and s2(needs to be empty)  to s3, transfer back to s1
    private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int len) {
        // base case: only one element
        if (len <= 1) {
            return;
        }
        // s2 get half of s1
        // sort s2 and s1 separately then merge
        int mid1 = len / 2;
        int mid2 = len - mid1; // odd round down so has to subtract
        for (int i = 0; i < mid1; i++) {
            s2.push(s1.pop());
        }
        sort(s2, s3, s1, mid1);
        sort(s1, s3, s2, mid2);
        int i = 0;
        int j = 0;
        while (i < mid1 && j < mid2) {
            if (s1.peek() < s2.peek()) {
                s3.push(s1.pop());
                j++;
            } else {
                s3.push(s2.pop());
                i++;
            }
        }
        while (i < mid1) {
            s3.push(s2.pop());
            i++;
        }
        while (j < mid2) {
            s3.push(s1.pop());
            j++;
        }
        // move s3 back to s1
        for (int k = 0; k < len; k++) {
            s1.push(s3.pop());
        }
    }
}
