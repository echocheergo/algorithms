package javasrc;

public class LargestNumSmallerInBST {
    class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public class Solution {
        public int largestSmaller(TreeNode root, int target) {
            // Write your solution here
            int solu = Integer.MIN_VALUE;
            TreeNode cur = root;
            while (cur != null) {
                if ((target - cur.key) > 0 && (solu == Integer.MIN_VALUE || (target - cur.key) < (target - solu))) {
                    solu = cur.key;
                }
                cur = cur.key < target ? cur.right : cur.left;
            }
            return solu;
        }
    }
}
