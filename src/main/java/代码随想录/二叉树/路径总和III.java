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
        //map里判断前面是不是有这个值，有就加上
        if(map.containsKey(sum-targetSum)&&map.get(sum-targetSum)>=1){
            res+=map.get(sum-targetSum);
        }
        //递归和回溯
        map.put(sum,map.getOrDefault(sum,0)+1);
        rootSum(root.left,targetSum);
        rootSum(root.right,targetSum);
        //最终回溯肯定要把map里这个值去掉，这里0就是不存在，1就是存在，这样多份一样的路径可以都加上
        map.put(sum,map.getOrDefault(sum,0)-1);
        sum-=root.val;
    }



}
