package javasrc;

public class MaxPathSumBTNode2Node {
    public int maxPathSum(TreeNode root) {
        // Write your solution here
        int[] max = new int[] {Integer.MIN_VALUE};
        maxPath(root, max);
        return max[0];
    }
    private int maxPath(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int left = maxPath(root.left, max);
        int right = maxPath(root.right, max);
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        max[0] = Math.max(Math.max(left, right) + root.key, max[0]);
        return Math.max(left, right) + root.key;

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
