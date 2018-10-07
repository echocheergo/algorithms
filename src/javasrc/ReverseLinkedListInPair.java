package javasrc;

public class ReverseLinkedListInPair {
    public ListNode reverseInPairs(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = reverseInPairs(next.next);
        next.next = head;
        return next;
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
