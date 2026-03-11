package 代码随想录.图论;

import java.util.*;

public class 课程表 {

    //课程数，课程关系
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //存储图关系，需要用一个二维数组
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        //数组，存储的是入度
        int[] nums = new int[numCourses];
        for (int i = 0; i < numCourses; ++i)edges.add(new ArrayList<Integer>());//初始化

        //遍历prerequisites
        for (int[] ints : prerequisites) {
            List<Integer> integers = edges.get(ints[1]);//找到前置课程（出度）
            integers.add(ints[0]);//（加入出度）
            nums[ints[0]]++;//入度+1
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        //入度=0，将其存入队列
        for (int i = 0; i <numCourses; i++) if(nums[i] == 0)queue.offer(i);

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            //取出0，去掉他后，把它对应的出度的元素-1
            Integer poll = queue.poll();
            for (int edge : edges.get(poll)) {
                nums[edge]--;
                //他出度的元素=0，就存入队列
                if(nums[edge] == 0)queue.offer(edge);
            }
        }

        return count == numCourses;
    }

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



}
