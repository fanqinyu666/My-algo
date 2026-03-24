package 字节题单;

public class 另一棵树的子树 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t==null)return false;
        return bfs(s,t);
    }
    //头部比较
    public static boolean bfs(TreeNode rootA, TreeNode rootB){
        if(rootA==null&&rootB==null)return true;
        if(rootA==null||rootB==null)return false;
        boolean l;
        boolean r;
        if(rootA.val == rootB.val){
            l = brack(rootA.left, rootB.left);
            r = brack(rootA.right, rootB.right);
            // 如果完全匹配上了，直接宣布胜利！
            if(l && r)return true;
        }
        //没匹配上，也要让他能继续走下去，所以不能进入if流程
        l = bfs(rootA.left, rootB);
        r = bfs(rootA.right, rootB);
        return l || r;
    }
    //严格比较
    public static boolean brack(TreeNode rootA, TreeNode rootB){
        if(rootA==null&&rootB==null)return true;
        if(rootA==null||rootB==null)return false;
        return brack(rootA.left,rootB.left)&& brack(rootA.right,rootB.right)&&rootA.val==rootB.val;
    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null)return false;
        //检查他自己，以及左右子树是否相等，直接暴力
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null || s.val != t.val) return false;
        return check(s.left, t.left) && check(s.right, t.right);
    }
}
