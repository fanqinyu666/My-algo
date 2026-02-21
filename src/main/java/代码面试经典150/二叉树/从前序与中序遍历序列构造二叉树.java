package 代码面试经典150.二叉树;

public class 从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return brack(preorder,inorder);
    }

    private TreeNode brack(int[] preorder, int[] inorder) {
        if(preorder.length==1)return new TreeNode(preorder[0]);
        if(preorder.length==0)return null;
        int num = preorder[0];
        int mid =0;
        for (; mid < inorder.length; mid++)if (inorder[mid]==num)break;
        //得到i了
        int[] prezuo = new int[mid];
        int[] preyou = new int[inorder.length-1-mid];
        int[] inozuo = new int[prezuo.length];
        int[] inoyou = new int[preyou.length];
        //拆前序
        for (int i=0;i<prezuo.length;i++){
            prezuo[i]=preorder[i+1];
        }
        for (int i=0;i<preyou.length;i++){
            preyou[i]=preorder[i+1+mid];
        }
        //拆中序
        for (int i=0;i<inozuo.length;i++){
            inozuo[i]=inorder[i];
        }
        for (int i=0;i<inoyou.length;i++){
            inoyou[i]=inorder[i+mid+1];
        }
        TreeNode l = brack(prezuo, inozuo);
        TreeNode r = brack(preyou, inoyou);
        TreeNode treeNode = new TreeNode(preorder[0]);
        treeNode.left=l;
        treeNode.right=r;
        return treeNode;
    }

}
