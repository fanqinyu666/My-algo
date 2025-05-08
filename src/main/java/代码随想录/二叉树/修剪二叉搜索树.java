package 代码随想录.二叉树;

public class 修剪二叉搜索树 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null){
            return null;
        }
        //前序遍历
        if(root.val<low){
            //当前节点值比左边界小，但是他的右孩子可能满足条件。所以继续向右边遍历=
            TreeNode treeNode = trimBST(root.right, low, high);
            return treeNode;
        }
        if(root.val>high){
            //当前节点值比左边界小，但是他的右孩子可能满足条件。所以继续向右边遍历=
            TreeNode treeNode = trimBST(root.left, low, high);
            return treeNode;
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
