package org.itheima.hello算法.回溯.初识回溯.三个例子和框架;
import java.util.ArrayList;
import java.util.List;

public class 尝试与回退 {

    //在每次“尝试”中，我们通过将当前节点添加进 path 来记
    // 录路径；而在“回退”前，我们需要将该节点从 path 中弹出，以恢复本次尝试之前的状态。


    /* 前序遍历：例题二 */
    private List<List<TreeNode>> res=new ArrayList<>();
    private List<TreeNode> path=new ArrayList<>();

    void preOrder(TreeNode root) {
        if (root == null) {
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
