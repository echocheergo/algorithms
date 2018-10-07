package javasrc;

public class MergeSortLinkedList {
    public ListNode mergeSort(ListNode head) {
        // Write your solution here
        // split, remember cut tail
        //base case: null and single node
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(midNext);
        ListNode newhead = merge(l, r);
        return newhead;
    }

    // two pointers find mid
    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //merge
    private ListNode merge(ListNode l, ListNode r) {
        ListNode newHead = null;
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }

        if (l.value < r.value) {
            newHead = l;
            newHead.next = merge(l.next, r);
        } else {
            newHead = r;
            newHead.next = merge(l, r.next);
        }
        return newHead;
    }

    class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }
}
