package 代码随想录.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 迭代遍历 {
    //前序遍历的基础上改一些就是后序，但是中序遍历不同的写法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);//中左右，中！
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);//中处理结束

            if (node.right != null){//先加入右边，栈先进后出，所以先处理左孩子
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }

        }
        return result;
    }
    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
