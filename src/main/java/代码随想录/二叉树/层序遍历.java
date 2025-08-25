package 代码随想录.二叉树;

import java.util.*;

public class 层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> lists = new ArrayList<>();
        //双向队列,不会拼，差不多这个意思
        Deque<TreeNode> deque=new LinkedList<>();

        deque.push(root);
        int count=deque.size();
        while(!deque.isEmpty()){
            ArrayList<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<count;i++){
                //移除
                TreeNode wss =deque.removeFirst();
                //加入
                list.add(wss.val);
                if(wss.left!=null){
                    deque.add(wss.left);
                }
                if(wss.right!=null){
                    deque.add(wss.right);
                }
            }
            count=deque.size();
            lists.add(list);
        }
        return lists;
    }

}
