package javasrc;

public class CheckLinkedListIsPalindrome {
    public boolean isPalindrome(ListNode head) {
        // Write your solution here
        // talk see if input has to be untouched
        // find mid, and reverse
        // check if identical
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode reversed = reverse(midNext);
        return checkIdentical(reversed, head);
    }
    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        //ListNode cur = head;
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    private boolean checkIdentical(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return true;
        }
        if (l1.value == l2.value) {
            return checkIdentical(l1.next, l2.next);
        }
        return false;
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
