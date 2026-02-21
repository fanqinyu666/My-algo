package 代码面试经典150.二叉树;

import 代码面试经典150.链表.ListNode;

public class 完全二叉树的节点个数 {

    public int countNodes(TreeNode root) {
        return brack(root);
    }

    private int brack(TreeNode root) {
        if(root==null)return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int dl=0;
        int dr=0;
        while (left!=null){
            dl++;
            left=left.left;
        }
        while (right!=null){
            dr++;
            right=right.right;
        }
        if(dl==dr)return (2<<dl)-1;
        int i = countNodes(root.left);//左
        int l = countNodes(root.right);//右
        return i+l+1;//中
    }
}
