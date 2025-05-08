package 代码随想录.二叉树;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class 二叉搜索树的最小绝对差 {

    int res=Integer.MAX_VALUE;
    TreeNode node;
    public int getMinimumDifference1(TreeNode root){
        if(root==null){
            return 0;
        }
        test0(root);
        return res;
    }
    public void test0(TreeNode root){
        if(root==null){
            return;
        }
        test0(root.left);
        if(node!=null){
            res = Math.min(res, root.val - node.val);
        }
        node=root;
        test0(root.right);
        return;
    }





    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return 0;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        test(root,arrayList);

        int min=arrayList.get(1)-arrayList.get(0);
        for (int i = 1; i < arrayList.size()-1; i++) {
            int i1 = arrayList.get(i + 1) - arrayList.get(i);
            min = Math.min(min, i1);
        }
        return min;

    }
    public void test(TreeNode root,ArrayList<Integer> arrayList){
        if(root.left==null&&root.right==null){
            arrayList.add(root.val);
            return;
        }
        if(root.left!=null){
            test(root.left,arrayList);
        }
        arrayList.add(root.val);
        if(root.right!=null){
            test(root.right,arrayList);
        }
        return;
    }

}
