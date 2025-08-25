package 代码随想录.二叉树;

import java.util.ArrayList;

public class 二叉树展开为链表 {

    ArrayList<TreeNode> arrayList=new ArrayList<TreeNode>();
    public void flatten(TreeNode root) {
        if(root==null){return;}
        track(root);
        TreeNode treeNode = arrayList.get(0);
        treeNode.right=null;
        treeNode.left=null;
        for (int i = 1; i < arrayList.size(); i++) {
            TreeNode treeNode1 = arrayList.get(i);
            treeNode1.left=null;
            treeNode1.right=null;
            treeNode.right =treeNode1;
            treeNode=treeNode.right;
        }
    }

    private void track(TreeNode root) {
        if(root==null)return;
        arrayList.add(root);
        track(root.left);
        track(root.right);
    }

    //空间复杂度O（1），前驱节点
    public void flatten2(TreeNode root) {
        TreeNode curr = root;
        while (curr!=null){
            //左节点不为空，操作
            if (curr.left != null) {
                //先保存原来的左右节点
                TreeNode left = curr.left;
                TreeNode right = curr.right;

                left.right = right;
                curr.right = left;
                curr.left = null;
                while (curr.left == null) {
                    curr = curr.right;
                }
            }
        }
    }



}
