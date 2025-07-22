package 代码随想录.二叉树;

import 代码随想录.链表.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的右视图 {

    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)return new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        arrayList.add(deque.getLast().val);
        int sum=1;

        while (!deque.isEmpty()){
            for (int i = 0; i < sum; i++) {
                TreeNode pop = deque.removeFirst();
                if(pop.left!=null){deque.addLast(pop.left);}
                if(pop.right!=null){deque.addLast(pop.right);}
            }
            sum=deque.size();
            if(sum > 0){arrayList.add(deque.getLast().val);}
        }
        return arrayList;
    }

}
