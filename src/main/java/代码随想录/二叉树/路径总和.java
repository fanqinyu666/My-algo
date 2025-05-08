package 代码随想录.二叉树;

public class 路径总和 {
    public static void main(String[] args) {
        路径总和 路径总和 = new 路径总和();
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return target(root, targetSum-root.val);
    }

    public boolean target(TreeNode root, int targetSum) {
        if(root.left==null&&root.right==null){
            if(targetSum==0) return true;
            else return false;
        }

        if(root.left!=null){
            targetSum=targetSum-root.left.val;
            if(target(root.left, targetSum)){
                return true;
            }
            targetSum=targetSum+root.left.val;

        }
        if(root.right!=null){
            targetSum=targetSum-root.right.val;
            if(target(root.right, targetSum)){
                return true;
            }
            targetSum=targetSum+root.right.val;
        }
        return false;
    }
}
