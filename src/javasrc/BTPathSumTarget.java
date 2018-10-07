package javasrc;

import java.util.HashSet;
import java.util.Set;

public class BTPathSumTarget {
    public boolean exist(TreeNode root, int target) {
        // preSum + DFS, need reset when return to last level
        if (root == null) {
            return false;
        }
        Set<Integer> preSumdict = new HashSet<>();
        preSumdict.add(0);
        return exist(root, 0, preSumdict, target);
    }
    private boolean exist(TreeNode root, int prevSum, Set<Integer> preSumdict, int target) {
        prevSum += root.key;
        if (preSumdict.contains(prevSum - target)) {
            return true;
        }
        boolean needRemove = preSumdict.add(prevSum);
        if (root.left != null && exist(root.left, prevSum, preSumdict, target)) {
            return true;
        }
        if (root.right != null && exist(root.right, prevSum, preSumdict, target)) {
            return true;
        }
        if (needRemove) {
            preSumdict.remove(prevSum);
        }
        return false;
    }
    class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }
}
