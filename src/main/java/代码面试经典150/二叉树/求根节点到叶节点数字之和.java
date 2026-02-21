package 代码面试经典150.二叉树;

import java.util.logging.Level;

public class 求根节点到叶节点数字之和 {
    int count;
    public int sumNumbers(TreeNode root) {
        brack(root,0);
        return count;
    }

    private void brack(TreeNode root,int num) {
        if(root.left==null&&root.right==null){
            num*=10;
            num+=root.val;
            count+=num;
            return;
        }
        num*=10;
        num+=root.val;

        if(root.left==null){
            brack(root.right,num);
            return;
        }
        if(root.right==null){
            brack(root.left,num);
            return;
        }
        brack(root.left,num);
        brack(root.right,num);
    }

    //为什么人家写的就比我少，我的为什么就罗嗦了
    public int sumNumber2(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

}
