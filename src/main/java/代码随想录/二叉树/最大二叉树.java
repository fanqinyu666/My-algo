package 代码随想录.二叉树;

import java.util.Arrays;

public class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==1){//这道题数组不为空，不需要为空判断
            return new TreeNode(nums[0]);
        }
        //前序遍历，中处理
        int MaxValue=0;
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>MaxValue){
                MaxValue=nums[i];
                index=i;
            }
        }
        TreeNode treeNode = new TreeNode(MaxValue);//定义根节点，然后构造左子树和右子树


        if(index>=1){//这里没想到
            int[] left = new int[index];
            for (int i = 0; i < index; i++) {
                left[i]=nums[i];
            }
            treeNode.left = constructMaximumBinaryTree(left);
        }
        if(index<nums.length-1){
            int[] right = new int[nums.length-index-1];//2 6-3-1
            for (int i =0; i <nums.length-index-1; i++) {//2 6-3-1
                right[i]=nums[index+1+i];//3+1=4
            }
            treeNode.right=constructMaximumBinaryTree(right);
        }


        return treeNode;

    }
}
