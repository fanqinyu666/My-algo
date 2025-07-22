package 代码随想录.图论;

import java.util.*;

public class 课程表 {

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] ints = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i=0;i<prerequisites.length;i++){
            map.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            ArrayList<Integer> arrayList = map.get(prerequisites[i][1]);
            arrayList.add(prerequisites[i][0]);
            //统计每个课程的入度，1，0.1被0指向，记录0
            ints[prerequisites[i][0]]++;
        }
        Deque<Integer> deque=new LinkedList<>();
        int count=0;
        //得到入度为0的节点
        for (int i=0;i<numCourses;i++){
            if(ints[i]==0){
                deque.add(i);
                count++;
            }
        }
        //遍历入度为0的节点
        while (!deque.isEmpty()){
            Integer remove = deque.remove();
            ArrayList<Integer> arrayList = map.getOrDefault(remove, new ArrayList<>());
            //遍历队列里的节点，把该节点相邻节点的入度-1
            for (int i=0;i<arrayList.size();i++){
                Integer i1 = arrayList.get(i);
                ints[i1]--;
                if(ints[i1]==0){
                    deque.add(i1);
                    //这个节点入度为0时，入度为0的节点数+1
                    ++count;
                }
            }
        }
        return count==numCourses;
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges= new ArrayList<List<Integer>>();
        //二维集合
        int[] indeg = new int[numCourses];
        //数组
        //这种方法取巧了，因为他确定，就是整数升序排序，不会出现100，200这种可以用他，不然就用hashmap
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        //遍历prerequisites
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }

}
