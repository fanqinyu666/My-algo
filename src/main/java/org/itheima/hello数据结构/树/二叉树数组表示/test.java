package org.itheima.hello数据结构.树.二叉树数组表示;

import java.util.ArrayList;
import java.util.List;

public class test {
    private List<Integer> tree;

    public test(List<Integer> arr) {
        tree=new ArrayList<>(arr);
    }
    public int size(){
        return tree.size();
    }

    public Integer val(int i){
        if(i<0||i>=tree.size())
            return null;
        return tree.get(i);
    }

    /* 获取索引为 i 节点的左子节点的索引 */
    public Integer left(int i) {
        return 2 * i + 1;
    }

    /* 获取索引为 i 节点的右子节点的索引 */
    public Integer right(int i) {
        return 2 * i + 2;
    }

    /* 获取索引为 i 节点的父节点的索引 */
    public Integer parent(int i) {
        return (i - 1) / 2;
    }

    /* 层序遍历 */
    public List<Integer> levelOrder(){
        List<Integer> res = new ArrayList<>();
        // 直接遍历数组
        for (int i = 0; i < size(); i++) {
            if (val(i) != null)
                res.add(val(i));
        }
        /*
        for (int t:tree) {
            if(val(i)!=null)
        }
        */
        return res;
    }

    /* 深度优先遍历 */
    private void dfs(Integer i, String order, List<Integer> res) {
        // 若为空位，则返回
        if (val(i) == null)
            return;

        // 前序遍历
        if ("pre".equals(order))
            res.add(val(i));
        dfs(left(i), order, res);

        // 中序遍历
        if ("in".equals(order))
            res.add(val(i));
        dfs(right(i), order, res);

        // 后序遍历
        if ("post".equals(order))
            res.add(val(i));
    }



    /* 前序遍历 */
    public List<Integer> preOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "pre", res);
        return res;
    }

    /* 中序遍历 */
    public List<Integer> inOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "in", res);
        return res;
    }

    /* 后序遍历 */
    public List<Integer> postOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "post", res);
        return res;
    }

}
