package 代码面试经典150.二叉树;

public class 从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0) return null;
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;

        // 1. 后序遍历的最后一个节点就是当前的根节点
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // 2. 在中序遍历中找到根节点的位置
        int mid = inStart;
        while (mid <= inEnd) {
            if (inorder[mid] == rootVal) break;
            mid++;
        }

        // 3. 计算左子树的大小
        int leftSize = mid - inStart;

        // 4. 递归构造左子树和右子树
        // 左子树：中序 [inStart, mid - 1]，后序 [postStart, postStart + leftSize - 1]
        root.left = helper(inorder, inStart, mid - 1, postorder, postStart, postStart + leftSize - 1);

        // 右子树：中序 [mid + 1, inEnd]，后序 [postStart + leftSize, postEnd - 1]
        root.right = helper(inorder, mid + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }

}
