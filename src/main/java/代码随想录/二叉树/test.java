package 代码随想录.二叉树;

public class test {

    public int res =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        brack(root);
        return res;
    }

    private int brack(TreeNode root) {
        if(root==null)return 0;
        int left = brack(root.left);
        int right = brack(root.right);
        int val = root.val;
        if(left>0)val+=left;
        if(left>0)val+=right;
        //res=Math.max(res,left+right+root.val);
        res=Math.max(res,val);
        return Math.max(left,right)+root.val;
    }

}