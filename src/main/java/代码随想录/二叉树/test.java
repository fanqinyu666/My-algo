package 代码随想录.二叉树;

public class test {

    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        brack(root);
        return max;
    }

    private int brack(TreeNode root) {
        if(root==null)return 0;
        int l = brack(root.left);
        int r = brack(root.right);
        int val = root.val;
        if(l>0)val+=l;
        if(r>0)val+=r;
        max=Math.max(val,max);
        return Math.max(Math.max(l,r),0)+root.val;
    }

}