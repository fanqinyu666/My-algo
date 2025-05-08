package 代码随想录.二叉树;

public class 将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) { // 处理空数组
            return null;
        }

        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // 构建左子树数组
        int[] leftSub = new int[mid];
        for (int i = 0; i < mid; i++) {
            leftSub[i] = nums[i];
        }

        // 构建右子树数组
        int[] rightSub = new int[nums.length - mid - 1];
        for (int i = 0; i < rightSub.length; i++) {
            rightSub[i] = nums[i + mid + 1]; // 修正索引错误
        }

        root.left = sortedArrayToBST(leftSub);
        root.right = sortedArrayToBST(rightSub);
        return root;
    }

}
