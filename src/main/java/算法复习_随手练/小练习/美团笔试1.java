package 算法复习_随手练.小练习;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class 美团笔试1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int T = in.nextInt();
        while (T>0) {
            T--;
            int n = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();

            while (list.size() != n && in.hasNextInt()) {
                list.add(in.nextInt());
            }
            System.out.println(tes(n, list));
        }
    }
    public static int tes(int n, ArrayList<Integer> list){
        ArrayList<Integer> newIntegers = new ArrayList<>();
        for (int i = 0; i < list.size()*2; i++)newIntegers.add(list.get(i%list.size()));

        int max=0;
        int right=1;

        while (right<newIntegers.size()){
            int sum=1;
            while (right<newIntegers.size()&&newIntegers.get(right)>=newIntegers.get(right-1)) {
                if(Objects.equals(newIntegers.get(right), newIntegers.get(right - 1)))right++;
                right++;
                sum++;
            }
            max=Math.max(max,sum);
            right++;
        }
        return max;
    }


}
