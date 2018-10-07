package javasrc;

import java.util.LinkedList;
// each round sort one, s2 as buffer, consider replicates
public class SortWith2Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        // Write your solution here.
        sort(s1,s2,0, s1.size());
        return;
    }
    private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, int sorted, int size) {
        if (sorted == size) {
            return;
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        while (s1.size() > sorted) {
            if (min > s1.peekLast()) {
                count = 1;
                min = s1.peekLast();
            } else if (min == s1.peekLast()){
                count++;
            }
            s2.offerLast(s1.removeLast());
        }
        for (int i = 0; i < count; i++) {
            s1.offerLast(min);
            sorted++;
        }
        while (s2.size() > 0) {
            if (s2.peekLast() > min) {
                s1.offerLast(s2.removeLast());
            } else {
                s2.removeLast();
            }
        }
        sort(s1, s2, sorted, size);
    }
}
