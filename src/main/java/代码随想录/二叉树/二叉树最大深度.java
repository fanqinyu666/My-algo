package 代码随想录.二叉树;

public class 二叉树最大深度 {

    public int maxDepth(TreeNode root) {
        int githeight = githeight(root);
        return githeight;
    }

    public int githeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int one = githeight(node.left);
        int two = githeight(node.right);
        int max = Math.max(one, two) + 1;
        return max;
    }



    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //后序遍历，左右。然后是当层的操作
        int left = minDepth(node.left);
        int right = minDepth(node.right);
        //int min = Math.min(left, right) + 1;，
        // 如果我们把刚刚的代码修改一下用，就陷入陷阱了，他会把左右有一个为null的情况记录。
        if(node.left==null&&node.right!=null){
            return right+1;
        }
        else if(node.left!=null&&node.right==null){
            return left+1;
        }else {
            return Math.min(left, right) + 1;

        }
    }

}
