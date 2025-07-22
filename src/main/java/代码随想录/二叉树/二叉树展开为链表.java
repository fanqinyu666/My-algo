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


}
