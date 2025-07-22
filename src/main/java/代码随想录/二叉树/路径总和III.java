package 代码随想录.二叉树;

import java.util.HashMap;
import java.util.Map;

public class 路径总和III {

    HashMap<Long,Integer> map;
    long sum;
    int res=0;
    public int pathSum(TreeNode root, long targetSum) {
        map=new HashMap<>();
        sum=0;
        map.put(0L,1);
        rootSum(root,targetSum);
        return res;
    }

    public void rootSum(TreeNode root, long targetSum) {
        if (root == null)return;
        sum+=root.val;
        if(map.containsKey(sum-targetSum)&&map.get(sum-targetSum)>=1)res+=map.get(sum-targetSum);
        map.put(sum,map.getOrDefault(sum,0)+1);
        rootSum(root.left,targetSum);
        rootSum(root.right,targetSum);
        map.put(sum,map.getOrDefault(sum,0)-1);
        sum-=root.val;
    }



}
