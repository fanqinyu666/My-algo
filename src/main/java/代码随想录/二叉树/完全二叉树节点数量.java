package 代码随想录.二叉树;

import java.util.*;

public class 完全二叉树节点数量 {

    //层序遍历
    public int countNodes2(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(root!=null) {
            deque.add(root);
        }
        int sum=0;
        while (!deque.isEmpty()){
            TreeNode pop = deque.pop();
            if(pop.left!=null){
                deque.add(pop.left);
            }
            if(pop.right!=null){
                deque.add(pop.right);
            }
            sum++;
        }
        return sum;
    }
    //完全二叉树可用


    public int countNodes(TreeNode root) {
        return re(root);
    }
    public int re(TreeNode root){
        if(root==null)return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int dl=0;
        int dr=0;
        while (left!=null){
            dl+=1;
            left=left.left;
        }
        while (right!=null){
            dr+=1;
            right=right.right;
        }
        if(dl==dr)return (2<<dl)-1;
        int l = re(root.left);
        int r = re(root.right);
        return l+r+1;
    }

}

