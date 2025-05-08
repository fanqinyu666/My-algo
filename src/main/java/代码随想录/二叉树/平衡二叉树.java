package 代码随想录.二叉树;

public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)!=-1;
    }
    private int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = getHeight(root.left);
        if(left==-1){
            return -1;
        }
        int right = getHeight(root.right);
        if(right==-1){
            return -1;
        }
        int i = left - right;
        if(Math.abs(i)>1){
            return -1;
        }
        else {
            return 1+Math.max(left,right);
        }
    }


}
