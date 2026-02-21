package 代码面试经典150.二叉树;

public class 相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return brack(p,q);
    }

    private boolean brack(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        boolean l = brack(p.left, q.left);
        boolean r = brack(p.right, q.right);
        return l&&r&&p.val==q.val;
    }
}
