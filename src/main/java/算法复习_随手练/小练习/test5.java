package 算法复习_随手练.小练习;


import java.util.*;

public class test5 {



    //                          课程数             课程关系
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

}