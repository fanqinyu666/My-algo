package org.itheima.hello算法.分治.构建树问题;
import java.util.HashMap;
import java.util.Map;

public class build_tree {
    //分治方法构建二叉树
    //一个节点O(1),创建二叉树O(n)

    //设树的节点数量为 n初始化每一个节点（执行一个递归函数 dfs() ）使用 O(1)
    // 时间。因此总体时间复杂度为 O(n)

    //哈希表存储 inorder 元素到索引的映射，空间复杂度为 O(n)
    // 。在最差情况下，即二叉树退化为链表时，递归深度达到 n
    // ，使用 O(n)的栈帧空间。因此总体空间复杂度为 O(n)

    /* 构建二叉树：分治 */
    TreeNode dfs(int[] preorder, Map<Integer, Integer> inorderMap, int i, int l, int r) {
        // 子树区间为空时终止
        if (r - l < 0)
            return null;
        // 初始化根节点
        TreeNode root = new TreeNode(preorder[i]);
        // 查询 m ，从而划分左右子树
        int m = inorderMap.get(preorder[i]);
        // 子问题：构建左子树
        root.left = dfs(preorder, inorderMap, i + 1, l, m - 1);
        // 子问题：构建右子树
        root.right = dfs(preorder, inorderMap, i + 1 + m - l, m + 1, r);
        // 返回根节点
        return root;
    }

    /* 构建二叉树 */
    TreeNode buildTree(int[] preorder, int[] inorder) {
        // 初始化哈希表，存储 inorder 元素到索引的映射
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root = dfs(preorder, inorderMap, 0, 0, inorder.length - 1);
        return root;
    }
}
//数据结构课上有讲，前序和后序无法确定一个树。
