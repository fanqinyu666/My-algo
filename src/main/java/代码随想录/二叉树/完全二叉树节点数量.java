package 代码随想录.二叉树;

import java.util.*;

public class 完全二叉树节点数量 {
    //后序遍历
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        int i = Math.addExact(left, right) + 1;
        return i;
    }
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
}

