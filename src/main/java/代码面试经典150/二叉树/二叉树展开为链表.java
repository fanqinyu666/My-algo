package 代码面试经典150.二叉树;

public class 二叉树展开为链表 {
    public void flatten(TreeNode root){
        brack(root);
    }

    private void brack(TreeNode root) {
        if(root==null)return;
        brack(root.left);
        brack(root.right);
        if(root.left!=null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left=null;
            root.right=left;
            while (root.right!=null){
                root=root.right;
            }
            root.right=right;
        }
    }

}
