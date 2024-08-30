package org.itheima.hello算法.回溯.初识回溯.三个例子和框架;
import org.itheima.hello算法.回溯.初识回溯.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 正常回溯 {
    //给定一棵二叉树，搜索并记录所有值为7的节点，请返回节点列表。
    /* 前序遍历：例题一 */
    private List<TreeNode> res=new ArrayList<>();
    void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val == 7) {
            // 记录解
            res.add(root);
        }
        preOrder(root.left);
        preOrder(root.right);
    }


}
//回溯算法（backtracking algorithm）是一种通过穷举来解决问题的方法，
// 它的核心思想是从一个初始状态出发，暴力搜索所有可能的解决方案，当遇到正
// 确的解则将其记录，直到找到解或者尝试了所有可能的选择都无法找到解为止。


//之所以称之为回溯算法，是因为该算法在搜索解空间时会采用“尝试”与“回退”的策略。当算法在搜索过程中遇到某个状态无法继续前进或无法得到满足条件的解时，它会撤销上一步的选择，退回到之前的状态，并尝试其他可能的选择。
//
//对于例题一，访问每个节点都代表一次“尝试”，而越过叶节点或返回父节点的 return 则表示“回退”。
//
//值得说明的是，回退并不仅仅包括函数返回。为解释这一点，我们对例题一稍作拓展。