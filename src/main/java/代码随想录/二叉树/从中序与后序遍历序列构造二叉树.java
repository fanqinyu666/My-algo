package 代码随想录.二叉树;

public class 从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //终止条件是后序数组为空，具体为什么是这样我也不知道
        //为0就是空节点，直接返回
        if(postorder.length==0){
            return null;
        }
        //这样至少有一个节点了
        TreeNode treeNode = new TreeNode();
        treeNode.val = postorder[postorder.length - 1];

        if(postorder.length==1){
            //这才是真正的终止条件吧
            return treeNode;
            //就剩一个，说明就是叶子节点了。可以返回，但是你要返回到哪里呢？在下面节点的右孩子或者左孩子会接住他
        }
        int index=0;
        for (; index< inorder.length-1; index++) {
            if(inorder[index]==treeNode.val){
                break;//找到即返回，这样index现在的值就是在中序数组出现的下标值
            }
        }

        //左中序
        int[] leftin = new int[index];
        for (int i = 0; i < index; i++) {
            leftin[i]=inorder[i];
        }
        //右中序
        int[] rightin = new int[inorder.length-index-1];
        for (int i = 0; i < inorder.length-index-1; i++) {
            rightin[i]=inorder[i+index+1];
        }
        //左后序
        int[] leftpo = new int[leftin.length];
        for (int i = 0; i < leftin.length; i++) {
            leftpo[i]=postorder[i];
        }
        //右后序
        int[] rightpo = new int[rightin.length];
        for (int i =0; i <rightin.length; i++) {//3
            rightpo[i]=postorder[i+leftpo.length];
        }

        //左中序和左后序
        treeNode.left=buildTree(leftin,leftpo);
        //右中序和右后序
        treeNode.right=buildTree(rightin,rightpo);
        return treeNode;
    }

}
