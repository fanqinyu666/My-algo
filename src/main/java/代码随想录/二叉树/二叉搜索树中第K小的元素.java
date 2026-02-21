package 代码随想录.二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class 二叉搜索树中第K小的元素 {

    Deque<TreeNode> deque=new LinkedList<>();
    public int kthSmallest(TreeNode root, int k) {
        track(root,k);
        for (int i = 0; i < k-1; i++) {
            deque.pop();
        }
        return deque.pop().val;
    }

    private void track(TreeNode root,int k) {
        if(root==null)return;
        track(root.left, k);
        deque.addLast(root);
        track(root.right, k);
    }


}
