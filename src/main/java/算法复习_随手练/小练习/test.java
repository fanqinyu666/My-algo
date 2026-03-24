package 算法复习_随手练.小练习;

import java.util.*;

public class test {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int n = in.nextInt();
        int q = in.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            list.add(d);
            lists.add(list);
        }
        ArrayList<Integer> sort = sort(q, lists);
        for (int i=0;i<q;i++){

        }
    }

    //去重

    //点赞2.
    //评论3.
    //发布时间早4.
    //原始编号1.

    //入参，q行，入排行榜表示排名，否则是0
    public static ArrayList<Integer> sort(int q,ArrayList<ArrayList<Integer>> lists){

        PriorityQueue<ArrayList<Integer>> priorityQueue = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> t1, ArrayList<Integer> t2) {
                if(Objects.equals(t1.get(1), t2.get(1))){

                    if(Objects.equals(t1.get(2), t2.get(2))){

                        if(Objects.equals(t1.get(3), t2.get(3))){

                            return t1.get(0)-t2.get(0);
                        }
                        return t1.get(3) - t2.get(3);

                    }
                    return t1.get(2)-t2.get(2);
                }
                return t2.get(1)-t1.get(1);
            }
        });
        priorityQueue.addAll(lists);

        //去重,缺少一个变量来记录他们的原始位置
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i <priorityQueue.size(); i++)integers.add(priorityQueue.poll().get(0));
        HashSet<Integer> set = new HashSet<>();
        for (int i=0;i<integers.size();i++){
            if (set.contains(integers.get(i))) {

            }

        }
        return null;
    }








}