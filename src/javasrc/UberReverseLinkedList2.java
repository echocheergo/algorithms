package javasrc;

public class UberReverseLinkedList2 {
    public ListNode UberReverseLinkedList2(ListNode head, int m, int n) {
        // idea 1: find the node before list to be reversed
        // prev-start-next; keep insert next after pre, update start.next to make sure it's pointing to the tail
        if (head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for (int i = 0; i < m - 1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;
        // idea 2: reverse that part one by one, before the last; reverse the last one separately, reconnect
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        int count = 0;
//        ListNode start = dummy;
//        // find the start of reverse
//        while (count < m - 1) {
//            start = start.next;
//            count++;
//        }
//        // iterative reverse
//        ListNode cur = start.next;
//        ListNode head2 = cur;
//        ListNode prev = new ListNode(0);
//        ListNode next = cur.next;
//
//        while (count < n - 1) {
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//            next = cur.next;
//            count++;
//        }
//        cur.next = prev;
//
//        start.next = cur;
//        head2.next = next;
//        return dummy.next;
//    }

    }
}
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

