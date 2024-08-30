package org.itheima.hello数据结构.树.二叉树;


public class test {

    public static void main(String[] args) {

        // 初始化节点
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        // 构建节点之间的引用（指针）
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        TreeNode P = new TreeNode(0);
        // 在 n1 -> n2 中间插入节点 P
        n1.left=P;
        P.left=n2;

        // 删除节点 P
        n1.left = n2;

        //需要注意的是，插入节点可能会改变二叉树的原有逻辑结构，
        // 而删除节点通常意味着删除该节点及其所有子树。因此，在
        // 二叉树中，插入与删除通常是由一套操作配合完成的，以实现
        // 有实际意义的操作。
    }
}
