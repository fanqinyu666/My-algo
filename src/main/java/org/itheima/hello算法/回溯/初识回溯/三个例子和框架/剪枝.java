package org.itheima.hello算法.回溯.初识回溯.三个例子和框架;
import java.util.ArrayList;
import java.util.List;

public class 剪枝 {
    //复杂的回溯问题通常包含一个或多个约束条件，约束条件通常可用于“剪枝”。


    /* 前序遍历：例题三 */
    private List<List<TreeNode>> res=new ArrayList<>();
    private List<TreeNode> path=new ArrayList<>();

    void preOrder(TreeNode root) {
        // 剪枝
        if (root == null || root.val == 3) {
            return;
        }
        // 尝试
        path.add(root);
        if (root.val == 7) {
            // 记录解
            res.add(new ArrayList<>(path));
        }
        preOrder(root.left);
        preOrder(root.right);
        // 回退
        path.remove(path.size() - 1);
    }

}









