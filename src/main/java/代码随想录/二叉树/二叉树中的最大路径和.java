package 代码随想录.二叉树;

public class 二叉树中的最大路径和 {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        track(root);
        return max;
    }

    private int track(TreeNode root) {
        if(root==null)return 0;
        int left = track(root.left);
        int le = Math.max(left, 0);
        int right = track(root.right);
        int ri = Math.max(right, 0);
        int aa=le+ri+root.val;
        //最终结果返回的是左右一块的最大值
        max=Math.max(max,aa);
        //递归返回的是左右的最大值
        return root.val+Math.max(le,ri);
    }


}
