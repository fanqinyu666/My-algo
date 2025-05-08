package 代码随想录.二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 二叉搜索树中的众数 {
    int max=0;
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        ArrayList<Integer> arrayList = new ArrayList<>();
        test(root,hashMap);
        for (Map.Entry<Integer, Integer> entry:hashMap.entrySet()) {
            if (entry.getValue()==max) {
                arrayList.add(entry.getKey());
            }
        }

        int[] ints = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            ints[i]=arrayList.get(i);
        }
        return ints;
    }
    public void test(TreeNode root,HashMap<Integer,Integer> hashMap) {
        if(root==null){
            return;
        }
        test(root.left,hashMap);

        int sum=hashMap.getOrDefault(root.val,0)+1;
        hashMap.put(root.val,sum);
        max=Math.max(sum,max);

        test(root.right,hashMap);
    }


    TreeNode pre;
    int count=0;
    int maxCount=0;
    ArrayList<Integer> arrayList;
    public int[] findMode2(TreeNode root) {
        arrayList=new ArrayList<>();
        pre = null;
        test2(root);
        int[] ints = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ints[i]=arrayList.get(i);
        }
        return ints;
    }
    public void test2(TreeNode root) {
        if(root==null){
            return;
        }
        test2(root.left);
        if(pre==null){
            count=1;
        }else if (root.val==pre.val){
            count++;

        }else {
            count=1;
        }
        if(count==maxCount){
            arrayList.add(root.val);
        }
        if(count>maxCount){
            maxCount=count;
            arrayList.clear();
            arrayList.add(root.val);
        }
        pre=root;
        test2(root.right);
    }
}
