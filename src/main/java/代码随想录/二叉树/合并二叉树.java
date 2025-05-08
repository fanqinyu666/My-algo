package 代码随想录.二叉树;

public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }


        TreeNode root = new TreeNode();
        if (root1 != null && root2 != null) {
            root.val = root1.val + root2.val;
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
        } else if (root1 != null && root2 == null) {
            root.val = root1.val;
            root.left = mergeTrees(root1.left, null);
            root.right = mergeTrees(root1.right, null);
        } else if (root1 == null && root2 != null) {
            root.val = root2.val;
            root.left = mergeTrees(null, root2.left);
            root.right = mergeTrees(null, root2.right);
        }
        return root;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }
}
