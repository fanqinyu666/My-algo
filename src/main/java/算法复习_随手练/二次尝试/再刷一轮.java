package 算法复习_随手练.二次尝试;

public class 再刷一轮 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return brack(root,p,q);
    }

    private TreeNode brack(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        TreeNode l = brack(root.left, p, q);
        TreeNode r = brack(root.right, p, q);
        if(root.val==p.val||root.val==q.val)return root;
        if(l!=null&&r!=null)return root;
        if(l!=null)return l;
        if(r!=null)return r;
        return null;
    }



}
