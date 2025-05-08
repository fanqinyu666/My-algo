package 代码随想录.二叉树;

public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        //前序遍历
        //任务是交换左右孩子
        swapChildren(root);
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    private void swapChildren(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }


    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }



}
