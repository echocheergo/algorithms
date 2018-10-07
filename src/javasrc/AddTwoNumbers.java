package javasrc;
//given two linked lists representing two non-negative numbers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Write your solution here
        if (l1 == null ) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        addTwo(dummy, l1, l2, 0);
        return dummy.next;

    }
    private void addTwo(ListNode prev, ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry != 0) {
                prev.next = new ListNode(carry);
                return;
            }
            return;
        }
        if (l1 == null) {
            int val = l2.value + carry;
            if (val >= 10) {
                prev.next = new ListNode(val - 10);
                addTwo(prev.next, l1, l2.next, 1);
            }
            prev.next = new ListNode(val);
            if (l2.next != null) {
                addTwo(prev.next, l1, l2.next, 0);
            }
        } else if (l2 == null) {
            int val = l1.value + carry;
            if (val >= 10) {
                prev.next = new ListNode(val - 10);
                addTwo(prev.next, l1.next, l2, 1);
            }
            prev.next = new ListNode(val);
            if (l1.next != null) {
                addTwo(prev.next, l1.next, l2, 0);
            }
        } else {
            int val = l1.value + l2.value + carry;
            int cur = val >= 10 ? val - 10 : val;
            carry = val >= 10 ? 1 : 0;
            prev.next = new ListNode(cur);
            addTwo(prev.next, l1.next, l2.next, carry);
        }
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
