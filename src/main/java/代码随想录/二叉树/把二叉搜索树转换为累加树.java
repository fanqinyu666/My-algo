package 代码随想录.二叉树;

public class 把二叉搜索树转换为累加树 {
    TreeNode pre;
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }

        convertBST(root.right);
        if(pre!=null){
            root.val= root.val+pre.val;
        }
        pre=root;
        convertBST(root.left);
        return root;
    }

}
