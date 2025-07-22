package 代码随想录.二叉树;

public class 二叉树的直径 {

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int depth1 = depth(root.left) + 1;
        int depth2 = depth(root.right) + 1;
        ans = Math.max(ans, depth1 + depth2);
        return Math.max(depth1, depth2);
    }
}
