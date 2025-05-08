package 代码随想录.二叉树;

import 代码随想录.二叉树.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class 递归遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        preorder(root,arrayList);
        return arrayList;
    }
    public void preorder(TreeNode root,List<Integer> arrayList) {
        if(root==null){
            return;
        }
        arrayList.add(root.val);
        preorder(root.left,arrayList);
        preorder(root.right,arrayList);
    }

}
