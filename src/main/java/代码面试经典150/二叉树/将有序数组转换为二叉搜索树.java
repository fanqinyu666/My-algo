package 代码面试经典150.二叉树;

public class 将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return brack(nums,0,nums.length-1);
    }

    private TreeNode brack(int[] nums, int l, int r) {
        if(l>r)return null;
        int mid=l+(r-l)/2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        TreeNode left = brack(nums, l, mid - 1);
        TreeNode right = brack(nums, mid + 1, r);
        treeNode.left=left;
        treeNode.right=right;
        return treeNode;
    }


}
