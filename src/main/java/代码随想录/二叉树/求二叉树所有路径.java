package 代码随想录.二叉树;

import java.util.ArrayList;
import java.util.List;

public class 求二叉树所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> paths = new ArrayList<>();
        traversal(root,paths,res);
        return res;
    }
    private void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        //因为我们是到叶子节点就结束了，所以我们需要将中的处理逻辑放在判断前面
        paths.add(root.val);
        if(root.right==null&&root.left==null){
            StringBuilder sb = new StringBuilder();
            // StringBuilder用来拼接字符串，速度更快
            for (int i = 0; i < paths.size()-1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));// 记录最后一个节点
            res.add(sb.toString());
            return;
        }
        if(root.left!=null){
            //这里有递归就要有回溯
            traversal(root.left,paths,res);
            paths.remove(paths.size()-1);
        }
        if(root.right!=null){
            traversal(root.right,paths,res);
            paths.remove(paths.size()-1);
        }

    }
}
