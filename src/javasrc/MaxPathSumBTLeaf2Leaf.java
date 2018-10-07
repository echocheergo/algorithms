package javasrc;

public class MaxPathSumBTLeaf2Leaf {
    public int maxPathSum(TreeNode root) {
        // Write your solution here
        int[] res = new int[] {Integer.MIN_VALUE};
        getMax(root, res);
        return res[0];
    }
    private int getMax(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int lcost = getMax(root.left, res);
        int rcost = getMax(root.right, res);
        if ((lcost + rcost + root.key > res[0]) && root.left != null && root.right != null) {
            res[0] = lcost + rcost + root.key;
            return Math.max(lcost, rcost) + root.key;
        }
        return root.left == null ? rcost + root.key : lcost + root.key;

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
