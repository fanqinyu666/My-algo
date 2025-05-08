package 代码随想录.二叉树;

import java.util.ArrayList;

public class 验证二叉搜索树 {
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 左
        boolean left = isValidBST(root.left);
        // 中
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;
        // 右
        boolean right = isValidBST(root.right);

        return  right&&left;
    }




    public boolean isValidBST2(TreeNode root){
        ArrayList<Integer> arrayList=new ArrayList<>();
        if(root==null){
            return true;
        }
        test(root,arrayList);
        for (int i = 0; i < arrayList.size()-1; i++) {
            if (arrayList.get(i)>=arrayList.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public void test(TreeNode root,ArrayList<Integer> arrayList) {

        if (root.left == null&&root.right==null) {
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
    }


}
