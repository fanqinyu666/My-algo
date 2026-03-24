package 算法复习_随手练.小练习;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            int[] two = two(a, b);
            for (int i = 1; i <two.length; i++) {
                System.out.println(two[i]);
            }
        }
    }
    public static int zhi(int l,int r){
        //55,66,77,88,99
        int sum=0;
        for (int i = l; i <=r; i++) {
            int sqrt = (int)Math.sqrt(i);
            if(sqrt*sqrt==i)sum++;
        }
        return sum;
    }

    //ka(n-k)+(k-1)a(n-k-1)
    public static int[] two(int a,int b){

        int[] ints = new int[b+1];
        for (int i = 1; i<=b; i++) {
            if(i<=a){
                ints[i]=1;
                continue;
            }

            ints[i]=a*ints[i-a]+(a-1)*ints[i-a-1];

        }
        return ints;
    }

    public static int zh2i(int l, int r) {
        int leftBound = (int) Math.ceil(Math.sqrt(l));//向上取整
        int rightBound = (int) Math.floor(Math.sqrt(r));//向下取整
        if (leftBound > rightBound)return 0;
        return rightBound - leftBound + 1;
    }
}