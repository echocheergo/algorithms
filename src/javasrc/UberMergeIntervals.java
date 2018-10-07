package javasrc;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class UberMergeIntervals {
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public List<Interval> merge(List<Interval> intervals) {
        // sort then iterate to merge
        // in place, replace if needed then remove, use iterator
        if (intervals == null) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) {
                    return i1.end - i2.end;
                }
                return i1.start - i2.start;
            }
        });
        Iterator<Interval> itv = intervals.iterator();
        Interval prev = itv.hasNext() ? itv.next() : null;
        while (itv.hasNext()) {
            Interval cur = itv.next();
            if (prev.end >= cur.start) {
                prev.end = Math.max(cur.end, prev.end);
                itv.remove();
            } else {
                prev = cur;
            }
        }
        return intervals;
        /*List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        // sort
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start == i2.start) {
                    return i1.end - i2.end;
                }
                return i1.start - i2.start;
            }
        });
        for (Interval i : intervals) {
            pq.offer(i);
        }
        res.add(pq.poll());
        while (!pq.isEmpty()) {
            Interval i = pq.poll();
            Interval prev = res.get(res.size() - 1);
            if (i.start > prev.end) {
                res.add(i);
            } else {
                prev.end = Math.max(i.end, prev.end);
            }
        }
        return res;*/
    }
}
