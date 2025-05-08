package 代码随想录.二叉树;

public class 对称二叉树 {
    public boolean isSymmetric1(TreeNode root) {
        return compare(root.left, root.right);
    }
    private boolean compare(TreeNode left, TreeNode right) {
        //四种终止条件！
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        //左空，右不为空，左不空，右为空
        //左右都是空，返回true


        //妙啊，这样就是左的左和右的右比较
        //左的右和右的左比较！
        // 比较外侧
        boolean compareOutside = compare(left.left, right.right);
        // 比较内侧
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }
}
