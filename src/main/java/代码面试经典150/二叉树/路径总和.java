package 代码面试经典150.二叉树;

public class 路径总和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        boolean l = hasPathSum(root.left, targetSum-root.val);
        boolean r = hasPathSum(root.right, targetSum-root.val);
        if(root.val==targetSum&&root.left==null&&root.right==null)return true;
        return l||r;
    }

}
