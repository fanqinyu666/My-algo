package 代码随想录.二叉树;

import java.util.HashMap;

public class test {

    int count=0;
    long pre=0;
    HashMap<Long,Integer> map=new HashMap<>();
    public int pathSum(TreeNode root, long targetSum) {
        map.put(0L,1);
        track(root,targetSum);
        return count;
    }

    private void track(TreeNode root, long targetSum) {
        if(root==null)return;

        pre+=root.val;
        if(map.containsKey(pre-targetSum)&&map.get(pre-targetSum)>0){
            count+=map.get(pre-targetSum);
        }
        map.put(pre,map.getOrDefault(pre,0)+1);
        track(root.left,targetSum);
        track(root.right,targetSum);
        map.put(pre,map.getOrDefault(pre,0)-1);
        pre-=root.val;
    }

}