package javasrc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SerializeBinaryTree {

    public Node SerializeBinaryTree(TreeNode root) {

        // Inorder DDL
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        Node prev = null;
        Node dummy = new Node(0);
        Node head = dummy;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } //cannot go left meaning hit the leaf, need to go right and it's the head node
            cur = stack.pop();
            head.next = new Node(cur.val);
            head.next.before = head;
            cur = cur.right;
            head = head.next;
        }
        return dummy.next;

    }

}
class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
}
 class Node {
    int val;
    Node next;
    Node before;
    Node(int x) {
        val = x;
    }
}

