package 算法复习.小练习;

import 代码随想录.贪心.分发饼干;
import 其他算法.其他.排序算法.插入排序;

import java.util.ArrayList;
import java.util.List;

public class test2 {


    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        zhongx(root, res);
        return res;
    }

    public void zhongx(TreeNode root, List<Integer> res) {
        if (root == null) return;
        zhongx(root.left, res);
        res.add(root.val);
        zhongx(root.right, res);
    }


    public int minDepth(TreeNode root) {
        int min = min(root);
        return min;
    }

    public int min(TreeNode root) {
        if (root == null) return 0;
        int left = min(root.left);
        int right = min(root.right);
        if (root.left == null && root.right != null) return right + 1;
        if (root.left != null && root.right == null) return left + 1;
        return Math.min(left, right) + 1;
    }


    public int countNodes(TreeNode root) {
        return re(root);
    }

    public int re(TreeNode root) {
        if (root == null) return 0;

        TreeNode left = root.left;
        TreeNode right = root.right;
        int dl = 0;
        int dr = 0;
        while (left != null) {
            dl += 1;
            left = left.left;
        }
        while (right != null) {
            dr += 1;
            right = right.right;
        }
        if (dl == dr) return (2 << dl) - 1;

        int l = re(root.left);
        int r = re(root.right);
        return l + r + 1;
    }


    boolean a = true;

    public boolean isBalanced(TreeNode root) {
        es(root);
        return a;
    }

    private int es(TreeNode root) {
        if (root == null) return 0;
        int le = es(root.left);
        int ri = es(root.right);
        if (Math.abs(le - ri) > 1) a = false;
        return Math.max(le, ri) + 1;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return sis(root);
    }
    private int sis(TreeNode root) {
        if(root==null)return 0;
        int le = sis(root.left);
        int ri = sis(root.right);
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            le=root.left.val;
        }
        return le+ri;
    }








}
