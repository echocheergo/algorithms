package javasrc;

import java.util.stream.Stream;
// PQ; binary reduction
public class MergeKLinkedList {
    public ListNode mergeKLists(ListNode[] nodes) {
        if(nodes == null || nodes.length == 0)
            return null;
        return Stream.of(nodes).parallel().reduce(null, (ln, rn) -> {
            if(ln == null || rn == null)
                return ln == null ? rn : ln;
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while(ln != null && rn != null){
                if(ln.val < rn.val){
                    cur.next = ln;
                    ln = ln.next;
                }else{
                    cur.next = rn;
                    rn = rn.next;
                }
                cur = cur.next;
            }
            cur.next = ln == null ? rn : ln;
            return dummy.next;
        });
    }
        /*if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length < 2) {
            return lists[0];
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val == l2.val) {
                    return 0;
                }
                return l1.val > l2.val ? 1 : -1;
            }
        });
        ListNode dummy = new ListNode(0);
        for (ListNode n : lists) {
            if (n != null) {
                pq.offer(n);
            }
        }
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            cur.next = tmp;
            if(tmp.next != null) {
                pq.offer(tmp.next);
            }
            cur = cur.next;
        }
        return dummy.next;


    }*/
        /*if (lists == null || lists.length == 0) {
            return null;
        }

        return sortByPartition(lists, 0, lists.length - 1);
    }

    private ListNode sortByPartition(ListNode[] lists, int start, int end) {

        if (start == end) { // base case
            return lists[start];
        }

        int middle = start + (end - start) / 2;
        ListNode left = sortByPartition(lists, start, middle);
        ListNode right = sortByPartition(lists, middle + 1, end);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {

        if (left == null || right == null) { // base case
            return left == null ? right : left;
        }

        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }

    }*/
        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) { val = x; }
        }
}
