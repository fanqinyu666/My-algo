package 代码随想录.二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class 树左下角的值 {
    int curVal = 0;
    int curHeight = 0;
    public int findBottomLeftValue(TreeNode root) {
        int curHeight = 0;
        dfs(root, 0);
        return curVal;
    }

    public void dfs(TreeNode root, int depth) {
        if (root.left == null&&root.right==null) {
            if(depth>curHeight){
                curHeight=depth;
                curVal=root.val;
            }
        }
        if(root.left!=null) {
            depth++;
            dfs(root.left, depth);
            depth--;
        }
        if(root.right!=null) {
            depth++;
            dfs(root.right, depth);
            depth--;
        }
    }





    //层序遍历法
    public int findBottomLeftValue2(TreeNode root) {
        int ret=0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode p = deque.poll();
            if (p.right != null) {
                deque.offer(p.right);
            }
            if (p.left != null) {
                deque.offer(p.left);
            }
            ret = p.val;
        }
        return ret;
    }
}
